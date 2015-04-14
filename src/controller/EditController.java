/**
 * Controller for the Edit account info FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import static view.MainNavigator.GAME_FXML;
import static view.MainNavigator.HOME_FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import service.DaoFactory;
import service.UserDao;
import session.UserSession;
import view.MainNavigator;

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
	
	private UserSession session = UserSession.getInstance();
	
	public EditController() {
		controller = new view.MainNavigator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO
	}
	
	public void setFields() {
		DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
		UserDao usrDao = daoFact.getUserDao();
		User user = usrDao.findUser(session.getUserEmail());
		
		this.firstNameTxt.setText(user.getFirstName());
		this.lastNameTxt.setText(user.getLastName());
		this.emailTxt.setText(user.getEmail());
		this.passwordTxt.setText(user.getPassword());
		this.confirmPasswordTxt.setText(user.getPassword());
	}
	
	/**
	 * Changes the current FXML page to home.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToHome() {
		DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
		UserDao usrDao = daoFact.getUserDao();
		if (firstNameTxt.getText() != null && lastNameTxt.getText() != null
				&& dobPicker.getValue() != null && emailTxt.getText() != null
				&& passwordTxt.getText() != null && confirmPasswordTxt.getText() != null) {
			if (usrDao.passwordMatch(confirmPasswordTxt.getText(), passwordTxt.getText())) {
				if (session.getUserEmail().equals(emailTxt.getText())) {
					User updateUsr = new User(emailTxt.getText(), passwordTxt.getText(),
							firstNameTxt.getText(), lastNameTxt.getText(), dobPicker
									.getValue().toString());
					if (usrDao.updateUser(updateUsr))
						MainNavigator.loadScreen(HOME_FXML);
					else
						wrongLabel.setText("Invaild Information");
				}
				else
					wrongLabel.setText("Email cannot be changed");
			}
			else
				wrongLabel.setText("Passwords don't match");
		}
		else
			wrongLabel.setText("Enter your Information");
	}
	
	/**
	 * Changes the current FXML page to home.fxml
	 *
	 * @param e
	 */
	@FXML
	private void changeToHomeQuick() {
		MainNavigator.loadScreen(HOME_FXML);
	}
	
	/**
	 * Changes the current FXML page to games.fxml
	 *
	 * @param e
	 */
	@FXML
	private void changeToGames() {
		MainNavigator.loadScreen(GAME_FXML);
	}
}
