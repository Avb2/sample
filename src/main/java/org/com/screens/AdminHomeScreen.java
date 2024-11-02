package org.com.screens;

import javafx.stage.Stage;
import org.com.bases.Screen;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import org.com.state.UserState;
import javafx.geometry.Pos;
import org.com.constants.Sizes;
import org.com.components.navbars.AuthenticatedNavBar;
import org.com.components.navbars.AdminNavBar;


public class AdminHomeScreen extends Screen {
    private final UserState userState;

    public AdminHomeScreen(UserState userState) {
        this.userState = userState;
    }

    @Override
    public Scene createScreen(Stage stage) {
        // Create main pane
        GridPane pane = new GridPane();
        pane.add(new AdminNavBar(stage, userState).createComponent(), 0, 0);

        return new Scene(pane, 450, 400);
    }
}
