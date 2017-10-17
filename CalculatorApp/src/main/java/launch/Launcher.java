/* Liz Mahoney
 * 9/19/2017
 * CalculatorUI.java
 * This is the driver class to test the calculator ui with
 * the implemented methods.
 */

package launch;

import javafx.application.Application;
import ui.CalculatorUI;


/**
 * This is the driver class to test the calculator ui with
 * the implemented methods.
 *
 * @author Liz Mahoney
 * @version 1.0
 *
 */
public class Launcher {

    /**
     * This is the entry point of the program which allows to test
     * the calculator ui class.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {


        Application.launch(CalculatorUI.class, args);

    }
}
