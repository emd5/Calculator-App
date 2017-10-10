/* Liz Mahoney
 * 10/9/2017
 *  Calculator.java
 *  that contains all state information and
 *  event handlers for interacting with the calculator.
 */

package calculator;


import java.util.EventListener;
import ui.CalculatorUI;

/**
 * This class contains all state information and event handlers
 * for interacting with the calculator.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class Calculator implements EventListener {


    private static String[] buttonLabels = CalculatorUI.buttonLabels;



    public static void main(String[] args) {
        for (int i=0; i< buttonLabels.length; i++){
            System.out.println (buttonLabels[i]);
        }
    }







}
