
public class SkillPlayer extends UserAthlete {
	
	int rushAtt = 0;
	int rushYds = 0;
	int rushTD = 0;
	int recYds = 0;
	int recTot = 0;
	int recTD = 0;
	
	public SkillPlayer() {
		super();
	}
	public SkillPlayer(String name, String team, String position, int playerNum) {
		super(name, team, position, playerNum);
		
	}
	public SkillPlayer(String name, String team, String position, int playerNum, 
			int rushAtt, int rushYds, int rushTD, int recYds, int recTot, int recTD) {
		super(name, team, position, playerNum);
		this.rushAtt = rushAtt;
		this.rushYds = rushYds;
		this.rushTD = rushTD;
		this.recYds = recYds;
		this.recTot = recTot;
		this.recTD = recTD;
	}
	
	public int getRushAtt() {
		return rushAtt;
	}
	
	public void setRushAtt(int rushAtt) {
		this.rushAtt = rushAtt;
	}
	
	public int getRushYds() {
		return rushYds;
	}
	
	public void setRushYds(int rushYds) {
		this.rushYds = rushYds;
	}
	
	public int getRushTD() {
		return rushTD;
	}
	
	public void setRushTD(int rushTD) {
		this.rushTD = rushTD;
	}
	
	public int getRecYds() {
		return recYds;
	}
	
	public void setRecYds(int recYds) {
		this.recYds = recYds;
	}
	
	public int getRecTot() {
		return recTot;
	}
	
	public void setRecTot(int recTot) {
		this.recTot = recTot;
	}
	
	public int getRecTD() {
		return recTD;
	}
	
	public void setRecTD(int recTD) {
		this.recTD = recTD;
	}
	
	

}
