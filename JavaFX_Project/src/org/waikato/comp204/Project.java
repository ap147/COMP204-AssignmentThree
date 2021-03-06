package org.waikato.comp204;
//https://www.youtube.com/watch?v=QGGE0WsUslc
//http://stackoverflow.com/questions/32866937/how-to-check-if-textfield-is-empty
//http://docs.oracle.com/javafx/2/layout/builtin_layouts.html

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Project extends Application {
    private static GridPane grid = new GridPane();

    private static item[] items = new item[3];
    //right hand side of the grid, includes non editable text fields which update when user updates info about any of item
    private static TextField[] ItemNameAmouunt = new TextField[3];
    //The forth textfield belongs to the grand total textfield
    private static TextField[] ItemTotal = new TextField[4];
    //holds the grand total of all items
    private static double GrandTotal;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Project");
        //Adds Items To Items List
        setupItems();
        setupGrid();
        //Creates Input Fields for User
        setupInputTextFields();
        //Create Right hand side fields, non editable
        setupCalculationfields();

        Scene scene = new Scene(grid, 850, 225);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private static void setupItems()
    {
        item itemA = new item();
        item itemB = new item();
        item itemC = new item();

        items[0] = itemA;
        items[1] = itemB;
        items[2] = itemC;
    }
    private static void setupGrid() {
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 20, 0, 20));
        //Used for texting, shows grid lines when true parameter is passed
        grid.setGridLinesVisible(false);
    }

    //Calls other methods which create/set action events for text fields
    public static void setupInputTextFields() {
        setupInputItemNAMEFields();
        setupInputAMOUNTFields();
        setupInputPRICEFields();
    }


    //Creates TextBoxs for items names, positions them on grid, sets actionevents
    public static void setupInputItemNAMEFields()
    {
        // ----------- ITEMS
        //Creating Textfield, adding to grid, setting size properties
        TextField inputItemA = new TextField();
        grid.add(inputItemA, 1, 4);
        inputItemA.setMinWidth(200);
        inputItemA.setPrefWidth(200);
        inputItemA.setMaxWidth(200);
        //calls a method to store items name in array, passing in where item is located in array
        inputItemA.setOnKeyReleased(event -> StoreName(inputItemA.getText(), 0));

        TextField inputItemB = new TextField();
        grid.add(inputItemB, 1, 5);
        inputItemB.setMinWidth(200);
        inputItemB.setPrefWidth(200);
        inputItemB.setMaxWidth(200);
        inputItemB.setOnKeyReleased(event -> StoreName(inputItemB.getText(), 1));

        TextField inputItemC = new TextField();
        grid.add(inputItemC, 1, 6);
        inputItemC.setMinWidth(200);
        inputItemC.setPrefWidth(200);
        inputItemC.setMaxWidth(200);
        inputItemC.setOnKeyReleased(event -> StoreName(inputItemC.getText(), 2));
    }
    public static void setupInputAMOUNTFields()
    {
        TextField inputAmountA = new TextField();
        grid.add(inputAmountA, 2, 4);
        inputAmountA.setMinWidth(50);
        inputAmountA.setPrefWidth(50);
        inputAmountA.setMaxWidth(50);

        inputAmountA.setOnKeyReleased( event -> CheckTextBox(inputAmountA,0, false));

        TextField inputAmountB = new TextField();
        grid.add(inputAmountB, 2, 5);
        inputAmountB.setMinWidth(50);
        inputAmountB.setPrefWidth(50);
        inputAmountB.setMaxWidth(50);

        inputAmountB.setOnKeyReleased( event -> CheckTextBox(inputAmountB,1, false));

        TextField inputAmountC = new TextField();
        grid.add(inputAmountC, 2, 6);
        inputAmountC.setMinWidth(50);
        inputAmountC.setPrefWidth(50);
        inputAmountC.setMaxWidth(50);

        inputAmountC.setOnKeyReleased( event -> CheckTextBox(inputAmountC,2, false));
    }
    public static void setupInputPRICEFields()
    {
        TextField inputPriceA = new TextField();
        grid.add(inputPriceA, 3, 4);
        inputPriceA.setMinWidth(75);
        inputPriceA.setPrefWidth(75);
        inputPriceA.setMaxWidth(75);
        inputPriceA.setOnKeyReleased(event -> CheckTextBox(inputPriceA, 0, true));

        TextField inputPriceB = new TextField();
        grid.add(inputPriceB, 3, 5);
        inputPriceB.setMinWidth(75);
        inputPriceB.setPrefWidth(75);
        inputPriceB.setMaxWidth(75);
        inputPriceB.setOnKeyReleased(event -> CheckTextBox(inputPriceB, 1, true));

        TextField inputPriceC = new TextField();
        grid.add(inputPriceC, 3, 6);
        inputPriceC.setMinWidth(75);
        inputPriceC.setPrefWidth(75);
        inputPriceC.setMaxWidth(75);
        inputPriceC.setOnKeyReleased(event -> CheckTextBox(inputPriceC, 2, true));
    }

    //Creates Right hand side text fields, makes them noneditable, positions them
    private static void setupCalculationfields()
    {
        //------------------ AMOUNT
        //Creating TextField, setting its size
        TextField itemAmountA = new TextField();
        itemAmountA.setPrefWidth(275);
        itemAmountA.setDisable(true);
        //Positioning it on grid, adding it to array
        grid.add(itemAmountA, 10, 4);
        ItemNameAmouunt[0] = itemAmountA;

        TextField itemAmountB = new TextField();
        itemAmountB.setPrefWidth(275);
        itemAmountB.setDisable(true);

        grid.add(itemAmountB, 10, 5);
        ItemNameAmouunt[1] = itemAmountB;

        TextField itemAmountC = new TextField();
        itemAmountC.setMinWidth(275);
        itemAmountC.setPrefWidth(275);
        itemAmountC.setMaxWidth(275);
        itemAmountC.setDisable(true);

        grid.add(itemAmountC, 10, 6);
        ItemNameAmouunt[2] = itemAmountC;


        //------------------- TOTAL
        TextField ItemTotalTextA = new TextField();
        ItemTotalTextA.setPrefWidth(100);
        ItemTotalTextA.setDisable(true);

        grid.add(ItemTotalTextA, 11, 4);
        ItemTotal[0] = ItemTotalTextA;

        TextField ItemTotalTextB = new TextField();
        ItemTotalTextB.setPrefWidth(100);
        ItemTotalTextB.setDisable(true);

        grid.add(ItemTotalTextB, 11, 5);
        ItemTotal[1] = ItemTotalTextB;

        TextField ItemTotalTextC = new TextField();
        ItemTotalTextC.setPrefWidth(100);
        ItemTotalTextC.setDisable(true);

        grid.add(ItemTotalTextC, 11, 6);
        ItemTotal[2] = ItemTotalTextC;

        //------------------- GRAND TOTAL

        TextField TotalToal = new TextField();
        TotalToal.setText("Total : $ "+ GrandTotal);
        //Setting size & nonedittable
        TotalToal.setPrefWidth(150);
        TotalToal.setDisable(true);

        grid.add(TotalToal, 10, 7);
        //Storing GRAND total TextField
        ItemTotal[3] = TotalToal;
    }

    //Checkes if the input is an int or a double, if its not then it sets it to the privious value
    private static void CheckTextBox(TextField x, int index, boolean isitPrice)
    {
        System.out.println("Input Detected");
        //If a double is expected
        if(isitPrice)
        {
            System.out.println("PRICE Input");
            //And its a double
            if (CheckIfNum(x.getText(),true))
            {
                //Then Update value
                System.out.println("Correct input");
                items[index].setPrice(Double.parseDouble(x.getText()));
            }
            else
            {
                //Change textbox value to privous value before invalid output was made
                System.out.println("Invalid input");
                if (!x.getText().trim().isEmpty())
                {
                    x.setText(items[index].getPrice() + "");
                }
                else
                {
                    items[index].setPrice(0);
                }

            }
           System.out.println(items[index].getPrice());
            //updateing noneditable text fields & recalculating GrandTotal
            CalculateGrandTotal();
            updateThis(index);
        }
        else
        {
            System.out.println("AMOUNT Input");
            if (CheckIfNum(x.getText(),false))
            {
                System.out.println("Correct input");
                items[index].setAmount(Integer.parseInt(x.getText()));
            }
            else
            {
                System.out.println("Invalid input");
                if (!x.getText().trim().isEmpty())
                {
                    x.setText(items[index].getAmount() + "");
                }
                else
                {
                    items[index].setAmount(0);
                }
            }
            System.out.println(items[index].getAmount());
            CalculateGrandTotal();
            updateThis(index);
        }

    }
    //retusn true if passed in value is an number, where being double or int
    private static boolean CheckIfNum(String num, boolean isitPrice)
    {
        try{
            //if its a double
            if(isitPrice)
            {
                //try turning it to a double
                double x = Double.parseDouble(num);
                return true;
            }
            else
            {
                int x = Integer.parseInt(num);
                return true;
            }
        }
        catch(Exception e)
        {
        }
        return false;
    }
    //Gets called everytime an update has been made in Items Name TextFields (setupInputItemNAMEFields())
    private static void StoreName(String _itemName, int index)
    {
        items[index].setName(_itemName);
        //Updates the right non editable side
        updateThis(index);
    }


    //Updates right hand side of program by given parameter, it indexes in array using that
    private static void updateThis(int index)
    {
        //Setting Item Name & Amount
        ItemNameAmouunt[index].setText(items[index].getName() + " x" + items[index].getAmount());
        //Setting Items Total
        ItemTotal[index].setText("$"+items[index].getTotal());
        //Setting GrandTotal of all items
        ItemTotal[3].setText("Total : $" + GrandTotal);

    }
    //goes through the array, asking every item for there total and adds it to grandtotal
    private static void CalculateGrandTotal()
    {
        GrandTotal = 0;
        System.out.println();
        System.out.println("Calculating..");
        //loop thoguh the array
        for(int x = 0; x < items.length; x++)
        {
            //Grandtotal plus current items total
            GrandTotal = GrandTotal + (items[x].getTotal());
        }
        System.out.println("Total :" + GrandTotal );
    }
}

//Used to store item name,amount & price
class item
{
    private String Name;
    private int Amount;
    private double Price;
    private double Total;
    public item()
    {
        Amount = 0; Price = 0; Name = "";
    }

    public void setName(String _n)
    {
        Name = _n;
    }
    public void setAmount(int _a)
    {
        Amount = _a;
    }
    public void setPrice(double _p)
    {
        Price = _p;
    }

    public String getName()
    {
        return Name;
    }
    public Integer getAmount()
    {
        return Amount;
    }
    public Double getPrice()
    {
        return Price;
    }
    public Double getTotal(){
        Total = Price * Amount;
        return  Total;
    }
}


