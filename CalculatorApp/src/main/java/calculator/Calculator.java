/* Liz Mahoney
 * 10/9/2017
 *  Calculator.java
 *  that contains all state information and
 *  event handlers for interacting with the calculator.
 */

package calculator;

import ui.CalculatorUI;

import java.text.DecimalFormat;



/**
 * This class contains all state information and event handlers
 * for interacting with the calculator.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class Calculator {

    private String input = "";


    private static String displayValue = "";
    private static int storeValue1;
    private static int storeValue2;
    private static String saveOperator;

    private static String storeOperator;



    public static String storeInputPressed(String input) {

        if(input.equals ("+") || input.equals ("-")
                ||input.equals ("*") || input.equals ("/")){

            operatorPressed (input);
            firstValue (displayValue);
            resetDisplay ();
        }

        else if(input.equals ("\u221A")){
            firstValue (displayValue);
            //saveValue = String.valueOf (Math.sqrt (Double.valueOf (saveValue)));
            firstValue (displayValue);

        }

        else if (input.equals ("Enter")) {
            secondValue (displayValue);
            enterPressed ();

        }

        else if (input.equals ("CE")){
            resetDisplay ();
        }

        else {
            for (int i=0; i< input.length() ; i++) {

                displayValue += input;

            }
        }

        return displayValue;

    }

    private static void operatorPressed(String input){

         saveOperator = input;
    }

    private static void firstValue(String storeValue){

        int tempValue = Integer.valueOf (storeValue);
        storeValue1= tempValue;

    }

    private static void secondValue(String storeValue){

        int tempValue = Integer.valueOf (storeValue);
        storeValue2= tempValue;

    }

    private static void enterPressed(){

        int saveAnswer=0;

        if(saveOperator.equals ("+")){
            saveAnswer = storeValue1 + storeValue2;
        }
        else if(saveOperator.equals ("-")){
            saveAnswer = storeValue1 - storeValue2;
        }
        else if(saveOperator.equals ("*")){
            saveAnswer = storeValue1 * storeValue2;
        }
        else if(saveOperator.equals ("/")){

            if (storeValue2 == 0 ){
                   displayValue= "undef"; //FIX THIS
            }
            else {
                saveAnswer = storeValue1 / storeValue2;
            }
        }

        displayValue = String.valueOf (saveAnswer);

    }


    private static void squareRoot(String input){

        Double convertInput = Double.valueOf (input);
        Double saveTemp = Math.sqrt (convertInput);
        DecimalFormat saveFormat = new DecimalFormat (String.valueOf (saveTemp));

    }




    private static String resetDisplay(){

        return displayValue= "";

    }





}
