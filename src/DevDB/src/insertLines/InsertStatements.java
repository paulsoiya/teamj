/* This class will allow you to set up some arrays and pass them to functions
 * which will then be used to print out statements. The statements can be copy
 * and pasted into sqlite and inserted into the database without having to type
 * a huge amount of insert statements.
 * 
 * The table is the one created in our BuildProfessionalDB.java, modified only 2-3 columns
 * that will not effect the comparing.
 */

package insertLines;

import java.util.Random;

public class InsertStatements {

	public static void main(String[] args) {

		String[] playerName = { "Marshawn Lynch", "Russell Wilson",
				"Doug Baldwin", "Frank Gore", "Collin Kapernick",
				"Michael Crabtree", "Andre Ellington", "Carson Palmer",
				"Larry Fitzgerald", "Eddie Lacy", "Aaron Rodgers",
				"Jordy Nelson", "Mark Ingram", "Drew Brees", "Jimmy Graham",
				"Broncos RB", "Peyton Manning", "Demarius Thomas",
				"Demarco Murray", "Tony Romo", "Dez Bryant" };

		String[] teamName = { "Seahawks", "Seahawks", "Seahawks", "49ers",
				"49ers", "49ers", "Cardinals", "Cardinals", "Cardinals",
				"Packers", "Packers", "Packers", "Saints", "Saints", "Saints",
				"Broncos", "Broncos", "Broncos", "Cowboys", "Cowboys",
				"Cowboys" };

		String[] bDay = { "January 22, 1984", "February 15, 1988",
				"March 31 1987", "April 21, 1979", "May 10, 1989",
				"June 21, 1978", "July 14, 1986", "August 31, 1982",
				"September 21, 1990", "October 5, 1981", "November 3, 1980",
				"December 20, 1983", "January 1, 1985", "February 9, 1989",
				"March 15 1977", "April 18, 1984", "May 12, 1990",
				"June 14, 1976", "July 13, 1989", "August 17, 1989",
				"September 13, 1980" };

		String[] college = { "ASU", "BSU", "FSU", "CAL", "LSU", "ALA", "ARK",
				"UoA", "ORE", "WAS", "OSU", "MSU", "MIN", "USC", "UCLA",
				"STAN", "ISU", "TCU", "ASU", "ASU", "CAL" };

		int[] pNum = { 24, 25, 45, 98, 16, 5, 8, 7, 9, 15, 32, 20, 21, 78, 14,
				10, 2, 19, 65, 37, 96 };

		addPlayer(playerName, teamName, bDay, college, pNum);

		addStats(playerName);
		
		System.out.println("------------User Table Insert Statements Follow----------");
		
		
		String [] userEmail = {"E.Hawks@gmail.com", "B.Lee@gmail.com", "J.Wayne@gmail.com", "Kim.Kay@gmail.com"};
		
		String [] userPass = {"pass1", "pass2", "pass3", "pass4"};
		
		String [] userName = {"Elliott Hawks", "Bruce Lee", "John Wayne", "Kim Kardashian"};
		
		String [] userSportName = {"Football", "Football", "Football", "Football"};
		
		userInfoTable(userEmail, userPass, userName);
		
		userSportInfo(userSportName);
		
		userStats(playerName);
		
		
	}

	public static void addPlayer(String[] playerName, String[] teamName,
			String[] bDay, String[] college, int[] pNum) {

		for (int x = 1; x <= playerName.length; x++) {
			System.out
					.println("INSERT INTO Player (PlayerID, PlayerName, Team, Height, Weight, BirthDate, Number) "
							+ "VALUES ("
							+ x
							+ ", '"
							+ playerName[x-1]
							+ "', '"
							+ teamName[x-1]
							+ "', "
							+ randHeight()
							+ ", "
							+ randWeight()
							+ ", '"
							+ bDay[x-1]
							+ "', '"
							+ college[x-1]
							+ "', "
							+ pNum[x-1]
							+ ");");
		}

	}

	public static void addStats(String playerName[]) {

		// adding stats this way will cause inaccuracy when it comes to Qb's vs WR/RB
		// but im not aiming for accuracy just want to get a functional DB so i can run
		// queries

		for (int x = 1; x <= playerName.length; x++) {
			System.out
					.println("INSERT INTO Stats (StatsID, PlayerID, RecYds, RecTDs, RecAtt, RushYds, "
							+ "RushTDs, RushAtt, PassYds, PassTds, PassAtt) "
							+ "VALUES ("
							+ x
							+ ", "
							+ x
							+ ", "
							+ randStat(0, 2500)
							+ ", "
							+ randStat(0, 30)
							+ ", "
							+ randStat(0, 200)
							+ ", "
							+ randStat(0, 2200)
							+ ", "
							+ randStat(0, 35)
							+ ", "
							+ randStat(0, 200)
							+ ", "
							+ randStat(0, 5500)
							+ ", "
							+ randStat(0, 55)
							+ ", "
							+ randStat(0, 500)
							+ ");");
		}

	}
	
	public static void userInfoTable(String [] userEmail, String [] userPass, String [] userName){
		
		for (int x = 1; x <= userName.length; x++) {
			System.out
					.println("INSERT INTO User (UserID, Email, Password, Name) "
							+ "VALUES ("
							+ x
							+ ", '"
							+ userEmail[x-1]
							+ "', '"
							+ userPass[x-1]
							+ "', '"
							+ userName[x-1]
							+ "');");
		}
		
		
	}
	
	public static void userSportInfo(String [] userSportName){
		
		for (int x = 1; x <= userSportName.length; x++) {
			System.out
					.println("INSERT INTO Sport (SportID, SportName, Picture) "
							+ "VALUES ("
							+ x
							+ ", '"
							+ userSportName[x-1]
							+ "', "
							+ "'My Pic'"
							+ ");");
		}
		
	}
	
	public static void userStats(String [] userName){
		
		for (int x = 1; x <= userName.length; x++) {
			System.out
					.println("INSERT INTO Stats (StatsID, UserID, RecYds, RecTDs, RecAtt, RushYds, "
							+ "RushTDs, RushAtt, PassYds, PassTds, PassAtt) "
							+ "VALUES ("
							+ x
							+ ", "
							+ x
							+ ", "
							+ randStat(0, 2500)
							+ ", "
							+ randStat(0, 30)
							+ ", "
							+ randStat(0, 200)
							+ ", "
							+ randStat(0, 2200)
							+ ", "
							+ randStat(0, 35)
							+ ", "
							+ randStat(0, 200)
							+ ", "
							+ randStat(0, 5500)
							+ ", "
							+ randStat(0, 55)
							+ ", "
							+ randStat(0, 500)
							+ ");");
		}
		
	}

	public static int randStat(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt(max - min + 1) + min;

		return randomNum;
	}

	public static int randWeight() {

		Random rand = new Random();
		int randomNum = rand.nextInt(176) + 175;

		return randomNum;
	}

	public static double randHeight() {

		Random rand = new Random();

		int num1 = rand.nextInt(2) + 5;
		int num2 = rand.nextInt(10);
		double num3 = (num2 / 10.0);

		double randomNum = num1 + num3;

		return randomNum;
	}

}
