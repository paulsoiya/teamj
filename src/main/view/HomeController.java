package main.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class HomeController
				implements Initializable, ControlledScreen{

	ScreensController controller;
	
	public HomeController(){
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
	 * Changes the current FXML page to games.fxml
	 * @param e
	 */
	@FXML
	private void changeToGames(ActionEvent e){
		controller.setScreen(Main.gameName);
	}
                    
    /**
     * Changes the current FXML page to games.fxml
     * @param e
     */
    @FXML
    private void changeToSport(ActionEvent e){
         controller.setScreen(Main.sportName);
    }
}

