package org.waikato.comp204;
//https://www.youtube.com/watch?v=QGGE0WsUslc
//http://stackoverflow.com/questions/32866937/how-to-check-if-textfield-is-empty
//http://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
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

    private static item[] items = new item[3];

    private static TextField[] ItemNameAmouunt = new TextField[3];
    private static TextField[] ItemTotalText = new TextField[3];

    private static double Total;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Project");
        setupItems();
        setupGrid();
        setupInputTextFields();
        setupCalculationfields();

        Scene scene = new Scene(grid, 850, 250);
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
        grid.setGridLinesVisible(false);

    }

    public static void setupInputTextFields() {

        // ------------------    INPUT    ------------------
        // ----------- ITEMS
        TextField inputItemA = new TextField();
        grid.add(inputItemA, 1, 4);
        inputItemA.setMinWidth(200);
        inputItemA.setPrefWidth(200);
        inputItemA.setMaxWidth(200);
      //  inputItemA.setOnKeyReleased(event -> itemA = inputItemA.getText());

        TextField inputItemB = new TextField();
        grid.add(inputItemB, 1, 5);
        inputItemB.setMinWidth(200);
        inputItemB.setPrefWidth(200);
        inputItemB.setMaxWidth(200);
      //  inputItemB.setOnKeyReleased(event -> itemB = inputItemB.getText());

        TextField inputItemC = new TextField();
        grid.add(inputItemC, 1, 6);
        inputItemC.setMinWidth(200);
        inputItemC.setPrefWidth(200);
        inputItemC.setMaxWidth(200);
        inputItemC.setOnKeyReleased(event -> StoreName(inputItemC.getText(), 2));

        // ---------- AMOUNT
        TextField inputAmountA = new TextField();
        grid.add(inputAmountA, 2, 4);
        inputAmountA.setMinWidth(50);
        inputAmountA.setPrefWidth(50);
        inputAmountA.setMaxWidth(50);
      //  inputAmountA.setOnKeyReleased(event -> amountA = Integer.parseInt(inputAmountA.getText()));

        TextField inputAmountB = new TextField();
        grid.add(inputAmountB, 2, 5);
        inputAmountB.setMinWidth(50);
        inputAmountB.setPrefWidth(50);
        inputAmountB.setMaxWidth(50);

        //inputAmountB.setOnKeyReleased(event -> amountB = Integer.parseInt(inputAmountB.getText()));

        TextField inputAmountC = new TextField();
        grid.add(inputAmountC, 2, 6);
        inputAmountC.setMinWidth(50);
        inputAmountC.setPrefWidth(50);
        inputAmountC.setMaxWidth(50);

        inputAmountC.setOnKeyReleased( event -> CheckTextBox(inputAmountC,2, false));

        // ---------- PRICE
        TextField inputPriceA = new TextField();
        grid.add(inputPriceA, 3, 4);
        inputPriceA.setMinWidth(75);
        inputPriceA.setPrefWidth(75);
        inputPriceA.setMaxWidth(75);
        //inputPriceA.setOnKeyReleased(event -> priceA = double.parseInt(priceA.getText()));

        TextField inputPriceB = new TextField();
        grid.add(inputPriceB, 3, 5);
        inputPriceB.setMinWidth(75);
        inputPriceB.setPrefWidth(75);
        inputPriceB.setMaxWidth(75);

        TextField inputPriceC = new TextField();
        grid.add(inputPriceC, 3, 6);
        inputPriceC.setMinWidth(75);
        inputPriceC.setPrefWidth(75);
        inputPriceC.setMaxWidth(75);
        inputPriceC.setOnKeyReleased(event -> CheckTextBox(inputPriceC, 2, true));
    }

    private static void CheckTextBox(TextField x, int index, boolean isitPrice)
    {
        System.out.println("Input Detected");
        if(isitPrice)
        {
            System.out.println("PRICE Input");
            if (CheckIfNum(x.getText(),true))
            {
                System.out.println("Correct input");
                items[index].setPrice(Double.parseDouble(x.getText()));
            }
            else
            {
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
            updateThis(index,"Price");
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
            updateThis(index,"Amount");
        }

        Calculate();
    }
    private static boolean CheckIfNum(String num, boolean isitPrice)
    {
        try{
            if(isitPrice)
            {
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
    private static void StoreName(String _itemName, int index)
    {
        items[index].setName(_itemName);
        updateThis(index,"Name");
    }






    private static void setupCalculationfields()
    {

        //------------------ AMOUNT
        TextField itemAmountC = new TextField(items[2].getName()+"x"+items[2].getAmount());
        itemAmountC.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        itemAmountC.setMinWidth(275);
        itemAmountC.setPrefWidth(275);
        itemAmountC.setMaxWidth(275);
        itemAmountC.setDisable(true);

        grid.add(itemAmountC, 10, 6);
        ItemNameAmouunt[2] = itemAmountC;


        //------------------- TOTAL
        TextField ItemTotalTextC = new TextField();
        ItemTotalTextC.setText("$"+items[2].getTotal());
        ItemTotalTextC.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        ItemTotalTextC.setPrefWidth(100);
        ItemTotalTextC.setDisable(true);

        grid.add(ItemTotalTextC, 11, 6);
        ItemTotalText[2] = ItemTotalTextC;
    }

    private static void updateThis(int index, String Type)
    {
        if(Type == "Amount" || Type =="Name")
        {
            ItemNameAmouunt[index].setText(items[index].getName() + " x" + items[index].getAmount());
        }
        else
        {
            ItemTotalText[index].setText("$"+items[index].getTotal());
        }

    }
    private static void Calculate()
    {
        Total = 0;
        System.out.println();
        System.out.println("Calculating..");

        for(int x = 0; x < items.length; x++)
        {
            Total = Total + (items[x].getPrice() * items[x].getAmount());
        }
        System.out.println("Total :" + Total );
    }



}

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
    public Double getTotal(){Total = Price * Amount; return Total;}
}


