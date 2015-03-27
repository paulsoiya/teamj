package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.User;

/**
 * User Dao 
 * 
 * @author Paul Soiya II
 * @version March 24, 2015
 */
public class UserDaoImpl implements UserDao {
    
    public User currentUser = new User();

	@Override
	public boolean createUser(User user) {
		Connection con = DaoFactory.createConnectionIndividual();
		PreparedStatement stmt = null;
		ResultSet rs;
		boolean result = true;
		try {
			String sql = "INSERT INTO User (Email, Password, FirstName, LastName, BirthDate)"
					+ "VALUES(?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getDob().getYear() + "-"
					+ user.getDob().getMonthValue() + "-"
					+ user.getDob().getDayOfMonth());
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
	public boolean updateUser(User user) {
        Connection con = DaoFactory.createConnectionIndividual();
        PreparedStatement stmt = null;
        ResultSet rs;
        boolean result = true;
        try {
            String sql = "UPDATE User set Password =?, FirstName=?, LastName=?, BirthDate=?"
            + "WHERE email=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getDob().getYear() + "-"
                           + user.getDob().getMonthValue() + "-"
                           + user.getDob().getDayOfMonth());
            stmt.setString(5, user.getEmail());
            stmt.executeUpdate();
            
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
	public User findUser(String email) {
        Connection con = DaoFactory.createConnectionIndividual();
        PreparedStatement stmt = null;
        ResultSet rs;
        User user = new User();
        try {
            String sql = "SELECT * FROM User WHERE Email=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("UserId");
                String pwd = rs.getString("Password");
                String fname = rs.getString("FirstName");
                String lname = rs.getString("LastName");
                LocalDate dob = rs.getDate("BirthDate").toLocalDate();
                user = new User(id, email, pwd, fname, lname, dob);
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
		return user;
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
        ResultSet rs;
        String storedPassword = null;
        try {
            String sql = "SELECT * FROM User WHERE Email = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while(rs.next()) {
                currentUser.setId(rs.getInt("UserID"));
                currentUser.setEmail(rs.getString("Email"));
                storedPassword = rs.getString("Password");
                currentUser.setPassword(storedPassword);
                currentUser.setFirstName(rs.getString("FirstName"));
                currentUser.setLastName(rs.getString("LastName"));
                currentUser.setDob(rs.getDate("BirthDate").toLocalDate());
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
        return passwordMatch(password, storedPassword);
    }
    
    @Override
    public boolean passwordMatch(String pass1, String pass2) {
        if (pass1 == null || pass2 == null)
            return false;
        return pass1.equals(pass2);
    }
}
