package org.com.components.buttons;

import org.com.screens.HomeScreen;
import org.com.screens.SplashScreen;
import org.com.state.UserState;
import org.com.screens.AdminHomeScreen;
import java.sql.Connection;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


public class MainMenuBtn {
    public static Button mainMenuButton(Connection connection, Stage stage, GridPane pane){
        Button returnMain = new Button("Main Menu");
        returnMain.setOnAction(e -> new SplashScreen(connection).createPane(pane, stage));
        return returnMain;
    }

    public static Button mainMenuButton(Connection connection, Stage stage, UserState userState, GridPane pane){
        Button returnMain = new Button("Main Menu");
        returnMain.setOnAction(e -> {
            if (userState.getLoggedInState() && userState.getPermissions().matches("user") ){
                new HomeScreen(connection, userState).createScreen(stage);
            } else if (userState.getLoggedInState() && userState.getPermissions().matches("admin") ){
                stage.setScene(new AdminHomeScreen(connection, userState).createScreen(stage));
            } else {
                stage.setScene(new SplashScreen(connection).createScreen(stage));
            }
        });
        return returnMain;
    }
}
