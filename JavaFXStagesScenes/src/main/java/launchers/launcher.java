package launchers;

import javafx.application.Application;
import stages_scenes.HelloWorld;
import stages_scenes.Storybook;

public class launcher {

    public static void main(String[] args) {


        //starts our hello world gui!
        Application.launch(HelloWorld.class,args);

        Application.launch(Storybook.class ,args);


    }
}
