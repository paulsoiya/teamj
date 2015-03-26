package service;

import model.Sport;

public interface SportDao {

	/**
	 * Creates a new sport in the Sport table
	 * @param sport
	 * @return	the auto increment id of the new sport
	 */
	public int addSport(Sport sport);
	
	
}
