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
import java.sql.Connection;


public class AdminHomeScreen extends Screen {
    private Connection connection;
    private final UserState userState;

    public AdminHomeScreen(Connection connection, UserState userState) {
        this.connection = connection;
        this.userState = userState;
    }


    
    @Override
    public GridPane createPane(Stage stage){
        // Create main pane
        GridPane pane = new GridPane();
        pane.add(new AdminNavBar(stage, userState, this.connection, pane).createComponent(), 0, 0);   

        return pane;
    }
}
