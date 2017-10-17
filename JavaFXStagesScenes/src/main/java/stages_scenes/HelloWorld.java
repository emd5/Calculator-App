package stages_scenes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloWorld extends Application {

    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 300;
    private static final int PANEL_PADDING = 10;
    private static final int TITLE_FONT_SIZE = 24;

    @Override
    public void start(Stage stage) {
        stage.setTitle ("Hello world this is Java FX!");
        stage.setScene (getScene ());
        stage.show ();
    }

    //assembling one view on the UI
    //Java uses FXML as a markup language to define the UI
    private Scene getScene(){

        //create new vbox-> (vertical box)
        VBox vBox = new VBox ();
        Text text = new Text ("Hello World");
       //ObservableList<Node> children = vBox.getChildren ();
        vBox.getChildren ().add (text); //this loses control breaks encapsulation.//returns a list , uses observable pattern

        //center the vBox and add some padding
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding ( new Insets (PANEL_PADDING));

        //set a new font for our text element (factory methods) creating objects for us.. constructors Benefits can add different names
        text.setFont(Font.font("impact", FontWeight.BOLD, TITLE_FONT_SIZE));



        //creates the outer view box
        return new Scene(vBox, WIN_WIDTH, WIN_HEIGHT);

    }

    //layout managers, vbox






















}
