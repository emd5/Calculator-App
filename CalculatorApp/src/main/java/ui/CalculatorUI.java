/* Liz Mahoney
 * 9/19/2015
 *  CalculatorUI.java
 *  This file contains the CalculatorUI class which builds
 *  the calculator
 */
package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

/**
 * This class builds the calculator interface
 */
public class CalculatorUI extends Application {

    //global variables
    public static final int HORIZONTAL_GRID_SPACE = 5;
    public static final int VERTICAL_GRID_SPACE = 5;
    public static final int WINDOW_MAX_WIDTH = 250;
    public static final int WINDOW_MAX_HEIGHT = 250;
    public static final int BUTTON_WIDTH = 50; //was 50
    public static final int BUTTON_HEIGHT = 50; //was 50
    public static final int COL_WIDTH_CONSTRAINTS = 50;
    public static final int ENTER_WIDTH = 200;
    public static final int TEXT_WIDTH_DISPLAY = 210;
    public static final int TEXT_HEIGHT_DISPLAY = 45;
    public static final int WINDOW_PADDING = 20;
    public static final int ROW_GRID = 4;
    public static final int COLUMN_GRID = 4;


    /**
     * This method sets up the calculator
     *
     * @param stage a window that represents the calculator
     */
    @Override
    public void start(Stage stage){

        //sets and shows title and calculator features.
        stage.setTitle ("Calculator");
        stage.setScene (assemble());
        stage.setResizable (false);
        stage.show ();

    }

    /**
     * This method assembles the layout of the calculator
     *
     * @return the calculator display
     */
    private Scene assemble(){

        //assemble controls in a grid
        GridPane gridPane = new GridPane ();

        //set space between elements
        gridPane.setHgap (HORIZONTAL_GRID_SPACE);
        gridPane.setVgap (VERTICAL_GRID_SPACE);
        gridPane.setPadding (new Insets (WINDOW_PADDING));


        gridPane.getColumnConstraints ().addAll (
                new ColumnConstraints (COL_WIDTH_CONSTRAINTS),
                new ColumnConstraints (COL_WIDTH_CONSTRAINTS),
                new ColumnConstraints (COL_WIDTH_CONSTRAINTS),
                new ColumnConstraints (COL_WIDTH_CONSTRAINTS));


        String[] buttonLabels = {"7","8", "9","+", "4", "5","6","-",
                "1", "2","3","*", "0", "Enter","/"};

        Button[] buttons = new Button[buttonLabels.length];

        //create a new button each button has its own text
        //create buttons with label
        for(int i=0; i<buttonLabels.length; i++){
            buttons[i] = new Button (buttonLabels[i]);
            if(buttonLabels[i].equals ("Enter")){
                buttons[i] = new Button (buttonLabels[i]);
                buttons[i].setPrefSize (ENTER_WIDTH, BUTTON_HEIGHT);
            }
            else {
                buttons[i].setPrefSize (BUTTON_WIDTH, BUTTON_HEIGHT);
            }
        }



        //add buttons to the grid
        for (int j=0; j<buttonLabels.length; j++){

            if(buttonLabels[j].equals ("Enter")){

                gridPane.add(buttons[j], j % COLUMN_GRID,j/ ROW_GRID +1, 2, 1);

            }
            else if(buttonLabels[j].equals ("/")){
                gridPane.add (buttons[j], j % COLUMN_GRID+1, j/ROW_GRID + 1);
            }
            else {
                //creating the grid
                gridPane.add (buttons[j], j % COLUMN_GRID, j / ROW_GRID + 1);
            }


        }

        //create display box
        HBox hBox = new HBox ();
        Label label = new Label ("43770");

        label.setPrefSize (225,50);
        label.setAlignment (Pos.CENTER_RIGHT);
        hBox.setAlignment (Pos.CENTER_RIGHT);


        hBox.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        hBox.setPrefSize (TEXT_WIDTH_DISPLAY,TEXT_HEIGHT_DISPLAY);
        hBox.getChildren ().add(label);

        gridPane.add (hBox ,0 , 0, 4, 1);

        //apply css to calculator
        try {
           gridPane.getStylesheets().add( new File ("css/calculator.css")
                   .toURI ().toURL ().toString ());

        }
        catch (MalformedURLException e) {
           e.printStackTrace ();
        }

        return new Scene (gridPane, WINDOW_MAX_WIDTH, WINDOW_MAX_HEIGHT);

    }

}
