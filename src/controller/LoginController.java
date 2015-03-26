/**
 * Controller for the Login FXML page
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
import service.*;

public class LoginController 
				implements Initializable, view.ControlledScreen{

	view.ScreensController controller;
	
	public LoginController(){
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
	 * Changes the current FXML page to register.fxml
	 * @param e
	 */
	@FXML
	private void changeToRegistration(ActionEvent e){
		controller.setScreen(view.Main.registrationName);
	}
	
	/**
	 * Changes the current FXML page to home.fxml
	 * @param e
	 */                
    @FXML
    private void changeToHome(ActionEvent e){
       DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
       UserDao usrDao = daoFact.getUserDao();
       usrDao.findUser("testemail1@asu.edu");
       controller.setScreen(view.Main.homeName);
    }

	/**
	 * Changes the current FXML page to register.fxml
	 * @param e
	 */
	@FXML
	private void changeToQuickCompare(ActionEvent e){
		controller.setScreen(view.Main.quickCompareName);
	}

	
}
