package main.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final String registrationName = "registration";
	public static final String registrationFxml = "register.fxml";
	public static final String loginName = "login";
	public static final String loginFxml = "login.fxml";
    public static final String homeName = "home";
    public static final String homeFxml = "home.fxml";
<<<<<<< HEAD
    public static final String statsName = "stats";
    public static final String statsFxml = "stats.fxml";
    public static final String sportName = "sport";
    public static final String sportFxml = "sport.fxml";
	public static final String gameName = "games";
    public static final String gameFxml = "games.fxml";
    public static final String editName = "edit";
    public static final String editFxml = "edit.fxml";
    
=======
    public static final String quickCompareName = "quickcompare";
    public static final String quickCompareFxml = "quickCompare.fxml";
	
>>>>>>> development
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScreensController container = new ScreensController();
		container.loadScreen(registrationName, registrationFxml);
		container.loadScreen(loginName, loginFxml);
        container.loadScreen(homeName, homeFxml);
<<<<<<< HEAD
        container.loadScreen(statsName, statsFxml);
        container.loadScreen(sportName, sportFxml);
        container.loadScreen(gameName, gameFxml);
        container.loadScreen(editName, editFxml);
=======
        container.loadScreen(quickCompareName, quickCompareFxml);
>>>>>>> development
		container.setScreen(loginName);

		Group root = new Group();
		root.getChildren().addAll(container);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
