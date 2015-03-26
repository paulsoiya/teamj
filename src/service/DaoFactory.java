package service;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Dao factory for the SQLite database
 * 
 * @author Paul Soiya II
 * @version March 17, 2015
 */
public class DaoFactory extends AbstractDaoFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/individual?user=root&password=password";

	public static Connection createConnection(){
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DaoFactory.CONNECTION_URL);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection(Connection con){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
	
	public SportDao getSportDao(){
		return new SportDaoImpl();
	}

}
