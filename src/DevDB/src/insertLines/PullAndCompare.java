/*Using the tutorial on JavaCodeHelp.com for a guide on
 * how to run SQL statements from java and get back results
 * 
 */

package insertLines;

import java.sql.*;

public class PullAndCompare {

	public static void main(String[] args) {
		
		printPlayerDB();
		printUserDB();
		
		
	}
	
	public static void printPlayerDB(){
		String url = "jdbc:sqlite:PlayersTest.db";
		String query = "select * from Player";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url, "", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("PlayerID: " + rs.getString(1) + "\t");
				System.out.print("PlayerName: " + rs.getString(2) + "  \t");
				System.out.print("Team: " + rs.getString(3) + "\t");
				System.out.print("Height: " + rs.getString(4) + "\t");
				System.out.print("Weight: " + rs.getString(5) + "\t");
				System.out.print("BirthDate: " + rs.getString(6) + "  \t");
				System.out.print("College: " + rs.getString(7) + "\t");
				System.out.print("Number: " + rs.getString(8) + "\t");
				System.out.println("");

			}
		} catch (SQLException ex) {
			while (ex != null) {
				System.out.println("SQL Exception: " + ex.getMessage());
				ex = ex.getNextException();
			}
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
		
		query = "select * from Stats";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url, "", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("------------- Stats Table---------------");
			while (rs.next()) {
				System.out.print("StatsID: " + rs.getString(1) + "\t");
				System.out.print("PlayerID: " + rs.getString(2) + "  \t");
				System.out.print("RecYds: " + rs.getString(3) + "\t");
				System.out.print("RecTDs: " + rs.getString(4) + "\t");
				System.out.print("RecAtt: " + rs.getString(5) + "\t");
				System.out.print("RushYds: " + rs.getString(6) + "  \t");
				System.out.print("RushTDs: " + rs.getString(7) + "\t");
				System.out.print("RushAtt: " + rs.getString(8) + "\t");
				System.out.print("PassYds: " + rs.getString(9) + "\t");
				System.out.print("PassTDs: " + rs.getString(10) + "\t");
				System.out.print("PassAtt: " + rs.getString(11) + "\t");
				System.out.println("");

			}
		} catch (SQLException ex) {
			while (ex != null) {
				System.out.println("SQL Exception: " + ex.getMessage());
				ex = ex.getNextException();
			}
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void printUserDB(){
		
		String url = "jdbc:sqlite:user.db";
		String query = "select * from User";
		
		System.out.println("------------------ User Info ----------------");
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url, "", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("UserID: " + rs.getString(1) + "\t");
				System.out.print("Email: " + rs.getString(2) + "  \t");
				System.out.print("Password: " + rs.getString(3) + "\t");
				System.out.print("Name: " + rs.getString(4) + "\t");
				System.out.println("");

			}
		} catch (SQLException ex) {
			while (ex != null) {
				System.out.println("SQL Exception: " + ex.getMessage());
				ex = ex.getNextException();
			}
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
		
		query = "select * from Stats";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url, "", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("------------- Stats Table---------------");
			while (rs.next()) {
				System.out.print("StatsID: " + rs.getString(1) + "\t");
				System.out.print("PlayerID: " + rs.getString(2) + "  \t");
				System.out.print("RecYds: " + rs.getString(3) + "\t");
				System.out.print("RecTDs: " + rs.getString(4) + "\t");
				System.out.print("RecAtt: " + rs.getString(5) + "\t");
				System.out.print("RushYds: " + rs.getString(6) + "  \t");
				System.out.print("RushTDs: " + rs.getString(7) + "\t");
				System.out.print("RushAtt: " + rs.getString(8) + "\t");
				System.out.print("PassYds: " + rs.getString(9) + "\t");
				System.out.print("PassTDs: " + rs.getString(10) + "\t");
				System.out.print("PassAtt: " + rs.getString(11) + "\t");
				System.out.println("");

			}
		} catch (SQLException ex) {
			while (ex != null) {
				System.out.println("SQL Exception: " + ex.getMessage());
				ex = ex.getNextException();
			}
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}	

}
