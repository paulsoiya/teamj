package service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Sport;


public class SportDaoImpl implements SportDao{

	@Override
	public boolean addSport(Sport sport) {
		Connection con = DaoFactory.createConnection();
		Statement stmt = null;
		boolean result = false;
		try {
			stmt = con.createStatement();
			String sql = "INSERT INTO User "
					+ "(SportName, Picture) "
					+ "VALUES('" + sport.getName() + "','" + sport.getPicture() + "')";
			
			stmt.executeUpdate(sql);

			result = true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			try {
				stmt.close();
				DaoFactory.closeConnection(con);
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage());
			}
		}
		return result;
	}

	@Override
	public boolean deleteSport(String sportName) {
		Connection con = DaoFactory.createConnection();
		Statement stmt = null;
		boolean result = false;
		try {
			stmt = con.createStatement();
			String sql = "DELETE FROM Sport "
					+ "WHERE SportName = " + sportName;
					
			stmt.executeUpdate(sql);
			result = true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			try {
				stmt.close();
				DaoFactory.closeConnection(con);
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage());
			}
		}
		return result;
	}

	
}