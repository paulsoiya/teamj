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
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScreensController container = new ScreensController();
		container.loadScreen(registrationName, registrationFxml);
		container.loadScreen(loginName, loginFxml);
        container.loadScreen(homeName, homeFxml);
		container.setScreen(loginName);

		Group root = new Group();
		root.getChildren().addAll(container);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
