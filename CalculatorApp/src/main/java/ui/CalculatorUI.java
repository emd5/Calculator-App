package ui;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;




public class CalculatorUI extends Application {

    @Override
    public void start(Stage stage){

        stage.setTitle ("Fancy Calculator");
        stage.setScene (assemble());
        stage.setResizable (false);
        stage.show ();

    }

    private Scene assemble(){

        //assemble controls in a grid
        GridPane gridPane = new GridPane ();

        //set space between elements
        gridPane.setHgap (5);
        gridPane.setVgap (5);
        gridPane.setPadding (new Insets (20));


        gridPane.getColumnConstraints ().addAll (
                new ColumnConstraints (50),
                new ColumnConstraints (50),
                new ColumnConstraints (50),
                new ColumnConstraints (50));



        Button button1 = new Button ("1");
        button1.setPrefSize (45,45);
        gridPane.add(button1,0,3);

        Button button2 = new Button ("2");
        button2.setPrefSize (45,45);
        gridPane.add(button2,1,3);

        Button button3 = new Button ("3");
        button3.setPrefSize (45,45);
        gridPane.add(button3,2,3);

        Button button4 = new Button ("4");
        button4.setPrefSize (45,45);
        gridPane.add(button4,0,2);

        Button button5 = new Button ("5");
        button5.setPrefSize (45,45);
        gridPane.add(button5,1,2);

        Button button6 = new Button ("6");
        button6.setPrefSize (45,45);
        gridPane.add(button6,2,2);

        Button button7 = new Button ("7");
        button7.setPrefSize (45,45);
        gridPane.add(button7,0,1);

        Button button8 = new Button ("8");
        button8.setPrefSize (45,45);
        gridPane.add(button8,1 ,1);

        Button button9 = new Button ("9");
        button9.setPrefSize (45,45);
        gridPane.add(button9,2,1);

        Button button0 = new Button ("0");
        button0.setPrefSize (45,45);
        gridPane.add(button0,0,4);

        Button enter = new Button ("Enter");
        enter.setPrefSize (100,45);
        gridPane.add(enter,1,4, 2, 1 );

        Button addButton = new Button ("+");
        addButton.setPrefSize (45,45);
        gridPane.add(addButton,3,1);

        Button minusButton = new Button ("-");
        minusButton.setPrefSize (45,45);
        gridPane.add(minusButton,3,2);

        Button multiplyButton = new Button ("*");
        multiplyButton.setPrefSize (45,45);
        gridPane.add(multiplyButton,3,3);

        Button divideButton = new Button ("/");
        divideButton.setPrefSize (45,45);
        gridPane.add(divideButton,3,4);

        HBox hBox = new HBox ();
        Label label = new Label ();
        TextField textDisplay = new TextField ();
        textDisplay.setAlignment (Pos.CENTER_RIGHT);
        textDisplay.setPrefSize (210, 45);


        hBox.getChildren ().addAll(label,textDisplay);




        gridPane.add (hBox ,0 , 0, 400, 1);

        return new Scene (gridPane, 250,250);
    }

}
