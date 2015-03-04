
public class UserAthlete {

	String name;
	String team;
	String position;
	int playerNum;
	
	
	public UserAthlete (){
		
		name = "rookie";
		team = "Free Agent";
		position = "Benchwarmer";
		playerNum = 0;
		
	}
	
	public UserAthlete(String name, String team, String position, int playerNum) {
		this.name = name;
		this.team = team;
		this.position = position;
		this.playerNum = playerNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}


}
