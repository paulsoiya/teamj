package service;

/**
 * Dao factory for the SQLite database
 * 
 * @author Paul Soiya II
 * @version March 17, 2015
 */
public class DaoFactory extends AbstractDaoFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/individual?user=root&password=password";

	@Override
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}

}
