package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;

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
            stmt.close();
            DaoFactory.closeConnection(con);
        } catch (Exception e) {
            result = false;
            System.err.println(e.getClass().getName() + ": "
                                + e.getMessage());
        }
    }
    return result;
    }
}
