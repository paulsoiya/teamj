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
import model.ProInfo;
import service.DaoFactory;
import service.ProInfoDao;
import session.UserSession;
import view.MainNavigator;

public class CompareController implements Initializable {
	
	view.MainNavigator controller;
    
    private UserSession session = UserSession.getInstance();
    
    DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    ProInfoDao infoDao = daoFact.getProInfoDao();
    
    ProInfo info = new ProInfo();
	
	public CompareController() {
		controller = new view.MainNavigator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        info = infoDao.findProInfo(session.getGameId());
        System.out.println(info.getName() + session.getGameId());
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
	
}
