package service;

import service.DaoFactory;

public abstract class AbstractDaoFactory {

	public abstract UserDao getUserDao();
	
	public static AbstractDaoFactory getDaoFactory(){
		return new DaoFactory();
	}
	
}
