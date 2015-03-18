package service;

/**
 * GOF Abstract Factory Pattern for the DAO implementation
 * @author Paul Soiya II
 * @version March 17, 2015
 */
public abstract class DaoFactory {

	public static final int SQLITE = 1;
	public static final int MYSQL = 2;

	public abstract UserDao getUserDao();
	
	public static DaoFactory getDaoFactory(int type){
		
		DaoFactory daoFactory;
		
		if(type == SQLITE){
			daoFactory = new SQLiteDaoFactory();
		}else{
			daoFactory = null;
		}
		
		return daoFactory;
	}
	
}
