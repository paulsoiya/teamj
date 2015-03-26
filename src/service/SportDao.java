package service;

import model.Sport;

public interface SportDao {

	/**
	 * Creates a new sport in the Sport table
	 * @param sport
	 * @return	the auto increment id of the new sport
	 */
	public boolean addSport(Sport sport);
	
	/**
	 * Deletes a sport specified by name
	 * @param sportName
	 * @return
	 */
	public boolean deleteSport(String sportName);
	
	
}
