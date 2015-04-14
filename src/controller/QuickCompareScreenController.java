/**
 * Controller for the Compare FXML page
 * 
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package controller;

import static view.MainNavigator.LOGIN_FXML;
import static view.MainNavigator.REG_FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ProInfo;
import model.TeamInfo;
import model.Compare;
import service.DaoFactory;
import service.ProInfoDao;
import service.CompareDao;
import session.UserSession;
import view.MainNavigator;

public class QuickCompareScreenController implements Initializable {
    
    @FXML
    private Label nameTxt;
    @FXML
    private Label positionTxt;
    @FXML
    private Label numberTxt;
    @FXML
    private Label teamTxt;
    @FXML
    private Label dobTxt;
    @FXML
    private Label weightTxt;
    @FXML
    private Label heightTxt;
    @FXML
    private Label collegeTxt;
    @FXML
    private Label attemptsTxt;
    @FXML
    private Label yardsTxt;
    @FXML
    private Label touchdownTxt;
    @FXML
    private ImageView playerPicture;
    @FXML
    private ImageView teamPicture;
	
	view.MainNavigator controller;
    
    private UserSession session = UserSession.getInstance();
    
    DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    ProInfoDao infoDao = daoFact.getProInfoDao();
    CompareDao compareDao = daoFact.getCompareDao();
    
    ProInfo info = new ProInfo();
    TeamInfo teamInfo = new TeamInfo();
    Compare comp = new Compare();
	
	public QuickCompareScreenController() {
		controller = new view.MainNavigator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        int statsId = session.getProStatsId();
        
        info = infoDao.findProInfo(statsId);
        teamInfo = infoDao.findTeamInfo(info.getTeam());
        comp = compareDao.inputStats(session.getGameId(), statsId);
        nameTxt.setText(info.getName());
        positionTxt.setText(info.getPosition());
        numberTxt.setText(Integer.toString(info.getNumber()));
        collegeTxt.setText(info.getCollege());
        heightTxt.setText(Integer.toString(info.getHeight()));
        weightTxt.setText(Integer.toString(info.getWeight()));
        dobTxt.setText(info.getDOB());
        teamTxt.setText(teamInfo.getTeamName());
        Image img = new Image(info.getPicture());
        playerPicture.setImage(img);
        Image imgTeam = new Image(teamInfo.getTeamPicture());
        teamPicture.setImage(imgTeam);
        attemptsTxt.setText(Integer.toString(comp.getProAttempts()));
        yardsTxt.setText(Integer.toString(comp.getProYards()));
        touchdownTxt.setText(Integer.toString(comp.getProTouchdowns()));
	}
	
	/**
	 * Changes the current FXML page to the login.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToLogin(ActionEvent e) {
		MainNavigator.loadScreen(LOGIN_FXML);
	}
    
    /**
     * Changes the current FXML page to the register.fxml
     *
     * @param e
     */
    @FXML
    private void changeToRegister(ActionEvent e) {
        MainNavigator.loadScreen(REG_FXML);
    }
	
}