/**
 * Controller for the Registration FXML page
 * 
 * @author Paul Soiya II (psoiya@asu.edu)
 * @version Feb 21, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.User;
import model.ValidateResult;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import service.*;


public class RegistrationController implements Initializable {

	view.MainNavigator controller;
	
	@FXML 
	private Label errorLbl;
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
		controller = new view.MainNavigator();
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
		controller.loadScreen(controller.LOGIN_FXML);
	}
                    
    /**
     * Changes the current FXML page to the login.fxml
     * @param e
     */
    @FXML
    private void changeToHome(ActionEvent e){
    
    	//clear error label
    	errorLbl.setText("");
    	DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    	UserDao usrDao = daoFact.getUserDao();
    	User user = null;
    	ValidateResult validateRes;
    	boolean dateSet;
    	
    	// check if user entered a date of birth
    	try{
    		dateSet = !dobPicker.getValue().toString().isEmpty();
    	} catch (NullPointerException npe){
    		dateSet = false;
    	}
    	
    	if (!dateSet) {
    		validateRes = new ValidateResult(false, "You must enter your date of birth.");
    	} else {
    		user = new User(emailTxt.getText(),
    				passwordTxt.getText(),
    				confirmPasswordTxt.getText(),
    				firstNameTxt.getText(),
    				lastNameTxt.getText(),
    				dobPicker.getValue().toString());
    		validateRes = user.validate();
    	}
    	
    	if(validateRes.isValid()){
    		if (usrDao.createUser(user)) {
    			User currentUser = usrDao.findUser(emailTxt.getText());
    			controller.setSessionUserId(currentUser.getId());
    			controller.setSessionUserEmail(emailTxt.getText());
    			controller.loadScreen(controller.HOME_FXML);
    		} else {
    			errorLbl.setText("Unable to add new user.");
    		}
    	}else{
    		errorLbl.setText(validateRes.getMessage());
    	}
    }
                    
	
	/**
	 * Changes the current FXML page to the quickCompare.fxml
	 * @param e
	 */
	@FXML
	private void changeToQuickCompare(ActionEvent e){
		controller.loadScreen(controller.COMPARE_FXML);
	}
	
}
