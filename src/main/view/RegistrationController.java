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
	
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		
		controller = screenPage;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
  
	@FXML
	private void changeToLogin(ActionEvent e){
		controller.setScreen(Main.loginFxml);
	}
	/*
	@FXML
	private void changeToQuickCompare(ActionEvent e){
		controller.setScreen();
	}
	*/
	
}
