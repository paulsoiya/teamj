package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;
import java.sql.SQLException;

public class DatabaseCreation {

   /*
    * Create the professional database
    * Create Tables Player, Team, GameLog, and Stats
    */
   public void createProfessionalDatabase() {
      Connection c = null;
      Statement stmt = null;

      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:professional.db");
         c.createStatement().execute("PRAGMA foreign_keys = ON");
         stmt = c.createStatement();

         String sql = "CREATE TABLE Team(" +
            "TeamID         INT    PRIMARY KEY," +
            "TeamName       TEXT," +
            "Logo           TEXT," +
            "PrimaryColor   TEXT," +
            "SecondaryColor TEXT);";
         stmt.executeUpdate(sql);

         sql = "CREATE TABLE Player(" +
            "PlayerID       INT    PRIMARY KEY," +
            "PlayerName     TEXT," +
            "Team           INT," +
            "Picture        TEXT," +
            "Height         TEXT," +
            "Weight         INT," +
            "BirthDate      TEXT," +
            "College        TEXT," +
            "Age            INT," +
            "FOREIGN KEY(Team) REFERENCES Team(TeamID));";
         stmt.executeUpdate(sql);

         sql = "CREATE TABLE GameLog(" +
            "GameID         INT    PRIMARY KEY," +
            "Date           TEXT," +
            "Team           INT," +
            "Opponent       INT," +
            "Score          TEXT," +
            "FOREIGN KEY(Team) REFERENCES Team(TeamID)," +
            "FOREIGN KEY(Opponent) REFERENCES Team(TeamID));";
         stmt.executeUpdate(sql);

         sql = "CREATE TABLE Stats(" +
            "StatsID        INT    PRIMARY KEY," +
            "GameID         INT," +
            "PlayerID       INT," +
            "RecYds         INT," +
            "RecTDs         INT," +
            "RecAtt         INT," +
            "RushYds        INT," +
            "RushTDs        INT," +
            "RushAtt        INT," +
            "PassYds        INT," +
            "PassTDs        INT," +
            "PassAtt        INT," +
            "FOREIGN KEY(GameID) REFERENCES GameLog(GameID)," +
            "FOREIGN KEY(PlayerID) REFERENCES Player(PlayerID));";
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch (Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
   }
   /*
    * Create the individual database
    */
   public void createIndividualDatabase() {

   }
}
