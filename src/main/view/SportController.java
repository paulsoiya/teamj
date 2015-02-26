package main.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class SportController
				implements Initializable, ControlledScreen{

	ScreensController controller;
	
	public SportController(){
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
     * Changes the current FXML page to home.fxml
     * @param e

    @FXML
    private void changeToHome() {
        controller.setScreen(Main.homeName);
    }*/
}

