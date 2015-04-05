/**
 * Controller for the Login FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.User;
import service.DaoFactory;
import service.UserDao;

public class LoginController implements Initializable {
	
	view.MainNavigator controller;
	
	@FXML
	private TextField emailTxt;
	@FXML
	private PasswordField passwordTxt;
	@FXML
	private Label incorrectLabel;
	/** Holder of a switchable vista. */
	@FXML
	private BorderPane mainPane;
	
	DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
	UserDao usrDao = daoFact.getUserDao();
	
	public LoginController() {
		controller = new view.MainNavigator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Changes the current FXML page to register.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToRegistration(ActionEvent e) {
		controller.loadScreen(controller.REG_FXML);
	}
	
	/**
	 * Changes the current FXML page to home.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToHome(ActionEvent e) {
		if (usrDao.loginUser(emailTxt.getText(), passwordTxt.getText())) {
			controller.loadScreen(controller.HOME_FXML);
			User currentUser = usrDao.findUser(emailTxt.getText());
			controller.setSessionUserId(currentUser.getId());
			controller.setSessionUserEmail(currentUser.getEmail());
			
		}
		else
			incorrectLabel.setText("Invaild Email or Password.");
	}
	
	/**
	 * Changes the current FXML page to register.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToQuickCompare(ActionEvent e) {
		controller.loadScreen(controller.COMPARE_FXML);
	}
	
	/**
	 * Replaces the vista displayed in the vista holder with a new vista.
	 *
	 * @param node
	 *            the vista node to be swapped in.
	 */
	public void setScreen(Node node) {
		mainPane.getChildren().setAll(node);
	}
}
