package teamj;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationMain extends Application {

	BorderPane root;
	
	public void start(Stage primaryStage) {
		root = new BorderPane();

		Label topLbl = new Label("Top");
		Label botLbl = new Label("Bottom");
		Label rLbl = new Label("Right");
		Label lLbl = new Label("Left");

		root.setTop(topLbl);
		root.setAlignment(topLbl, Pos.CENTER);
		root.setBottom(botLbl);
		root.setAlignment(botLbl, Pos.CENTER);
		root.setRight(rLbl);
		root.setAlignment(rLbl, Pos.CENTER);
		root.setLeft(lLbl);
		root.setAlignment(lLbl, Pos.CENTER);

		setupRegistrationForm();
		
		Scene scene = new Scene(root, 600, 500);

		primaryStage.setTitle("BorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void setupRegistrationForm(){
		GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        
        Label firstNameLbl = new Label("First Name:");
        pane.add(firstNameLbl, 0, 1);
        final TextField firstNameField = new TextField();
        pane.add(firstNameField, 1, 1);
        
        Label lastNameLbl = new Label("Last Name:");
        pane.add(lastNameLbl, 0, 2);
        final TextField lastNameField = new TextField();
        pane.add(lastNameField, 1, 2);
        
        Label emailLbl = new Label("Email:");
        pane.add(emailLbl, 0, 3);
        final TextField emailField = new TextField();
        pane.add(emailField, 1, 3);
        
        Label passwordLbl = new Label("Password:");
        pane.add(passwordLbl,0,4);
        final PasswordField passwordField = new PasswordField();
        pane.add(passwordField, 1, 4);
        
        Label passwordRetypeLbl = new Label("Retype Password:");
        pane.add(passwordRetypeLbl,0,5);
        final PasswordField passwordRetypeField = new PasswordField();
        pane.add(passwordRetypeField, 1, 5);
        
      
        Button registerBtn = new Button("Register");        
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(registerBtn);
        pane.add(hbox, 1, 6);
 
        root.setCenter(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
