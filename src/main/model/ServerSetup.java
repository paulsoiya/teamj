package main.model;

public class ServerSetup {

	public static void main(String[] args) {
		DatabaseCreation db = new DatabaseCreation();
		db.createProfessionalDatabase();
        db.createIndividualDatabase();
	}

}
