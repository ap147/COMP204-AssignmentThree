package org.waikato.comp204;
//https://docs.oracle.com/javase/8/javafx/get-started-tutorial/hello_world.html

import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class HelloWorld extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MessageBox.display("Hello World!!");
                System.out.println("Hello World");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[]args)
    {
        launch(args);
    }
}
class MessageBox
{
    //Displays whatever value is passed in through a label which is displayed on a message box
    public static void display(String x) {
        Stage Box = new Stage();
        Box.setTitle("Message");

        Box.setWidth(250);
        Box.setHeight(75);
        Box.initModality(Modality.APPLICATION_MODAL);
        javafx.scene.control.Label Message = new javafx.scene.control.Label();
        Message.setText(x);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        layout.getChildren().addAll(Message);
        Box.setScene(scene);
        //waits for this window to close before continueing other windoews code.
        Box.showAndWait();
    }
}