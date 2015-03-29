/**
 * Controller for the Game FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import model.Game;
import service.*;

public class GameController implements Initializable {

	view.MainNavigator controller;
                    
    @FXML
    private TableColumn weekCol;
    @FXML
    private TableColumn dateCol;
    @FXML
    private TableColumn opponentCol;
    @FXML
    private TableColumn scoreCol;
    @FXML
    private TableView table;
	
	public GameController(){
		controller = new view.MainNavigator();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        
        DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
        GameDao gameDao = daoFact.getGameDao();
        
        Game[] games = new Game[20];
        games = gameDao.findGames(controller.getSessionUserId());
        
        for(int i=0; i < games.length; i++) {
            System.out.println(games[i].getOpponent());
        }
        
        table.setItems(FXCollections.observableArrayList(games));
	}
                    
    /**
     * Changes the current FXML page to stats.fxml
     * @param e
     */
    @FXML
    private void changeToStats() {
        controller.loadScreen(controller.STATS_FXML);
    }
    
    /**
     * Changes the current FXML page to home.fxml
     * @param e
     */
    @FXML
    private void changeToHome() {
        controller.loadScreen(controller.HOME_FXML);
    }
}

