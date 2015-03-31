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

public class HomeController implements Initializable {

	view.MainNavigator controller;
	
	public HomeController(){
		controller = new view.MainNavigator();
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
		controller.loadScreen(controller.GAME_FXML);
	}
                    
    /**
     * Changes the current FXML page to sport.fxml
     * @param e
     */
    @FXML
    private void changeToSport(ActionEvent e){
         controller.loadScreen(controller.SPORT_FXML);
    }
                    
    /**
     * Changes the current FXML page to edit.fxml
     * @param e
     */
    @FXML
    private void changeToEdit(ActionEvent e){
         controller.loadScreen(controller.EDIT_FXML);
    }
}

