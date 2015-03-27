/**
 * Controller for the Stats FXML page
 *
 * @author Taylor Scott (tdscott2@asu.edu)
 * @version Mar 16, 2015
 */
package controller;

import model.Game;
import model.User;
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

public class StatsController
				implements Initializable, view.ControlledScreen{

	view.ScreensController controller;
    
    public User currentUser = new User();
                    
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
		controller = new view.ScreensController();
	}
	
	@Override
	public void setScreenParent(view.ScreensController screenPage) {
		
		controller = screenPage;
		
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
        
        System.out.println(currentUser.getEmail());
        
        Game game = new Game(currentUser.getId(), Integer.parseInt(weekTxt.getText()),
                            opponentTxt.getText(),
                            yourScore.getText() + "-" + theirScore.getText(),
                            datePicker.getValue());
        
        if(gameDao.addGame(game))
            controller.setScreen(view.Main.homeName);
    }
}

