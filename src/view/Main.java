package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final String REG_NAME = "registration";
	public static final String REG_FXML = "register.fxml";
	public static final String LOGIN_NAME = "login";
	public static final String LOGIN_FXML = "login.fxml";
    public static final String HOME_NAME = "home";
    public static final String HOME_FXML = "home.fxml";
    public static final String STATS_NAME = "stats";
    public static final String STATS_FXML = "stats.fxml";
    public static final String SPORT_NAME = "sport";
    public static final String SPORT_FXML = "sport.fxml";
	public static final String GAME_NAME = "games";
    public static final String GAME_FXML = "games.fxml";
    public static final String EDIT_NAME = "edit";
    public static final String EDIT_FXML = "edit.fxml";
    public static final String COMPARE_NAME = "quickcompare";
    public static final String COMPARE_FXML = "quickCompare.fxml";
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScreensController container = new ScreensController();
		container.loadScreen(REG_NAME, REG_FXML);
		container.loadScreen(LOGIN_NAME, LOGIN_FXML);
        container.loadScreen(HOME_NAME, HOME_FXML);
        container.loadScreen(STATS_NAME, STATS_FXML);
        container.loadScreen(SPORT_NAME, SPORT_FXML);
        container.loadScreen(GAME_NAME, GAME_FXML);
        container.loadScreen(EDIT_NAME, EDIT_FXML);
        container.loadScreen(COMPARE_NAME, COMPARE_FXML);
		container.setScreen(LOGIN_NAME);

		Group root = new Group();
		root.getChildren().addAll(container);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
