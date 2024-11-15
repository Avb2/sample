package org.com.components;

import org.com.screens.SplashScreen;
import org.com.state.UserState;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.Connection;
import javafx.scene.layout.GridPane;


public class LogOutBtn {
    public static Button LogOutButton(Connection connection, Stage stage, UserState userState, GridPane pane){
        Button button = new Button("Logout");
        button.setOnAction(e -> {
            userState.setName("", "");
            userState.setLoggedInState();
            new SplashScreen(connection).createPane(pane, stage);
        });

        return button;
    }
}
