package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Dao factory for the SQLite database
 * 
 * @author Paul Soiya II
 * @version March 17, 2015
 */
public class DaoFactory extends AbstractDaoFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static String CON_URL_IND = "jdbc:mysql://localhost:3306/individual?user=root&password=password";
    public static final String CON_URL_PRO = "jdbc:mysql://localhost:3306/professional?user=root&password=password";

	public static Connection createConnectionIndividual(){
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(DaoFactory.CON_URL_IND);
			
		}catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		return con;
	}
    
    public static Connection createConnectionProfessional(){
        Connection con = null;
        
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(DaoFactory.CON_URL_PRO);
            
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return con;
    }
	
	public static void closeConnection(Connection con){
		try{
			con.close();
		}catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	@Override
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
    @Override
    public GameDao getGameDao() {
        return new GameDaoImpl();
    }
	
	public SportDao getSportDao(){
		return new SportDaoImpl();
	}

}
