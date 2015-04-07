package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import controller.LoginController;

/**
 * Main application class.
 */
public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(createScene(loadMainPane()));
		stage.show();
	}
	
	/**
	 * Loads the main fxml layout. Sets up the vista switching VistaNavigator. Loads the first vista into the fxml
	 * layout.
	 *
	 * @return the loaded pane.
	 * @throws IOException
	 *             if the pane could not be loaded.
	 */
	private Pane loadMainPane() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		
		Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(
				MainNavigator.LOGIN_FXML));
		
		LoginController mainController = loader.getController();
		
		MainNavigator.setMainController(mainController);
		MainNavigator.loadScreen(MainNavigator.LOGIN_FXML);
		
		return mainPane;
	}
	
	/**
	 * Creates the main application scene.
	 *
	 * @param mainPane
	 *            the main application layout.
	 *
	 * @return the created scene.
	 */
	private Scene createScene(Pane mainPane) {
		Scene scene = new Scene(mainPane);
		
		scene.getStylesheets().setAll(
				getClass().getResource("MainTheme.css").toExternalForm());
		
		return scene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
