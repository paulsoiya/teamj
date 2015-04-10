package service;

import java.util.List;

import model.Team;

public interface TeamDao {
	
	/**
	 * Retrieves all teams from from the professional db team table
	 * 
	 * @param user
	 * @return the auto increment id of the new user
	 */
	public List<Team> findAll();
	
}
