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
import javafx.scene.control.Label;

public class EditController implements Initializable {

	view.MainNavigator controller;
    
    public User currentUser;
	
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
    @FXML
    private Label wrongLabel;
	
	public EditController(){
		controller = new view.MainNavigator();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        //TODO
	}
    
    /**
     * Changes the current FXML page to home.fxml
     * @param e
     */
    @FXML
    private void changeToHome() {
        DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
        UserDao usrDao = daoFact.getUserDao();
        if(firstNameTxt.getText() != null && lastNameTxt.getText() != null &&
           dobPicker.getValue() != null && emailTxt.getText() != null &&
           passwordTxt.getText() != null && confirmPasswordTxt.getText() != null) {
            if(usrDao.passwordMatch(confirmPasswordTxt.getText(), passwordTxt.getText())) {
                User updateUsr = new User(emailTxt.getText(),
                            passwordTxt.getText(),
                            firstNameTxt.getText(),
                            lastNameTxt.getText(),
                            dobPicker.getValue().toString());
                if(usrDao.updateUser(updateUsr))
                    controller.loadScreen(controller.HOME_FXML);
                else
                    wrongLabel.setText("Invaild Information");
            }
            else
                wrongLabel.setText("Passwords don't match");
        }
        else
            wrongLabel.setText("Enter your Information");
    }
}

