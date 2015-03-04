
public class Defense extends UserAthlete {
	
	int tackles = 0;
	int sacks = 0;
	int interceptions = 0;
	

	public Defense() {
		super();
	}

	public Defense(String name, String team, String position, int playerNum) {
		super(name, team, position, playerNum);
	}
	
	public Defense(String name, String team, String position, int playerNum, int tackles, int sacks, int interceptions) {
		super(name, team, position, playerNum);
		this.tackles = tackles;
		this.sacks = sacks;
		this.interceptions = interceptions;
	}


	public int getTackles() {
		return tackles;
	}

	public void setTackles(int tackles) {
		this.tackles = tackles;
	}

	public int getSacks() {
		return sacks;
	}

	public void setSacks(int sacks) {
		this.sacks = sacks;
	}

	public int getInterceptions() {
		return interceptions;
	}

	public void setInterceptions(int interceptions) {
		this.interceptions = interceptions;
	}
	
	

}
