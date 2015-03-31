/**
 * Controller for the Sport FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class SportController implements Initializable {

	view.MainNavigator controller;
	
	@FXML
	private ChoiceBox<String> sportCB;
	@FXML
	private ChoiceBox<String> positionCB;
	@FXML
	private ChoiceBox<String> favTeamCB;
	
	public SportController() {
		controller = new view.MainNavigator();
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		sportCB.setItems(FXCollections.observableArrayList("Football"));
		positionCB
				.setItems(FXCollections.observableArrayList("QB", "RB", "WR"));
		favTeamCB.setItems(FXCollections.observableArrayList(
				"Arizona Cardinals", "Atlanta Falcons", "Baltimore Ravens",
				"Buffalo Bills", "Carolina Panthers", "Chicago Bears",
				"Cincinnati Bengals", "Cleveland Browns", "Dallas Cowboys",
				"Denver Broncos", "Detroit Lions", "Green Bay Packers",
				"Houston Texans", "Indianapolis Colts", "Jacksonville Jaguars",
				"Kansas City Chiefs", "Miami Dolphins", "Minnesota Vikings",
				"New England Patriots", "New Orleans Saints",
				"New York Giants", "New York Jets", "Oakland Raiders",
				"Philadelphia Eagles", "Pittsburgh Steelers",
				"Saint Louis Rams", "San Diego Chargers",
				"San Francisco 49ers", "Seattle Seahawks",
				"Tampa Bay Buccaneers", "Tennessee Titans",
				"Washington Redskins"));

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

