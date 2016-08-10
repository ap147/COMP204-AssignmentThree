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


public class Project extends Application
{
    public static void main(String []args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("JavaFX Project");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0,20,0,20));


        //Setting Titles
        Text itemTitle = new Text("Item");
        itemTitle.setFont(Font.font("Arial",FontWeight.BOLD, 16));
        grid.add(itemTitle, 1, 1);

        Text categoryTitle = new Text("Amount");
        categoryTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        grid.add(categoryTitle, 10, 1);

        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);

        primaryStage.show();

    }


}


