package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginMain extends Application {
    
    BorderPane root;
    
    public void start(Stage loginStage) {
        root = new BorderPane();
        
        setupLoginForm();
        
        Scene scene = new Scene(root, 600, 500);
        
        loginStage.setTitle("Login");
        loginStage.setScene(scene);
        loginStage.show();
    }
    
    public void setupLoginForm(){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        
        Label email = new Label("Email:");
        pane.add(email, 0, 1);
        final TextField emailField = new TextField();
        pane.add(emailField, 1, 1);
        
        Label passwordLbl = new Label("Password:");
        pane.add(passwordLbl,0,2);
        final PasswordField passwordField = new PasswordField();
        pane.add(passwordField, 1, 2);
        
        Button loginBtn = new Button("Login");
        loginBtn.setStyle("-fx-base: blue;");
        HBox hbox = new HBox(10);
        HBox.setHgrow(loginBtn, Priority.ALWAYS);
        loginBtn.setMaxWidth(Double.MAX_VALUE);
        hbox.getChildren().add(loginBtn);
        pane.add(hbox, 1, 3);
        
        Button registerBtn = new Button("Sign Up");
        registerBtn.setStyle("-fx-base: orange;");
        HBox hbox2 = new HBox(10);
        HBox.setHgrow(registerBtn, Priority.ALWAYS);
        registerBtn.setMaxWidth(Double.MAX_VALUE);
        hbox2.getChildren().add(registerBtn);
        pane.add(hbox2, 1, 4);
        
        Label split = new Label("-------------OR---------------");
        pane.add(split, 1, 5);
        
        Button quickCompareBtn = new Button("Quick Compare");
        quickCompareBtn.setStyle("-fx-base: green;");
        HBox hbox3 = new HBox(10);
        HBox.setHgrow(quickCompareBtn, Priority.ALWAYS);
        quickCompareBtn.setMaxWidth(Double.MAX_VALUE);
        hbox3.getChildren().add(quickCompareBtn);
        pane.add(hbox3, 1, 6);
        
        root.setCenter(pane);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
