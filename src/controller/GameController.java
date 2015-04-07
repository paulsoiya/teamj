/**
 * Controller for the Game FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

import model.Game;
import service.*;
import session.*;

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
    
    private UserSession session = UserSession.getInstance();
    
    
    DaoFactory daoFact = (DaoFactory) DaoFactory.getDaoFactory();
    GameDao gameDao = daoFact.getGameDao();
    
    List<Game> games = new ArrayList<Game>();
 
	
	public GameController(){
		controller = new view.MainNavigator();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        
        games = gameDao.findGames(session.getUserId());
        weekCol.setCellValueFactory(
                    new PropertyValueFactory<Game, Integer>("week"));
        dateCol.setCellValueFactory(
                    new PropertyValueFactory<Game, String>("date"));
        opponentCol.setCellValueFactory(
                    new PropertyValueFactory<Game, String>("opponent"));
        scoreCol.setCellValueFactory(
                    new PropertyValueFactory<Game, String>("score"));
        ObservableList<Game> data = FXCollections.observableArrayList();
        
        for(int i=0; i < games.size(); i++) {
            data.add(games.get(i));
        }
        
        table.setItems(data);
        
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    controller.loadScreen(controller.COMPARE);
                }
            }
        });
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

