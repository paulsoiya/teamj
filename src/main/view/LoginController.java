/**
 * Controller for the Registration FXML page
 * 
 * @author Paul Soiya II (psoiya@asu.edu)
 * @version Feb 21, 2015
 */
package main.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class LoginController 
				implements Initializable, ControlledScreen{

	ScreensController controller;
	
	public LoginController(){
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
	 * Changes the current FXML page to register.fxml
	 * @param e
	 */
	@FXML
	private void changeToRegistration(ActionEvent e){
		controller.setScreen(Main.registrationName);
	}
	
	/**
	 * Changes the current FXML page to home.fxml
	 * @param e
	 */                
    @FXML
    private void changeToHome(ActionEvent e){
       controller.setScreen(Main.homeName);
    }

	/**
	 * Changes the current FXML page to register.fxml
	 * @param e
	 */
	@FXML
	private void changeToQuickCompare(ActionEvent e){
		controller.setScreen(Main.quickCompareName);
	}

	
}
