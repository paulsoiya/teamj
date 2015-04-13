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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ProInfo;
import service.DaoFactory;
import service.ProInfoDao;
import service.CompareDao;
import session.UserSession;
import view.MainNavigator;

public class CompareController implements Initializable {
    
    @FXML
    private Label nameTxt;
    @FXML
    private Label positionTxt;
    @FXML
    private Label numberTxt;
    @FXML
    private ImageView playerPicture;
	
	view.MainNavigator controller;
    
    private UserSession session = UserSession.getInstance();
    
    DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    ProInfoDao infoDao = daoFact.getProInfoDao();
    CompareDao compareDao = daoFact.getCompareDao();
    
    ProInfo info = new ProInfo();
	
	public CompareController() {
		controller = new view.MainNavigator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        int statsId = compareDao.findStatsId(session.getGameId());
        info = infoDao.findProInfo(statsId);
        nameTxt.setText(info.getName());
        positionTxt.setText(info.getPosition());
        numberTxt.setText(Integer.toString(info.getNumber()));
        Image img = new Image(info.getPicture());
        playerPicture.setImage(img);
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
