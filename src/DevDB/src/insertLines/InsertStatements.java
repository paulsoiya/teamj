package insertLines;
import java.util.Random;

public class InsertStatements {
	
	public static void main (String[] args)
	{

	 addPlayer("1", "Marshawn Lynch", "Seahawks", randHeight(), randWeight(),
			"March 31, 1987", "California", 24);
	 
	 addStats(1, 1, 500, 6, 100, 1600, 25, 200, 0, 0, 0);
	 
	}
	
	public static void addPlayer(String id, String name, String team, double height, 
			int weight, String Bday, String college, int num){
		
		System.out.println("INSERT INTO Player (PlayerID, PlayerName, Team, Height, Weight, BirthDate, Number) " +
                "VALUES ("
				+ id +", "
				+ name +", "
				+ team + ", "
				+ height + ", "
				+ weight + ", "
				+ Bday + ", "
				+ college + ", "
				+ num + ");");
			
	}
	
	public static void addStats(int statsID, int PlayerID, int RecYds, int recTDs, int RecAtt, 
			int RushYds, int RushTDs, int RushAtt, int PassYds, int PassTDs, int PassAtt){
		
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
	    double num3 = (num2/10.0);
	    
	    double randomNum = num1 + num3;
	    

	    return randomNum;
	}

}
