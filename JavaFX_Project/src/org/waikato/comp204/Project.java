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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Project extends Application
{
    private static GridPane grid = new GridPane();
    public static void main(String []args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("JavaFX Project");
        setupGrid();
        setupInputTextFields();

        Line line = new Line();

        line.setStartX(100f);
        line.setStartY(100f);
        line.setEndX(100f);
        line.setEndY(300f);

        Scene scene = new Scene(grid, 700, 250);
        primaryStage.setScene(scene);


        primaryStage.show();

    }

    public static void setupGrid()
    {
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0,20,0,20));
        //grid.setGridLinesVisible(true);

    }

    public static void setupInputTextFields()
    {

        // ------------------    INPUT    ------------------
        // ----------- ITEMS
        TextField inputItemA = new TextField();
        grid.add(inputItemA, 1, 4);
        inputItemA.setPrefWidth(200);
        inputItemA.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(inputItemA.getText());
            }
        });

        TextField inputItemB = new TextField();
        grid.add(inputItemB, 1, 5);
        inputItemB.setPrefWidth(200);

        TextField inputItemC = new TextField();
        grid.add(inputItemC, 1, 6);
        inputItemC.setPrefWidth(200);

        // ---------- AMOUNT
        TextField inputAmountA = new TextField();
        grid.add(inputAmountA, 2, 4);
        inputAmountA.setPrefWidth(50);

        TextField inputAmountB = new TextField();
        grid.add(inputAmountB, 2, 5);
        inputAmountB.setPrefWidth(50);

        TextField inputAmountC = new TextField();
        grid.add(inputAmountC, 2, 6);
        inputAmountC.setPrefWidth(50);

        // ---------- PRICE
        TextField inputPriceA = new TextField();
        grid.add(inputPriceA,3, 4);
        inputPriceA.setPrefWidth(75);

        TextField inputPriceB = new TextField();
        grid.add(inputPriceB, 3, 5);
        inputPriceB.setPrefWidth(75);

        TextField inputPriceC = new TextField();
        grid.add(inputPriceC, 3, 6);
        inputPriceC.setPrefWidth(75);
    }

    public static void Calculate()
    {

    }


}


