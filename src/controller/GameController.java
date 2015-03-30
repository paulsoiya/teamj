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
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
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
    
    
    DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    GameDao gameDao = daoFact.getGameDao();
    
    Game[] games = new Game[20];
 
	
	public GameController(){
		controller = new view.MainNavigator();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        
        games = gameDao.findGames(controller.getSessionUserId());
        weekCol.setCellValueFactory(
                    new PropertyValueFactory<Game, Integer>("week"));
        dateCol.setCellValueFactory(
                    new PropertyValueFactory<Game, LocalDate>("date"));
        opponentCol.setCellValueFactory(
                    new PropertyValueFactory<Game, String>("opponent"));
        scoreCol.setCellValueFactory(
                    new PropertyValueFactory<Game, String>("score"));
        
        table.setItems(FXCollections.observableArrayList(games));
	}
                    
    /**
     * Changes the current FXML page to stats.fxml
     * @param e
     */
    @FXML
    private void changeToStats() {
        controller.loadScreen(controller.STATS_FXML);
        
        System.out.println(controller.getSessionUserId());
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

