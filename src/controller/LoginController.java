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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import model.User;
import service.*;

public class LoginController 
				implements Initializable, view.ControlledScreen{

	view.ScreensController controller;
                    
    @FXML
    private TextField emailTxt;
    @FXML
    private PasswordField passwordTxt;
    @FXML
    private Label incorrectLabel;
	
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
		controller.setScreen(view.Main.REG_NAME);
	}
	
	/**
	 * Changes the current FXML page to home.fxml
	 * @param e
	 */                
    @FXML
    private void changeToHome(ActionEvent e){
        DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
       UserDao usrDao = daoFact.getUserDao();
        if (usrDao.loginUser(emailTxt.getText(), passwordTxt.getText())) {
           controller.setScreen(view.Main.HOME_NAME);
            User currentUser = usrDao.findUser(emailTxt.getText());
            controller.setSessionUserId(currentUser.getId());
            controller.setSessionUserEmail(currentUser.getEmail());
        } else
            incorrectLabel.setText("Invail Email or Password.");
    }

	/**
	 * Changes the current FXML page to register.fxml
	 * @param e
	 */
	@FXML
	private void changeToQuickCompare(ActionEvent e){
		controller.setScreen(view.Main.COMPARE_NAME);
	}

	
}
