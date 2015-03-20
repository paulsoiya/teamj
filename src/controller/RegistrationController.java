/**
 * Controller for the Registration FXML page
 * 
 * @author Paul Soiya II (psoiya@asu.edu)
 * @version Feb 21, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import service.*;

public class RegistrationController 
				implements Initializable, view.ControlledScreen{

	view.ScreensController controller;
	
	@FXML
	private TextField firstNameTxt;
	@FXML
	private TextField lastNameTxt;
	@FXML
	private DatePicker dobPicker;
	@FXML
	private TextField emailTxt;
	@FXML
	private PasswordField passwordTxt;
	@FXML
	private PasswordField confirmPasswordTxt;
	
	
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
    	
    	DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    	UserDao usrDao = daoFact.getUserDao();
    	
    	User usr = new User(emailTxt.getText(),
    						passwordTxt.getText(),
    						firstNameTxt.getText(),
    						lastNameTxt.getText(),
    						dobPicker.getValue());
    	
    	int userId = usrDao.createUser(usr);
    	
    	System.out.println("userId = " + userId);
    	//controller.setScreen(view.Main.homeName);
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
