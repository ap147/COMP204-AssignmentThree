package org.waikato.comp204;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FormDesign extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        //Setting Windows Title Name
        primaryStage.setTitle("JavaFX Welcome");

        //Flixable grid (Username & Password)
        GridPane grid = new GridPane();
        //Setting in what position we want the grid (Username : + Password: ) to be in
        grid.setAlignment(Pos.CENTER);
        //Grid line gaps
        grid.setHgap(10);
        grid.setVgap(10);
        //How big the space within grid
        grid.setPadding(new Insets(25,25,25,25));
        //Enables visable gridlines
        //grid.setGridLinesVisible(true);

        //THIS WONT WORK FOR SOME REASON
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0,0,2,1);

        //Username & Password
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        //Where User will type Username
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password");
        grid.add(pw, 0, 2);
        //Where User will type password
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        //Create Button, position to bottom right
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        //Text control for displaying message
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        //Action for when button is pressed
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });


        //Createing,sizing Scene
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

