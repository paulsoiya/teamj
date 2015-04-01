import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
 
public class HelloDatabase
{
    public static void main (String[] args) throws Exception
    {
        // register the driver 
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        Connection c = null;
        Statement stmt = null;
 
        try {
            c = DriverManager.getConnection("jdbc:sqlite:PlayersTest.db");
            c.createStatement().execute("PRAGMA foreign_keys = ON");
            stmt = c.createStatement();
            String sql;
            

            sql = "CREATE TABLE Player(" +
               "PlayerID       TEXT    PRIMARY KEY," +
               "PlayerName     TEXT," +
               "Team           TEXT," +
               "Height         INT," +
               "Weight         INT," +
               "BirthDate      TEXT," +
               "College        TEXT," +
               "Number         INT);";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE Stats(" +
               "StatsID        INT    PRIMARY KEY," +
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
  
      /*
       * Create the individual database
       */
          
          try {
              Class.forName("org.sqlite.JDBC");
              c = DriverManager.getConnection("jdbc:sqlite:user.db");
              c.createStatement().execute("PRAGMA foreign_keys = ON");
              stmt = c.createStatement();
              
              String sql = "CREATE TABLE User(" +
              "UserID         INTEGER    PRIMARY KEY   AUTOINCREMENT," +
              "Email          TEXT," +
              "Password       TEXT," +
              "FirstName      TEXT," +
              "LastName       TEXT);";
              stmt.executeUpdate(sql);
              
              sql = "CREATE TABLE Sport(" +
              "SportID       INT    PRIMARY KEY," +
              "SportName     TEXT," +
              "Picture       TEXT);";
              stmt.executeUpdate(sql);
              
              sql = "CREATE TABLE Stats(" +
              "StatsID        INT    PRIMARY KEY," +
              "GameID         INT," +
              "UserID         INT," +
              "RecYds         INT," +
              "RecTDs         INT," +
              "RecAtt         INT," +
              "RushYds        INT," +
              "RushTDs        INT," +
              "RushAtt        INT," +
              "PassYds        INT," +
              "PassTDs        INT," +
              "PassAtt        INT," +
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