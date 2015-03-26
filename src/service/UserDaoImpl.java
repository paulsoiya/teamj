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
	public boolean createUser(User user) {
		Connection con = DaoFactory.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			stmt = con.createStatement();
			String sql = "INSERT INTO User "
					+ "(Email, Password, FirstName, LastName, BirthDate) "
					+ "VALUES('" + user.getEmail() + "','" + user.getPassword()
					+ "','" + user.getFirstName() + "','" + user.getLastName()
					+ "',' " + user.getDob().getYear() + "-"
					+ user.getDob().getMonthValue() + "-"
					+ user.getDob().getDayOfMonth() + "')";
			
			stmt.executeUpdate(sql);

		} catch (Exception e) {
            result = false;
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
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

	@Override
	public boolean updateUser(User user) {
        Connection con = DaoFactory.createConnection();
        Statement stmt = null;
        ResultSet rs = null;
        boolean result = true;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO User "
            + "(Email, Password, FirstName, LastName, BirthDate) "
            + "VALUES('" + user.getEmail() + "','" + user.getPassword()
            + "','" + user.getFirstName() + "','" + user.getLastName()
            + "',' " + user.getDob().getYear() + "-"
            + user.getDob().getMonthValue() + "-"
            + user.getDob().getDayOfMonth() + "')";
            
            stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            result = false;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
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


	@Override
	public User findUser(int id) {

		return null;
	}

	@Override
	public int findUser(String email) {
        Connection con = DaoFactory.createConnection();
        Statement stmt = null;
        ResultSet rs = null;
        int id = -1;
        try {
        stmt = con.createStatement();
        
        String sql = "SELECT UserID FROM User WHERE Email='" + email + "';";
        rs = stmt.executeQuery(sql);
        if(rs.next())
            id = rs.getInt(1);
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
		return id;
	}

}
