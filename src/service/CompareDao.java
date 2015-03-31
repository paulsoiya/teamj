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
     * @param
     * @return
     */
    public String playerComparison(Stats stats);
}
