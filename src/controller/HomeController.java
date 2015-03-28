/**
 * Controller for the Home page FXML page
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

public class HomeController
				implements Initializable, view.ControlledScreen{

	view.ScreensController controller;
	
	public HomeController(){
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
	 * Changes the current FXML page to games.fxml
	 * @param e
	 */
	@FXML
	private void changeToGames(ActionEvent e){
		controller.setScreen(view.Main.GAME_NAME);
	}
                    
    /**
     * Changes the current FXML page to sport.fxml
     * @param e
     */
    @FXML
    private void changeToSport(ActionEvent e){
         controller.setScreen(view.Main.SPORT_NAME);
    }
                    
    /**
     * Changes the current FXML page to edit.fxml
     * @param e
     */
    @FXML
    private void changeToEdit(ActionEvent e){
         controller.setScreen(view.Main.EDIT_NAME);
    }
}

