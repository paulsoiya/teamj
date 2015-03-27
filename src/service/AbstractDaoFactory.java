package service;

import service.DaoFactory;

public abstract class AbstractDaoFactory {

	public abstract UserDao getUserDao();
    
    public abstract GameDao getGameDao();
	
	public static AbstractDaoFactory getDaoFactory(){
		return new DaoFactory();
	}
	
}
