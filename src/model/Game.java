package model;

import java.time.LocalDate;


public class Game {

    private int gameID;
    private int userID;
    private int week;
	private String opponent;
	private String score;
	private LocalDate date;
	
	public Game() { }

	public Game(int gameID, int userID, int week, String opponent,
			String score, LocalDate date) {
		this.gameID = gameID;
		this.userID = userID;
		this.week = week;
		this.opponent = opponent;
		this.score = score;
		this.date = date;
	}
	
	public Game(int userID, int week, String opponent, String score, LocalDate date) {
        this.userID = userID;
		this.week = week;
		this.opponent = opponent;
		this.score = score;
		this.date = date;
	}
    
    public Game(int week, LocalDate date, String opponent, String score) {
        this.week = week;
        this.date = date;
        this.opponent = opponent;
        this.score = score;
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
    
    public int getWeek() {
        return week;
    }
    
    public void setWeek(int week) {
        this.week = week;
    }

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
