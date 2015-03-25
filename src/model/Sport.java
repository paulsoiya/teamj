package model;

public class Sport {
	private int id;
	private String name;
	private String picture;
	
	public Sport(int id, String name, String picture){
		this.id = id;
		this.name = name;
		this.picture = picture;
	}
	
	public Sport(String name, String picture){
		this.name = name;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
