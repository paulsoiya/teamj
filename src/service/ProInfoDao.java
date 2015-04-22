/**
 * ProInfoDao
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Apr 11, 2015
 */
package service;

import model.ProInfo;
import model.TeamInfo;

public interface ProInfoDao {
  
    /**
     * Find Pro players information
     * @param statsId
     * @return ProInfo object
     */
    public ProInfo findProInfo(int statsId);
    
    /**
     * Find Team info
     * @param teamId
     * @return TeamInfo
     */
    public TeamInfo findTeamInfo(String teamId);
}
