
public class QB extends UserAthlete {

	int passAtt = 0;
	int passComp = 0;
	int compPercent = 0;
	int passYards = 0;
	int rushYards = 0;
	int passTD = 0;
	int rushTD = 0;
	int intThrown = 0;
	
	public QB() {
		super();
	}
	
	public QB(String name, String team, String position, int playerNum) {
		super(name, team, position, playerNum);
	}
	
	public QB(String name, String team, String position, int playerNum, int passAtt, int passComp, int compPercent, int passYards,
			int rushYards, int passTD, int rushTD, int intThrown) {
		super(name, team, position, playerNum);
		this.passAtt = passAtt;
		this.passComp = passComp;
		this.compPercent = compPercent;
		this.passYards = passYards;
		this.rushYards = rushYards;
		this.passTD = passTD;
		this.rushTD = rushTD;
		this.intThrown = intThrown;
	}
	
	public int getPassAtt() {
		return passAtt;
	}
	
	public void setPassAtt(int passAtt) {
		this.passAtt = passAtt;
	}
	
	public int getPassComp() {
		return passComp;
	}
	
	public void setPassComp(int passComp) {
		this.passComp = passComp;
	}
	
	public int getCompPercent() {
		return (passComp/passAtt);
	}
	
	public void setCompPercent(int compPercent) {
		this.compPercent = compPercent;
	}
	
	public int getPassYards() {
		return passYards;
	}
	
	public void setPassYards(int passYards) {
		this.passYards = passYards;
	}
	
	public int getRushYards() {
		return rushYards;
	}
	
	public void setRushYards(int rushYards) {
		this.rushYards = rushYards;
	}
	
	public int getPassTD() {
		return passTD;
	}
	
	public void setPassTD(int passTD) {
		this.passTD = passTD;
	}
	
	public int getRushTD() {
		return rushTD;
	}
	
	public void setRushTD(int rushTD) {
		this.rushTD = rushTD;
	}
	
	public int getIntThrown() {
		return intThrown;
	}
	
	public void setIntThrown(int intThrown) {
		this.intThrown = intThrown;
	}
	

	
}
