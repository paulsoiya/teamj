/**
 * Controller for the Registration FXML page
 * 
 * @author Paul Soiya II (psoiya@asu.edu)
 * @version Feb 21, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class RegistrationController 
				implements Initializable, view.ControlledScreen{

	view.ScreensController controller;
	
	public RegistrationController(){
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
	 * Changes the current FXML page to the login.fxml
	 * @param e
	 */
	@FXML
	private void changeToLogin(ActionEvent e){
		controller.setScreen(view.Main.loginName);
	}
                    
    /**
     * Changes the current FXML page to the login.fxml
     * @param e
     */
    @FXML
    private void changeToHome(ActionEvent e){
         controller.setScreen(view.Main.homeName);
    }
                    
	
	/**
	 * Changes the current FXML page to the quickCompare.fxml
	 * @param e
	 */
	@FXML
	private void changeToQuickCompare(ActionEvent e){
		controller.setScreen(view.Main.quickCompareName);
	}
	
}
