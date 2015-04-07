package service;


public abstract class AbstractDaoFactory {
	
	public abstract UserDao getUserDao();
	
	public abstract GameDao getGameDao();
	
	public abstract SportDao getSportDao();
	
	public abstract StatsDao getStatsDao();
	
	public abstract CompareDao getCompareDao();
	
	public static AbstractDaoFactory getDaoFactory() {
		return new DaoFactory();
	}
	
}
