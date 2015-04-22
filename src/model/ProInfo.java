/**
 * ProInfo
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Apr 11, 2015
 */
package model;

public class ProInfo {
	
    private String playerId;
	private String name;
	private String team;
    private String position;
    private String picture;
    private int height;
    private int weight;
    private String dob;
    private String college;
    private int number;
	
	public ProInfo() {
	}
	
	public ProInfo(String playerId, String name, String team, String position,
                   String picture, int height, int weight, String dob,
                   String college, int number) {
        this.playerId = playerId;
        this.name = name;
        this.team = team;
        this.position = position;
        this.picture = picture;
        this.height = height;
        this.weight = weight;
        this.dob = dob;
        this.college = college;
        this.number = number;
    }
	
	public String getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
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
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public String getDOB() {
        return dob;
    }
    
    public void setDOB(String dob) {
        this.dob = dob;
    }
    
    public String getCollege() {
        return college;
    }
    
    public void setCollege(String college) {
        this.college = college;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
	
}
