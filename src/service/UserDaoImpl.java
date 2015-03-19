package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import model.User;

/**
 * User Dao for the SQLite connection
 * 
 * @author Paul Soiya II
 * @version March 17, 2015
 */
public class SQLiteUserDao implements UserDao {

	@Override
	public int createUser(User user) {
		Connection con = null;
		Statement stmt = null;
		int autoId = -1;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(SQLiteDaoFactory.DRIVER);
			stmt = con.createStatement();

			String sql = "INSERT INTO Users "
					+ "(Email, Password, FirstName, LastName) " + "VALUES("
					+ user.getEmail() + "," + user.getPassword() + ","
					+ user.getFirstName() + "," + user.getLastName() + ")";
			stmt.executeQuery(sql);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage());
			}
		}
		return autoId;
	}

	@Override
	public boolean updateUser(User user) {

		return false;
	}

	@Override
	public User findUser(int id) {

		return null;
	}

}
