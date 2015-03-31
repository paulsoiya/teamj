/**
 * Controller for the Stats FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 31, 2015
 */
package controller;

import model.Game;
import model.User;
import model.Stats;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.collections.*;
import javafx.event.ActionEvent;
import service.*;

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
	
	public StatsController(){
		controller = new view.MainNavigator();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
                    
    /**
     * Changes the current FXML page to home.fxml
     * @param e
     */
    @FXML
    private void changeToHome() {
        DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
        UserDao usrDao = daoFact.getUserDao();
        GameDao gameDao = daoFact.getGameDao();
        StatsDao statsDao = daoFact.getStatsDao();
        SportDao sportDao = daoFact.getSportDao();
        try {
            //Load Game info
            int week = Integer.parseInt(weekTxt.getText());
            Game game = new Game(controller.getSessionUserId(), week,
                                 opponentTxt.getText(),
                                 yourScore.getText() + "-" + theirScore.getText(),
                                 datePicker.getValue());
            gameDao.addGame(game);
            
            //Load Stats
            int gameId = gameDao.findGameID(game);
            int yards = Integer.parseInt(yardsTxt.getText());
            int touchdown = Integer.parseInt(touchdownTxt.getText());
            int attempts = Integer.parseInt(attemptsTxt.getText());
            Stats stats = new Stats(gameId, controller.getSessionUserId(),
                                    yards, touchdown, attempts);
            if (statsDao.addStats(stats))
                controller.loadScreen(controller.HOME_FXML);
        }
        catch (NumberFormatException e) {
            //TODO
        }
    }
}

