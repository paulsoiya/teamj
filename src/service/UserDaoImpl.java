package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

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
		Connection con = DaoFactory.createConnectionIndividual();
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
        Connection con = DaoFactory.createConnectionIndividual();
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
        Connection con = DaoFactory.createConnectionIndividual();
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
	
	@Override
	public boolean deleteUser(String email) {
		Connection con = DaoFactory.createConnectionIndividual();
		PreparedStatement stmt = null;
		boolean result = true;
		try {
			String sql = "DELETE FROM User "
					+ "WHERE Email = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
					
			stmt.execute();
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
    public boolean loginUser(String email, String password) {
        Connection con = DaoFactory.createConnectionIndividual();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = true;
        String storedPassword = null;
        try {
            String sql = "SELECT Password FROM User WHERE UserID = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, findUser(email));
            rs = stmt.executeQuery();
            if(rs.next())
                storedPassword = rs.getString(1);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return passwordMatch(password, storedPassword);
    }

    private boolean passwordMatch(String pass1, String pass2) {
        return pass1.equals(pass2);
    }
}
