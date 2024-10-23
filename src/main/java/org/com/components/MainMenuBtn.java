package org.com.components;

import org.com.screens.SplashScreen;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuBtn {
    public static Button MainMenuBtn(Stage stage){
        Button returnMain = new Button("Main Menu");
        returnMain.setOnAction(e -> stage.setScene(new SplashScreen().createScreen(stage)));
        return returnMain;
    }
}
