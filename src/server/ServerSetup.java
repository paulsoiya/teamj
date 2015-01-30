package server;

public class ServerSetup {

	public static void main(String[] args) {
		DatabaseCreation db = new DatabaseCreation();
		db.createProfessionalDatabase();
        db.createIndividualDatabase();
	}

}
