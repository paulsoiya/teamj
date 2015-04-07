/**
 * Compare
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package model;

public class Compare {

	private int userYards;
	private int userTouchdowns;
	private int userAttempts;
    private int proYards;
    private int proTouchdowns;
    private int proAttempts;
	
	public Compare() { }

	public Compare(int userYards, int userTouchdowns, int userAttempts, int proYards,
                   int proTouchdowns, int proAttempts) {
        this.userYards = userYards;
        this.userTouchdowns = userTouchdowns;
        this.userAttempts = userAttempts;
        this.proYards = proYards;
        this.proTouchdowns = proTouchdowns;
        this.proAttempts = proAttempts;
	}
	
	public int getUserYards() {
		return userYards;
	}

	public void setUserYards(int userYards) {
		this.userYards = userYards;
	}
 
    public int getUserTouchdowns() {
        return userTouchdowns;
    }
    
    public void setUserTouchdowns(int userTouchdowns) {
        this.userTouchdowns = userTouchdowns;
    }
    
    public int getUserAttempts() {
        return userAttempts;
    }
    
    public void setUserAttempts(int userAttempts) {
        this.userAttempts = userAttempts;
    }

	public int getProYards() {
		return proYards;
	}

	public void setProYards(int proYards) {
		this.proYards = proYards;
	}

	public int getProTouchdowns() {
		return proTouchdowns;
	}

	public void setProTouchdowns(int proTouchdowns) {
		this.proTouchdowns = proTouchdowns;
	}

	public int getProAttempts() {
		return proAttempts;
	}

	public void setProAttempts(int proAttempts) {
		this.proAttempts = proAttempts;
	}
	
}
