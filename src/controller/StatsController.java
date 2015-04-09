/**
 * Controller for the Stats FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Game;
import model.Stats;
import service.CompareDao;
import service.DaoFactory;
import service.GameDao;
import service.SportDao;
import service.StatsDao;
import service.UserDao;

public class StatsController implements Initializable {
	
	view.MainNavigator controller;
	
	@FXML
	private TextField weekTxt;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TextField opponentTxt;
	@FXML
	private TextField yourScore;
	@FXML
	private TextField theirScore;
	@FXML
	private TextField attemptsTxt;
	@FXML
	private TextField yardsTxt;
	@FXML
	private TextField touchdownTxt;
	
	public StatsController() {
		controller = new view.MainNavigator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Changes the current FXML page to compare.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToCompare() {
		DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
		UserDao usrDao = daoFact.getUserDao();
		GameDao gameDao = daoFact.getGameDao();
		StatsDao statsDao = daoFact.getStatsDao();
		SportDao sportDao = daoFact.getSportDao();
		CompareDao compareDao = daoFact.getCompareDao();
		try {
			// Load Game info
			int week = Integer.parseInt(weekTxt.getText());
			Game game = new Game(controller.getSessionUserId(), week,
					opponentTxt.getText(), yourScore.getText() + "-"
							+ theirScore.getText(), datePicker.getValue().toString());
			gameDao.addGame(game);
			
			// Load Stats
			int gameId = gameDao.findGameID(game);
			int yards = Integer.parseInt(yardsTxt.getText());
			int touchdown = Integer.parseInt(touchdownTxt.getText());
			int attempts = Integer.parseInt(attemptsTxt.getText());
			Stats stats = new Stats(gameId, controller.getSessionUserId(), yards,
					touchdown, attempts);
			
			if (statsDao.addStats(stats))
				controller.loadScreen(controller.COMPARE);
			
			compareDao.playerComparison(statsDao.findCompareAverage(gameId),
					sportDao.findPositionFootball(controller.getSessionUserId()),
					sportDao.findTeamFootball(controller.getSessionUserId()),
                    gameId);
		}
		catch (NumberFormatException e) {
			System.out.println(this.getClass().getName() + " error: " + e.getMessage());
		}
	}
	
	/**
	 * Changes the current FXML page to compare.fxml
	 * 
	 * @param e
	 */
	@FXML
	private void changeToHome() {
		controller.loadScreen(controller.HOME_FXML);
	}
}
