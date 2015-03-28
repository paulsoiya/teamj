package model;

public class Sport {
	private int sportId;
	private String name;
	private String picture;
	
	public Sport(int sportId, String name, String picture){
		this.sportId = sportId;
		this.name = name;
		this.picture = picture;
	}
	
	public Sport(String name, String picture){
		this.name = name;
		this.picture = picture;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
