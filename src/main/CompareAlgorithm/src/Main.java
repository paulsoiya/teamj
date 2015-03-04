
public class Main {

	public static void main(String[] args) {
		
		UserAthlete rookie = new UserAthlete();
		
		Defense undraftedD = new Defense();
		Defense RichardSherman = new Defense("Richard Sherman", "Seahawks", "CB", 25, 100, 0, 20);
		Defense MichaelBennett = new Defense("Michale Bennett", "Seahawks", "DE", 72, 160, 30, 0);
		
		QB undraftedQB = new QB();
		QB RusselWilson = new QB("Russel Wilson", "Seahawks", "QB", 3, 285, 452, 63, 3475, 849, 20, 6, 7);
		QB PeytonManning = new QB("Peyton Manning", "Broncos", "QB", 11, 395, 597, 68, 4727, -24, 39, 0, 15);
		
		//String name, String team, String position, int playerNum, int rushAtt, int rushYds, int rushTD, int recYds, int recTot, int recTD
		SkillPlayer undraftedSkill = new SkillPlayer();
		SkillPlayer MarhsawnLynch = new SkillPlayer("Marshawn Lynch", "Seahawks", "RB", 24, 280, 1306, 13, 367, 37, 4);
		SkillPlayer LarryFitzgerald = new SkillPlayer("Larry Fitzgerald", "Cardinals", "WR", 11, 0, 0, 0, 784, 63, 2);
		
		QB qb1 = new QB("QB One", "Flys", "QB", 1, 200, 320, 62, 3842, 200, 25, 2, 8);
		QB qb2 = new QB("QB Two", "Dogs", "QB", 2, 150, 245, 61, 2501, 1000, 10, 18, 6);
		
		SkillPlayer skill1 = new SkillPlayer("Skill One", "Cows", "RB", 1, 100, 854, 10, 250, 20, 2);
		SkillPlayer skill2 = new SkillPlayer("Skill Two", "Ants", "WR", 2, 5, 45, 0, 1200, 75, 13);
		
		
		
		
		

	}

}
