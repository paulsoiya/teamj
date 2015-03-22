package model;

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
         Class.forName("com.mysql.jdbc.Driver");
          c = DriverManager.getConnection("jdbc:mysql://localhost:3306/professional?" +
                                          "user=root&password=password");
         stmt = c.createStatement();

         String sql = "CREATE TABLE Team(" +
            "TeamID         VARCHAR(4)    PRIMARY KEY," +
            "TeamName       VARCHAR(64)," +
            "Logo           VARCHAR(512)," +
            "PrimaryColor   VARCHAR(32)," +
            "SecondaryColor VARCHAR(32));";
         stmt.executeUpdate(sql);

         sql = "CREATE TABLE Player(" +
            "PlayerID       VARCHAR(128)    PRIMARY KEY," +
            "PlayerName     VARCHAR(128)," +
            "Team           VARCHAR(4)," +
            "Picture        VARCHAR(512)," +
            "Height         INT," +
            "Weight         INT," +
            "BirthDate      VARCHAR(32)," +
            "College        VARCHAR(64)," +
            "Number         INT," +
            "FOREIGN KEY(Team) REFERENCES Team(TeamID));";
         stmt.executeUpdate(sql);

         sql = "CREATE TABLE GameLog(" +
            "GameID         INT    PRIMARY KEY," +
            "Date           VARCHAR(32)," +
            "Team           INT," +
            "Opponent       INT," +
            "Score          VARCHAR(16)," +
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
      } catch (Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      } finally {
         try {
            stmt.close();
            c.close();
         } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
         }
      }
   }
   /*
    * Create the individual database
    */
   public void createIndividualDatabase() {
       Connection c = null;
       Statement stmt = null;
       
       try {
           Class.forName("com.mysql.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/individual?" +
                   "user=root&password=password");
           stmt = c.createStatement();
           
           String sql = "CREATE TABLE User(" +
           "UserID         INT(11)    PRIMARY KEY   AUTO_INCREMENT," +
           "Email          VARCHAR(512)," +
           "Password       VARCHAR(16)," +
           "FirstName      VARCHAR(32)," +
           "LastName       VARCHAR(32)," + 
           "BirthDate	   DATE);";
           stmt.executeUpdate(sql);
           
           sql = "CREATE TABLE Sport(" +
           "SportID       INT(11)    PRIMARY KEY	AUTO_INCREMENT," +
           "SportName     VARCHAR(64)," +
           "Picture       VARCHAR(512));";
           stmt.executeUpdate(sql);
           
           sql = "CREATE TABLE GameLog(" +
           "GameID         INT(11)    PRIMARY KEY AUTO_INCREMENT," +
           "UserID         INT(11)," +
           "Date           DATE," +
           "Team           INT(11)," +
           "Opponent       INT(11)," +
           "Score          VARCHAR(512)," +
           "FOREIGN KEY(UserID) REFERENCES User(UserID));";
           stmt.executeUpdate(sql);
           
           sql = "CREATE TABLE Stats(" +
           "StatsID        INT(11)    PRIMARY KEY	AUTO_INCREMENT," +
           "GameID         INT(11)," +
           "UserID         INT(11)," +
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
           "FOREIGN KEY(UserID) REFERENCES User(UserID));";
           stmt.executeUpdate(sql);
       } catch (Exception e) {
           System.err.println(e.getClass().getName() + ": " + e.getMessage());
       } finally {
           try {
               stmt.close();
               c.close();
           } catch (Exception e){
               System.err.println(e.getClass().getName() + ": " + e.getMessage());
           }
       }
   }
}
