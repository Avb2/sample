package org.com.components;

import org.com.screens.SplashScreen;
import org.com.state.UserState;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogOutBtn {
    public static Button LogOutButton(Stage stage, UserState userState){
        Button button = new Button("Logout");
        button.setOnAction(e -> {
            userState.setName("", "");
            userState.setLoggedInState();
            stage.setScene(new SplashScreen().createScreen(stage));
        });

        return button;
    }
}
