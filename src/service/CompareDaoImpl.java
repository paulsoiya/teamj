/**
 * CompareDao Implementation
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
import javafx.collections.FXCollections;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import model.Compare;
import model.Stats;

public class CompareDaoImpl implements CompareDao {
    
    @Override
    public int playerComparison(Stats stats) {
        Connection conPro = DaoFactory.createConnectionProfessional();
        Connection conInd = DaoFactory.createConnectionIndividual();
        PreparedStatement stmt = null;
        ResultSet resultSet;
        int result = -1;
        Compare compare = new Compare();
        try {
            String sql = "SELECT StatsID FROM Stats WHERE RushYds LIKE ? "
            + "AND RushTDs LIKE ? AND RushAtt LIKE ?";
            stmt = conPro.prepareStatement(sql);
            stmt.setInt(1, stats.getYards());
            stmt.setInt(2, stats.getTouchdowns());
            stmt.setInt(3, stats.getAttempts());
            resultSet = stmt.executeQuery();
            if(resultSet.next())
                result = resultSet.getInt("StatsID");
            System.out.println(result);
            sql = "UPDATE Stats set ProStatsID = ? WHERE "
            + "GameID = ?";
            stmt = conInd.prepareStatement(sql);
            stmt.setInt(1, result);
            stmt.setInt(2, stats.getGameID());
            stmt.execute();
        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": "
                               + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    DaoFactory.closeConnection(conPro);
                }
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": "
                                   + e.getMessage());
            }
        }
        return result;
    }


}
