/*
 *  Liz Mahoney
 *  10/9/2017
 *  Calculator.java
 *  that contains all state information and
 *  event handlers for interacting with the calculator.
 */

package calculator;

import java.text.DecimalFormat;

import static java.lang.Double.valueOf;


/**
 * This class contains all state information and event handlers
 * for interacting with the calculator.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class Calculator {


    private static double storeValue1=0;
    private static double storeValue2=0;

    private static final String ADD_BUTTON = "+";
    private static final String SUBTRACT_BUTTON = "-";
    private static final String MULTIPLY_BUTTON = "*";
    private static final String DIVIDE_BUTTON = "/";
    private static final String ENTER_BUTTON = "Enter";
    private static final String SQUARED = "x\u00B2";
    private static final String RESET_BUTTON = "CE";
    private static final String CUBEROOT_BUTTON = "\u221B";
    private static final String SIN_BUTTON ="sin(x)";
    private static final String COS_BUTTON ="cos(x)";
    private static final String TAN_BUTTON ="tan(x)";
    private static final String SQUAREROOT_BUTTON = "\u221A";
    private static final String DECIMAL_FORMAT= "####.###";
    private static String displayValue = "";
    private static String saveOperator;

    /**
     * This method excepts an input from the UI and separates
     * operands and operators pressed
     *
     * @param input the button pressed on the UI
     *
     * @return displayValue displays the button pressed to
     * Calculator UI label.
     */
    public static String buttonPressed(String input) {

        //operators are pressed
        if(input.equals (ADD_BUTTON) || input.equals (SUBTRACT_BUTTON)
                ||input.equals (MULTIPLY_BUTTON) || input.equals (DIVIDE_BUTTON)){

            operatorPressed (input);
            storeFirstValue (displayValue);
            resetDisplay ();
        }

        //enter button is pressed
        else if (input.equals (ENTER_BUTTON)) {

            storeSecondValue (displayValue);
            enterPressed ();

        }

        //CE button is pressed
        else if (input.equals (RESET_BUTTON)){

            resetDisplay ();
        }

        else if (input.equals (SIN_BUTTON)){

            sinPressed (displayValue);
        }

        else if (input.equals (COS_BUTTON)){

            cosPressed (displayValue);
        }

        else if (input.equals (TAN_BUTTON)){

            tanPressed (displayValue);
        }

        //squared button is pressed
        else if(input.equals (SQUARED)){

            squaredPressed (displayValue);
        }

        //square root button is pressed
        else if(input.equals (SQUAREROOT_BUTTON)){

            squareRootPressed (displayValue);
        }

        //cubed root is pressed
        else if (input.equals(CUBEROOT_BUTTON)){
            cubedPressed (displayValue);
        }

         //values from 0-9 pressed and concatenated
        else {
            for (int i=0; i< input.length() ; i++) {

                displayValue += input;

            }
        }

        return displayValue;
    }

    /**
     * This method performs calculations after enter button is
     * pressed, execute according to the stored operator.
     */
    private static void enterPressed(){

        double saveAnswer=0;

        if(saveOperator.equals (ADD_BUTTON)){
            saveAnswer = storeValue1 + storeValue2;
        }
        else if(saveOperator.equals (SUBTRACT_BUTTON)){
            saveAnswer = storeValue1 - storeValue2;
        }
        else if(saveOperator.equals (MULTIPLY_BUTTON)){
            saveAnswer = storeValue1 * storeValue2;
        }
        else if (saveOperator.equals (DIVIDE_BUTTON)){
            saveAnswer = storeValue1 / storeValue2;
        }

        convertDecimalToString (saveAnswer);
    }


    /**
     * This method formats value to two decimal places, then converts to String
     * to display on UI.
     *
     * @param saveAnswer the answer in decimal form
     */
    private static String convertDecimalToString(Double saveAnswer){

        DecimalFormat df = new DecimalFormat (DECIMAL_FORMAT);

        if(storeValue2 == 0.0){

            return displayValue = "0";
        }

        return displayValue = String.valueOf (df.format (saveAnswer));

    }

    /**
     * A set method that stores the operator
     *
     * @param storeOperator stores the operator
     *
     */
    private static void operatorPressed(String storeOperator){

         saveOperator = storeOperator;
    }

    /**
     * A set method that converts a value to double and saves the
     * first operand.
     *
     * @param storeValue a string of the first input value
     */
    private static void storeFirstValue(String storeValue) {

         storeValue1 = Double.valueOf (storeValue);

    }

    /**
     * A set method that converts a value to  double and saves the
     * second operand.
     *
     * @param storeValue
     */
    private static void storeSecondValue(String storeValue){

        storeValue2 = Double.valueOf (storeValue);
        System.out.println (storeValue2);
    }

    /**
     * This method resets the display on the UI
     *
     * @return an empty string
     */
    private static String resetDisplay(){

        return displayValue = "";

    }


    /**
     * This method performs calculations when square root button
     * is pressed
     *
     * @param input the square root button pressed on the UI
     */
    private static void squareRootPressed(String input) {

        Double tempValue = valueOf (input);

        convertDecimalToString (Math.sqrt (tempValue));
    }

    /**
     * This method performs calculations when cubed button
     * is pressed
     *
     * @param input the cubed button pressed on the UI
     */
    private static void cubedPressed(String input) {

        Double tempValue = valueOf (input);

        convertDecimalToString (Math.cbrt (tempValue));
    }

    /**
     * This method performs calculations when squared button
     * is pressed
     *
     * @param input the squared button pressed on the UI
     */
    private static void squaredPressed(String input) {

        Double tempValue = valueOf (input);

        convertDecimalToString (Math.pow (tempValue,2));
    }

    /**
     * This method performs calculations when sin button
     * is pressed
     *
     * @param input the sin button pressed on the UI
     */
    private static void sinPressed(String input) {

        Double tempValue = valueOf (input);
        System.out.println (tempValue);
        convertDecimalToString (Math.sin (tempValue));
    }

    /**
     * This method performs calculations when cos button
     * is pressed
     *
     * @param input the cos button pressed on the UI
     */
    private static void cosPressed(String input) {

        Double tempValue = valueOf (input);

        convertDecimalToString (Math.cos (tempValue));
    }

    /**
     * This method performs calculations when tan button
     * is pressed
     *
     * @param input the tan button pressed on the UI
     */
    private static void tanPressed(String input) {

        Double tempValue = valueOf (input);

        convertDecimalToString (Math.tan (tempValue));
    }





}
