package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.User;

/**
 * User Dao 
 * 
 * @author Paul Soiya II
 * @version March 24, 2015
 */
public class UserDaoImpl implements UserDao {

	@Override
	public int createUser(User user) {
		Connection con = DaoFactory.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int autoId = -1;
		try {
			stmt = con.createStatement();
			String sql = "INSERT INTO User "
					+ "(Email, Password, FirstName, LastName, BirthDate) "
					+ "VALUES('" + user.getEmail() + "','" + user.getPassword()
					+ "','" + user.getFirstName() + "','" + user.getLastName()
					+ "',' " + user.getDob().getYear() + "-"
					+ user.getDob().getMonthValue() + "-"
					+ user.getDob().getDayOfMonth() + "')";
			
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

	@Override
	public boolean updateUser(User user) {

		return false;
	}

	@Override
	public User findUser(int id) {

		return null;
	}

	@Override
	public User findUser(String email) {
		
		return null;
	}

}
