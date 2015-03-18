package service;

import model.User;

public interface UserDao {

	public int createUser(User user);
	
	public boolean updateUser(User user);

	public User findUser(int id);
	
}
