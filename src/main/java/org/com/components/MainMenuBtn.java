package org.com.components;

import org.com.screens.HomeScreen;
import org.com.screens.SplashScreen;
import org.com.state.UserState;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuBtn {
    public static Button mainMenuButton(Stage stage){
        Button returnMain = new Button("Main Menu");
        returnMain.setOnAction(e -> stage.setScene(new SplashScreen().createScreen(stage)));
        return returnMain;
    }

    public static Button mainMenuButton(Stage stage, UserState userState){
        Button returnMain = new Button("Main Menu");
        returnMain.setOnAction(e -> {
            if (userState.getLoggedInState()){
                stage.setScene(new HomeScreen(userState).createScreen(stage));
            } else {
                stage.setScene(new SplashScreen().createScreen(stage));
            }
            
        });
        return returnMain;
    }
}
