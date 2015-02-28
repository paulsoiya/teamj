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

public class RegistrationController 
				implements Initializable, ControlledScreen{

	ScreensController controller;
	
	public RegistrationController(){
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
	 * Changes the current FXML page to the login.fxml
	 * @param e
	 */
	@FXML
	private void changeToLogin(ActionEvent e){
		controller.setScreen(Main.loginName);
	}
                    
    /**
     * Changes the current FXML page to the login.fxml
     * @param e
     */
    @FXML
    private void changeToHome(ActionEvent e){
         controller.setScreen(Main.homeName);
    }
                    
	/*
	@FXML
	private void changeToQuickCompare(ActionEvent e){
		controller.setScreen();
	}
	*/
	
}
