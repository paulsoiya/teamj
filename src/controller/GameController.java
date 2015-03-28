/**
 * Controller for the Game FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class GameController
				implements Initializable, view.ControlledScreen{

	view.ScreensController controller;
	
	public GameController(){
		controller = new view.ScreensController();
	}
	
	@Override
	public void setScreenParent(view.ScreensController screenPage) {
		
		controller = screenPage;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
                    
    /**
     * Changes the current FXML page to stats.fxml
     * @param e
     */
    @FXML
    private void changeToStats() {
        controller.setScreen(view.Main.STATS_NAME);
    }
    
    /**
     * Changes the current FXML page to home.fxml
     * @param e
     */
    @FXML
    private void changeToHome() {
        controller.setScreen(view.Main.HOME_NAME);
    }
}

