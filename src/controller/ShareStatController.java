/**
 * Controller for the Compare FXML page
 * 
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package controller;

import static view.MainNavigator.HOME_FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import session.UserSession;
import view.MainNavigator;
import model.Email;
import model.EmailProvider;

public class ShareStatController implements Initializable {
    
    private UserSession session = UserSession.getInstance();
    
    @FXML
    private Label errorLbl; 
    
    @FXML
    private Label successLbl;
    
    @FXML
    private TextField friendEmailTxt;
    
    @FXML
    private TextArea messageTxt;
	
	public ShareStatController() {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	/**
	 * Changes the current FXML page to the home.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToHome(ActionEvent e) {
		MainNavigator.loadScreen(HOME_FXML);
	}
	
	@FXML
	private void shareStats(ActionEvent e){
		
		Email email = new Email(friendEmailTxt.getText(), EmailProvider.STMP_USER,
								"Sports Compare Comparison",  messageTxt.getText(), session.getScreenshotPath());
		
		System.out.println("screenshot path inside controller = " + email.getAttachmentPath());
		
		EmailProvider emailProvider = EmailProvider.getInstance();
		boolean res = emailProvider.sendEmail(email);
		
		if ( res ) {
			successLbl.setText("The email was sent successfully.");
		} else {
			errorLbl.setText("Unable to send the email. Please try again.");
		}
		
		
	}
	
}
