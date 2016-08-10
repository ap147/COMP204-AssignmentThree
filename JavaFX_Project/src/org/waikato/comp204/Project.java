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
    @Override
    public void start(Stage primaryStage)
    {
        //Setting Window Title
        primaryStage.setTitle("JavaFX Project");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 750, 400);

        




        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

