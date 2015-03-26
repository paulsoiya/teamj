package service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Sport;


public class SportDaoImpl implements SportDao{

	@Override
	public int addSport(Sport sport) {
		Connection con = DaoFactory.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int autoId = -1;
		try {
			stmt = con.createStatement();
			String sql = "INSERT INTO User "
					+ "(SportName, Picture) "
					+ "VALUES('" + sport.getName() + "','" + sport.getPicture() + "')";
			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				autoId = rs.getInt(1);
			}

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
		return autoId;
	}

	
}