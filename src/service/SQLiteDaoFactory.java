package service;

/**
 * Dao factory for the SQLite database
 * @author Paul Soiya II
 * @version March 17, 2015
 */
public class SQLiteDaoFactory extends DaoFactory{

	public static final String DRIVER = "jdbc:sqlite:professional.db";
	public static final String CONNECTION = "";
	
	@Override
	public UserDao getUserDao() {
		return new SQLiteUserDao();
	}

}
