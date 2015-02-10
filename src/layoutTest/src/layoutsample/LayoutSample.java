/*
 * Copyright (c) 2012 , 2013 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package layoutsample;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Basic Concept of layout taken from the JavaFX Oracle website "Working With Layouts in JavaFX".
 * Other Properties taken from the JavaFX Ensemble open source.
 * http://docs.oracle.com/javafx/2/layout/style_css.htm
 * Joni Gordon is the author of the article
 */
public class LayoutSample extends Application {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(LayoutSample.class, args);
	}

	@Override
	public void start(Stage stage) {

		// Use a border pane as the root for scene
		BorderPane border = new BorderPane();

		HBox hbox = addHBox();
		border.setTop(hbox);
		border.setLeft(addVBox());

		// Add a stack to the HBox in the top region
		addStackPane(hbox);

		border.setRight(addFlowPane());
		border.setCenter(addAnchorPane(addGridPane()));

		Scene scene = new Scene(border);
		stage.setScene(scene);
		stage.setTitle("Compare Me");
		stage.show();
	}

	/*
	 * Creates an HBox for the top region
	 */

	private HBox addHBox() {

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(0); // Gap between nodes
		hbox.setStyle("-fx-background-color: blue");

		ToggleButton tb1 = new ToggleButton("Home");
		tb1.setId("pill-home");

		ToggleButton tb2 = new ToggleButton("Page2");
		tb2.setId("pill-page2");

		ToggleButton tb3 = new ToggleButton("Page3");
		tb3.setId("pill-page3");

		ToggleGroup group = new ToggleGroup();
		tb1.setToggleGroup(group);
		tb2.setToggleGroup(group);
		tb3.setToggleGroup(group);

		hbox.getChildren().addAll(tb1, tb2, tb3);

		return hbox;
	}

	/*
	 * Creates a VBox with a list of links for the left region
	 */
	private VBox addVBox() {

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10)); // Set all sides to 10
		vbox.setSpacing(8); // Gap between nodes
		vbox.setStyle("-fx-border-color: black");

		Text title = new Text("Account Name");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 26));
		vbox.getChildren().add(title);
		
		Hyperlink sportsHyperlink = new Hyperlink("Sports");
		sportsHyperlink.setStyle("-fx-font-size: 20");
		
		Hyperlink recentGamesHyperlink = new Hyperlink("Recent Games");
		recentGamesHyperlink.setStyle("-fx-font-size: 20");
		
		Hyperlink friendsHyperlink = new Hyperlink("Friends");
		friendsHyperlink.setStyle("-fx-font-size: 20");
		
		vbox.getChildren().add(sportsHyperlink);
		vbox.getChildren().add(recentGamesHyperlink);
		vbox.getChildren().add(friendsHyperlink);

		return vbox;
	}

	/*
	 * Uses a stack pane to create a help icon and adds it to the right side of
	 * an HBox
	 * 
	 * @param hb HBox to add the stack to
	 */
	private void addStackPane(HBox hb) {

		StackPane stack = new StackPane();
		Rectangle helpIcon = new Rectangle(30.0, 25.0);
		helpIcon.setFill(new LinearGradient(0, 0, 0, 1, true,
				CycleMethod.NO_CYCLE, new Stop[] {
						new Stop(0, Color.web("#4977A3")),
						new Stop(0.5, Color.web("#B0C6DA")),
						new Stop(1, Color.web("#9CB6CF")), }));
		helpIcon.setStroke(Color.web("#D0E6FA"));
		helpIcon.setArcHeight(3.5);
		helpIcon.setArcWidth(3.5);

		Text helpText = new Text("?");
		helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		helpText.setFill(Color.WHITE);
		helpText.setStroke(Color.web("#7080A0"));

		stack.getChildren().addAll(helpIcon, helpText);
		stack.setAlignment(Pos.CENTER_RIGHT);
		// Add offset to right for question mark to compensate for RIGHT
		// alignment of all nodes
		StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));

		hb.getChildren().add(stack);
		HBox.setHgrow(stack, Priority.ALWAYS);

	}

	/*
	 * Creates a grid for the center region with four columns and three rows
	 */
	private GridPane addGridPane() {

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		// Category in column 2, row 1
		Text category = new Text("Home Page Text:");
		category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		grid.add(category, 1, 0);

		//grid.setGridLinesVisible(true);
		return grid;
	}

	/*
	 * Creates a horizontal flow pane with eight icons in four rows
	 */
	private FlowPane addFlowPane() {

		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(170); // preferred width allows for two columns
		flow.setStyle("-fx-background-color: DAE6F3;");
		
		Image soccerTile = new Image(
				LayoutSample.class.getResourceAsStream("graphics/football.png"));
		
		ImageView imageView = new ImageView(soccerTile);
		Button button1 = new Button("Football", imageView);
		button1.setContentDisplay(ContentDisplay.LEFT);
		flow.getChildren().add(button1);

		final Image footballTile = new Image(
				LayoutSample.class.getResourceAsStream("graphics/soccer.png"));

		ImageView imageView2 = new ImageView(footballTile);
		Button button2 = new Button("Soccer", imageView2);
		button2.setContentDisplay(ContentDisplay.LEFT);
		flow.getChildren().add(button2);

		final Image basketballTile = new Image(
				LayoutSample.class
						.getResourceAsStream("graphics/basketball.png"));

		ImageView imageView3 = new ImageView(basketballTile);
		Button button3 = new Button("Basketball", imageView3);
		button3.setContentDisplay(ContentDisplay.LEFT);
		flow.getChildren().add(button3);

		final Image baseballTile = new Image(
				LayoutSample.class.getResourceAsStream("graphics/baseball.png"));

		ImageView imageView4 = new ImageView(baseballTile);
		Button button4 = new Button("Baseball", imageView4);
		button4.setContentDisplay(ContentDisplay.LEFT);
		flow.getChildren().add(button4);

		return flow;
	}

	/*
	 * Creates an anchor pane using the provided grid and an HBox with buttons
	 * 
	 * @param grid Grid to anchor to the top of the anchor pane
	 */
	private AnchorPane addAnchorPane(GridPane grid) {

		AnchorPane anchorpane = new AnchorPane();

		Button buttonA = new Button("More Buttons");
		Button buttonB = new Button("Even More Buttons");

		HBox hb = new HBox();
		hb.setPadding(new Insets(0, 10, 10, 10));
		hb.setSpacing(10);
		hb.getChildren().addAll(buttonA, buttonB);

		anchorpane.getChildren().addAll(grid, hb);
		// Anchor buttons to bottom right, anchor grid to top
		AnchorPane.setBottomAnchor(hb, 8.0);
		AnchorPane.setTopAnchor(grid, 10.0);

		return anchorpane;
	}
	

}