/* Liz Mahoney
 * 10/19/2017
 *  CalculatorUI.java
 *  This file contains the CalculatorUI class which builds
 *  the calculator
 *
 */

package ui;

import calculator.Calculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class builds the calculator interface
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class CalculatorUI extends Application {

    //global variables
    public static final int HORIZONTAL_GRID_SPACE = 5;
    public static final int VERTICAL_GRID_SPACE = 5;
    public static final int WINDOW_MAX_WIDTH = 250;
    public static final int WINDOW_MAX_HEIGHT = 350;
    public static final int BUTTON_WIDTH = 50;
    public static final int BUTTON_HEIGHT = 50;
    public static final int ENTER_WIDTH = 200;
    public static final int HBOX_WIDTH_DISPLAY = 210;
    public static final int HBOX_HEIGHT_DISPLAY = 50;
    public static final int WINDOW_PADDING = 20;
    public static final int MAX_ROW_GRID = 4;
    public static final int MAX_COLUMN_GRID = 4;
    public static final int LABEL_WIDTH = 225;
    public static final int LABEL_HEIGHT = 50;
    public static final String SQUARED_BUTTON = "x\u00B2";
    public static final String SQUAREROOT_BUTTON = "\u221A";
    public static final String CUBED_BUTTON= "\u221B";

    public static String[] buttonLabels =
            {"sin(x)","cos(x)","tan(x)","CE",
            SQUARED_BUTTON,CUBED_BUTTON,SQUAREROOT_BUTTON,
             "/","7","8", "9","+", "4", "5","6","-",
            "1", "2","3","*", "0", "Enter"};

    public static Button[] buttons;
    public static Label label;
    public static GridPane gridPane;

    /**
     * This method sets up the calculator
     *
     * @param stage a window that represents the calculator
     */
    @Override
    public void start(Stage stage){

        // window and calculator features.
        stage.setTitle ("Calculator");
        stage.setScene (assemble());
        stage.setResizable (false);
        stage.show ();

    }

    /**
     * This method assembles the calculator layout
     * with buttons, text display
     *
     * @return the calculator display
     */
    private Scene assemble(){

        layout ();
        createButtons ();
        addButtons ();
        eventHandling ();
        return new Scene (gridPane, WINDOW_MAX_WIDTH, WINDOW_MAX_HEIGHT);

    }

    /**
     * This static method creates the buttons
     */
    private static void createButtons(){
        buttons = new Button[buttonLabels.length];

        //create each button with respective button labels
        for(int i=0; i<buttonLabels.length; i++){


            buttons[i] = new Button (buttonLabels[i]);

            if(buttonLabels[i].equals ("Enter")){

                buttons[i].setPrefSize (ENTER_WIDTH, BUTTON_HEIGHT);

            }
            else {

                buttons[i].setPrefSize (BUTTON_WIDTH, BUTTON_HEIGHT);
            }
        }
    }

    /**
     * This static method add buttons to the gridpane
     */
    private static void addButtons(){
        //add buttons to the grid
        for (int j=0; j<buttonLabels.length; j++){


            if(buttonLabels[j].equals ("Enter")){
                gridPane.add(buttons[j], j % MAX_COLUMN_GRID + 1,
                        j / MAX_ROW_GRID + 2,2,1);
            }
            else if(buttonLabels[j].equals ("0")){
                gridPane.add(buttons[j], j % MAX_COLUMN_GRID + 1,
                        j / MAX_ROW_GRID + 2);
            }

            //add buttons to the grid
            else {
                gridPane.add (buttons[j], j % MAX_COLUMN_GRID ,
                        j / MAX_ROW_GRID+1 );
            }

        }
    }

    /**
     *This static method handles layout of the calculator
     */
    private static void layout(){
        //assemble controls in a grid
        gridPane = new GridPane ();

        //set space between elements
        gridPane.setHgap (HORIZONTAL_GRID_SPACE);
        gridPane.setVgap (VERTICAL_GRID_SPACE);
        gridPane.setPadding (new Insets (WINDOW_PADDING));

        //create display box, aligns right
        HBox hBox = new HBox ();
        hBox.setAlignment (Pos.CENTER_RIGHT);

        //display hBox border, sets hbox height & width
        hBox.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        hBox.setPrefSize (HBOX_WIDTH_DISPLAY, HBOX_HEIGHT_DISPLAY);

        //create label
        label = new Label ();

        //set labels size, alignment
        label.setPrefSize (LABEL_WIDTH, LABEL_HEIGHT);
        label.setAlignment (Pos.CENTER_RIGHT);

        hBox.getChildren ().add(label);

        gridPane.add (hBox ,0 , 0, MAX_COLUMN_GRID, 1);

        //apply css to calculator
        gridPane.getStylesheets ().add ("css/calculator.css");
    }

    /**
     * This static method handles the event handling when a button is pressed
     */
    private static void eventHandling(){

        //create event handling for each button
        for(int i=0 ; i< buttonLabels.length ; i++){

            final String buttonOperations = buttonLabels[i];

            buttons[i].setOnAction (new EventHandler<ActionEvent> () {
                public void handle(ActionEvent event) {

                    label.setText (Calculator.buttonPressed (buttonOperations));
                }
            });
        }
    }

}
