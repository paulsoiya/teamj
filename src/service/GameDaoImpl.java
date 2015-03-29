package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import java.sql.ResultSet;

import model.Game;

/**
 * Game Dao
 *
 * @author tdscott10
 * @version March 26, 2015
 */
public class GameDaoImpl implements GameDao {

    @Override
    public boolean addGame(Game game) {
    Connection con = DaoFactory.createConnectionIndividual();
    PreparedStatement stmt = null;
    boolean result = true;
    try {
        String sql = "INSERT INTO GameLog (UserID, Week, Date, Opponent, Score)"
                + "VALUES(?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, game.getUserID());
        stmt.setInt(2, game.getWeek());
        stmt.setString(3, game.getDate().getYear() + "-"
                + game.getDate().getMonthValue() + "-"
                +game.getDate().getDayOfMonth());
        stmt.setString(4, game.getOpponent());
        stmt.setString(5, game.getScore());
        stmt.execute();
    } catch(Exception e) {
        result = false;
        System.err.println(e.getClass().getName() + ": "
                                + e.getMessage());
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
                DaoFactory.closeConnection(con);
            }
        } catch (Exception e) {
            result = false;
            System.err.println(e.getClass().getName() + ": "
                                + e.getMessage());
        }
    }
    return result;
    }
    
    @Override
    public boolean deleteGame(int gameId) {
        Connection con = DaoFactory.createConnectionIndividual();
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "DELETE FROM GameLog "
            + "WHERE GameID = ?";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, gameId);
            stmt.execute();
            result = true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    DaoFactory.closeConnection(con);
                }
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": "
                                   + e.getMessage());
            }
        }
        return result;
    }
    
    @Override
    public Game[] findGames(int userId) {
        Connection con = DaoFactory.createConnectionIndividual();
        PreparedStatement stmt = null;
        ResultSet resultSet;
        Game games[] = null;
        int length = 0;
        try {
            String sql = "SELECT COUNT(*) FROM GameLog"
            +"WHERE UserID = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            resultSet = stmt.executeQuery();
            if(resultSet.next())
                length = resultSet.getInt("RECORDCOUNT");
            
            games = new Game[length];
            sql = "SELECT * FROM GameLog "
            + "WHERE UserID = ?";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            resultSet = stmt.executeQuery();
            
            while(resultSet.next()) {
                for(int i=0; i < length; i++) {
                    int week = resultSet.getInt("Week");
                    String opp = resultSet.getString("Opponent");
                    String score = resultSet.getString("Score");
                    LocalDate date = resultSet.getDate("Date").toLocalDate();
                    games[i] = new Game(userId, week, opp, score, date);
                }
            }
            
        } catch (Exception exc) {
            System.err.println(exc.getClass().getName() + ":" + exc.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    DaoFactory.closeConnection(con);
                }
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": "
                                   + e.getMessage());
            }
        }
        return games;
    }
}
