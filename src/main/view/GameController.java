package main.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class GameController
				implements Initializable, ControlledScreen{

	ScreensController controller;
	
	public GameController(){
		controller = new ScreensController();
	}
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		
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
        controller.setScreen(Main.statsName);
    }
}

