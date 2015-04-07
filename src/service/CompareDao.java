/**
 * CompareDao
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package service;

import model.Compare;
import model.Stats;

public interface CompareDao {
	
	/**
	 * Pulls down stats for both the User and Pro
	 * 
	 * @param average
	 * @return int of StatsID for pro player
	 */
	public boolean playerComparison(float average, String position, String favTeam);
	
	/**
	 * Returns Position and Favorite Team for user
	 * 
	 * @param userId
	 * @return String array of Position FavoriteTeam
	 */
	public String[] userPositionTeam(int userId);
}
