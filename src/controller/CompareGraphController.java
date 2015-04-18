/**
 * Controller for the Graph in the Compare FXML page
 * 
 * @author Jaime Rabago (jRabago@asu.edu)
 * @version April 17, 2015
 */
package controller;

import static view.MainNavigator.COMPARE_FXML;
import static view.MainNavigator.HOME_FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import service.DaoFactory;
import service.CompareDao;
import service.ProInfoDao;
import session.UserSession;
import view.MainNavigator;

public class CompareGraphController implements Initializable {
	
	view.MainNavigator controller;
    
	
	public CompareGraphController() {
		controller = new view.MainNavigator();
	}
    
    private UserSession session = UserSession.getInstance();
    
    DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    CompareDao compareDao = daoFact.getCompareDao();
    ProInfoDao proInfoDao = daoFact.getProInfoDao();
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// get stuff to populate graph?
		
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
	
	/**
	 * Changes the current FXML page to the compare.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToCompare(ActionEvent e) {
		MainNavigator.loadScreen(COMPARE_FXML);
	}

}
