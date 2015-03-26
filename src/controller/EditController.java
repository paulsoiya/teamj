/**
 * Controller for the Edit account info FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.User;
import service.DaoFactory;
import service.UserDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EditController
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
	
	public EditController(){
		controller = new view.ScreensController();
		
		DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    	UserDao usrDao = daoFact.getUserDao();
		
    	User usr = usrDao.findUser(1); // add in email
    	
    	firstNameTxt.setText(usr.getFirstName());
    	lastNameTxt.setText(usr.getLastName());
    	dobPicker.setValue(usr.getDob());
    	emailTxt.setText(usr.getEmail());
    	passwordTxt.setText(usr.getPassword());
    	confirmPasswordTxt.setText(usr.getPassword());
    	
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
     * Changes the current FXML page to home.fxml
     * @param e
     */
    @FXML
    private void changeToHome() {
        controller.setScreen(view.Main.homeName);
    }
    
    /**
     * Changes the current FXML page to home.fxml
     * @param e
     */
    @FXML
    private void updateUser() {
    	
    	DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    	UserDao usrDao = daoFact.getUserDao();
    	
    	User usr = new User(emailTxt.getText(),
    						passwordTxt.getText(),
    						firstNameTxt.getText(),
    						lastNameTxt.getText(),
    						dobPicker.getValue());
    	
    	usrDao.updateUser(usr);
    	controller.setScreen(view.Main.homeName);
    }
}

