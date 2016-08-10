package org.waikato.comp204;
//https://www.youtube.com/watch?v=QGGE0WsUslc
//http://stackoverflow.com/questions/32866937/how-to-check-if-textfield-is-empty
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


public class Project extends Application {
    private static GridPane grid = new GridPane();

    private static String itemA;
    private static String itemB;
    private static String itemC;

    private static int amountA;
    private static int amountB;
    private static int amountC;

    private static double priceA;
    private static double priceB;
    private static double priceC;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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

    public static void setupGrid() {
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 20, 0, 20));
        //grid.setGridLinesVisible(true);

    }

    public static void setupInputTextFields() {

        // ------------------    INPUT    ------------------
        // ----------- ITEMS
        TextField inputItemA = new TextField();
        grid.add(inputItemA, 1, 4);
        inputItemA.setPrefWidth(200);
        inputItemA.setOnKeyReleased(event -> itemA = inputItemA.getText());

        TextField inputItemB = new TextField();
        grid.add(inputItemB, 1, 5);
        inputItemB.setPrefWidth(200);
        inputItemB.setOnKeyReleased(event -> itemB = inputItemB.getText());

        TextField inputItemC = new TextField();
        grid.add(inputItemC, 1, 6);
        inputItemC.setPrefWidth(200);
        inputItemC.setOnKeyReleased(event -> itemC = inputItemC.getText());

        // ---------- AMOUNT
        TextField inputAmountA = new TextField();
        grid.add(inputAmountA, 2, 4);
        inputAmountA.setPrefWidth(50);
        inputAmountA.setOnKeyReleased(event -> amountA = Integer.parseInt(inputAmountA.getText()));

        TextField inputAmountB = new TextField();
        grid.add(inputAmountB, 2, 5);
        inputAmountB.setPrefWidth(50);
        inputAmountB.setOnKeyReleased(event -> amountB = Integer.parseInt(inputAmountB.getText()));

        TextField inputAmountC = new TextField();
        grid.add(inputAmountC, 2, 6);
        inputAmountC.setPrefWidth(50);
        inputAmountC.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (CheckIfNum(inputAmountC.getText())) {
                    amountC = Integer.parseInt(inputAmountC.getText());
                } else {
                    if (!inputAmountC.getText().trim().isEmpty()) {
                        inputAmountC.setText(amountC + "");
                    }
                }
            }
        });

        // ---------- PRICE
        TextField inputPriceA = new TextField();
        grid.add(inputPriceA, 3, 4);
        inputPriceA.setPrefWidth(75);
        //inputPriceA.setOnKeyReleased(event -> priceA = double.parseInt(priceA.getText()));

        TextField inputPriceB = new TextField();
        grid.add(inputPriceB, 3, 5);
        inputPriceB.setPrefWidth(75);

        TextField inputPriceC = new TextField();
        grid.add(inputPriceC, 3, 6);
        inputPriceC.setPrefWidth(75);
    }

    private static void CheckTextBox(TextField x)
    {

    }
    private static boolean CheckIfNum(String num)
    {
        try{
            int x = Integer.parseInt(num);
            return true;
        }
        catch(Exception e)
        {
        }
        return false;
    }

    private static void Calculate()
    {

    }


}


