package service;

import model.User;

public interface UserDao {

	/**
	 * Creates a new user in the User table
	 * @param user
	 * @return	the auto increment id of the new user
	 */
	public int createUser(User user);
	
	/**
	 * Updates a user in the User table
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);

	/**
	 * Finds a user in the User table from an id
	 * @param id
	 * @return	the User object
	 */
	public User findUser(int id);
	
	/**
	 * Finds the user with the email address matching the parameter
	 * @param email
	 * @return	the User object
	 */
	public User findUser(String email);
	
}
