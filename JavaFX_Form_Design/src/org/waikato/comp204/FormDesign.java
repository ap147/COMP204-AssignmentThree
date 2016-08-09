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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

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


        //Createing,sizing Scene
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
// Your Form Design JavaFX code goes here
