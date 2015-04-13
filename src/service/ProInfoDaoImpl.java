/**
 * ProInfoDao Implementation
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Apr 11, 2015
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.ProInfo;
import model.TeamInfo;

public class ProInfoDaoImpl implements ProInfoDao {

    @Override
    public ProInfo findProInfo(int statsId) {
        Connection con = DaoFactory.createConnectionProfessional();
        PreparedStatement stmt = null;
        ResultSet resultSet;
        ProInfo info = new ProInfo();
        String playerId = null;
        try {
            String sql = "SELECT PlayerID FROM Stats WHERE StatsID = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, statsId);
            resultSet = stmt.executeQuery();
            
            if(resultSet.next())
                playerId = resultSet.getString("PlayerID");
            
            sql = "SELECT * FROM Player WHERE PlayerID = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, playerId);
            resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                info.setPlayerId(resultSet.getString("PlayerID"));
                info.setName(resultSet.getString("PlayerName"));
                info.setTeam(resultSet.getString("Team"));
                info.setPosition(resultSet.getString("Position"));
                info.setPicture(resultSet.getString("Picture"));
                info.setHeight(resultSet.getInt("Height"));
                info.setWeight(resultSet.getInt("Weight"));
                info.setDOB(resultSet.getString("BirthDate"));
                info.setCollege(resultSet.getString("College"));
                info.setNumber(resultSet.getInt("Number"));
            }
            
        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": "
                               + e.getMessage());
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
        return info;
    }
    
    @Override
    public TeamInfo findTeamInfo(String teamId) {
        Connection con = DaoFactory.createConnectionProfessional();
        PreparedStatement stmt = null;
        ResultSet resultSet;
        TeamInfo info = new TeamInfo();
        String playerId = null;
        try {
            String sql = "SELECT * FROM Team WHERE TeamID = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, teamId);
            resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                info.setTeamId(resultSet.getString("TeamID"));
                info.setTeamName(resultSet.getString("TeamName"));
                info.setTeamPicture(resultSet.getString("Logo"));
                info.setPrimaryColor(resultSet.getString("PrimaryColor"));
                info.setSecondaryColor(resultSet.getString("SecondaryColor"));
            }
            
        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": "
                               + e.getMessage());
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
        return info;

    }
}