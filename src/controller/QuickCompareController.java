/**
 * Controller for the QuickCompare FXML page
 * 
 * @author Paul Soiya II (psoiya@asu.edu)
 * @version Feb 27, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import view.MainNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class QuickCompareController implements Initializable {
	
	view.MainNavigator controller;
	
	public QuickCompareController() {
		controller = new view.MainNavigator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Changes the current FXML page to the register.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToRegister(ActionEvent e) {
		controller.loadScreen(controller.REG_FXML);
	}
	
	/**
	 * Changes the current FXML page to the login.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToLogin(ActionEvent e) {
		controller.loadScreen(controller.LOGIN_FXML);
	}
	
	/**
	 * Changes the current FXML page to the quickCompare.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToQuickCompare(ActionEvent e) {
		controller.loadScreen(controller.COMPARE_FXML);
	}
	
}
