/**
 * CompareDao Implementation
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompareDaoImpl implements CompareDao {
	
	private static final int POSITION_TEAM = 2;
	
	@Override
	public int playerComparison(float average) {
		Connection conPro = DaoFactory.createConnectionProfessional();
		Connection conInd = DaoFactory.createConnectionIndividual();
		PreparedStatement stmt = null;
		ResultSet resultSet;
		int result = -1;
		try {
			String sql = "";
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
					DaoFactory.closeConnection(conPro);
					DaoFactory.closeConnection(conInd);
				}
			}
			catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}
		return result;
	}
	
	@Override
	public String[] userPositionTeam(int userId) {
		Connection con = DaoFactory.createConnectionIndividual();
		PreparedStatement stmt = null;
		ResultSet resultSet;
		String[] result = new String[POSITION_TEAM];
		try {
			String sql = "SELECT Position, FavoriteTeam "
					+ "FROM Sport Where UserID = ? AND Sport = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, userId);
			stmt.setString(2, "Football");
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				result[1] = resultSet.getString("Position");
				result[2] = resultSet.getString("Sport");
			}
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
					DaoFactory.closeConnection(con);
				}
			}
			catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}
		return result;
	}
}
