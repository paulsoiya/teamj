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
	
	public EditController(){
		controller = new view.ScreensController();
	}
	
	@Override
	public void setScreenParent(view.ScreensController screenPage) {
		controller = screenPage;
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
        
        if(usrDao.passwordMatch(confirmPasswordTxt.getText(), passwordTxt.getText())) {
            User updateUsr = new User(emailTxt.getText(),
                            passwordTxt.getText(),
                            firstNameTxt.getText(),
                            lastNameTxt.getText(),
                            dobPicker.getValue());
            if(usrDao.updateUser(updateUsr))
                controller.setScreen(view.Main.homeName);
        }
    }
}

