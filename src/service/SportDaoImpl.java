package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Sport;


public class SportDaoImpl implements SportDao{

	@Override
	public boolean createSport(Sport sport) {
		Connection con = DaoFactory.createConnectionIndividual();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			String sql = "INSERT INTO Sport "
					+ "(SportName) "
					+ "VALUES(?)";
		
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sport.getName());
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
	public boolean deleteSport(String sportName) {
		Connection con = DaoFactory.createConnectionIndividual();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			String sql = "DELETE FROM Sport "
					+ "WHERE SportName = ?";
			
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sportName);
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

}