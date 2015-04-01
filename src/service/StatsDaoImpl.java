/**
 * StatsDao Implementation
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import model.Stats;

public class StatsDaoImpl implements StatsDao {

    @Override
    public boolean addStats(Stats stats) {
    Connection con = DaoFactory.createConnectionIndividual();
    PreparedStatement stmt = null;
    boolean result = true;
    try {
        String sql = "INSERT INTO Stats (GameID, UserID, "
        + "Yds, Tds, Att) "
        + "VALUES(?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, stats.getGameID());
        stmt.setInt(2, stats.getUserID());
        stmt.setInt(3, stats.getYards());
        stmt.setInt(4, stats.getTouchdowns());
        stmt.setInt(5, stats.getAttempts());
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
}
