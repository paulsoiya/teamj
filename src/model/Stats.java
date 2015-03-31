/**
 * Stats
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package model;

public class Stats {

    private int statsID;
    private int gameID;
    private int userID;
	private int yards;
	private int touchdowns;
	private int attempts;
	
	public Stats() { }

	public Stats(int statsID, int gameID, int userID, int yards,
			int touchdowns, int attempts) {
		this.statsID = statsID;
		this.gameID = gameID;
		this.userID = userID;
        this.yards = yards;
		this.touchdowns = touchdowns;
		this.attempts = attempts;
	}
	
    public Stats(int gameID, int userID, int yards,int touchdowns,
                int attempts) {
        this.gameID = gameID;
        this.userID = userID;
        this.yards = yards;
        this.touchdowns = touchdowns;
        this.attempts = attempts;
	}
	
	public int getStatsID() {
		return statsID;
	}

	public void setStatsID(int statsID) {
		this.statsID = statsID;
	}
 
    public int getGameID() {
        return gameID;
    }
    
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }

	public int getYards() {
		return yards;
	}

	public void setYards(int yards) {
		this.yards = yards;
	}

	public int getTouchdowns() {
		return touchdowns;
	}

	public void setTouchdowns(int touchdowns) {
		this.touchdowns = touchdowns;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
}
