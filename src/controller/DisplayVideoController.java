/**
 * Controller for the QuickCompare FXML page
 * 
 * @author Paul Soiya II (psoiya@asu.edu)
 * @version Feb 27, 2015
 */
package controller;

import static view.MainNavigator.COMPARE_FXML;
import static view.MainNavigator.HOME_FXML;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import service.DaoFactory;
import service.CompareDao;
import service.ProInfoDao;
import model.ProInfo;
import session.UserSession;
import view.MainNavigator;

public class DisplayVideoController implements Initializable {
	
	view.MainNavigator controller;
    
    @FXML
    private WebView youtubeView;
	
	public DisplayVideoController() {
		controller = new view.MainNavigator();
	}
    
    private UserSession session = UserSession.getInstance();
    
    DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    CompareDao compareDao = daoFact.getCompareDao();
    ProInfoDao proInfoDao = daoFact.getProInfoDao();
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        int proStat = compareDao.findStatsId(session.getGameId());
        ProInfo player = proInfoDao.findProInfo(proStat);
        String embed = "<script src='http://www.yvoschaap.com/ytpage/ytembed.js'></script>" +
        "<div id='ytThumbs'></div>" +
        
        "<script>" +
        "ytEmbed.init({'block':'ytThumbs','key':'AIzaSyBdmAmKwRQt9HuR3-oyRVPKEmEOqrTVoq4','q':'player.getName() + Highlights','type':'search','results':5,'order':'most_relevance','player':'link','layout':'full'});" +
        "</script>";
        youtubeView.getEngine().load(embed);
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
