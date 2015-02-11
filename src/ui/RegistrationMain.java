package teamj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Registration page created in FXML
 * @author Paul Soiya II
 * @version Feb 4th 2015
 */
public class RegistrationMain extends Application {

	public static void main(String[] args) {
		Application.launch(RegistrationMain.class, args);
	}

	@Override
	public void start(Stage primaryStage) {
	
		//try to load the FXML layout
		try{
			Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Registration");
			primaryStage.show();//display layout from FXML
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
