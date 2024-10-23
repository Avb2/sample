package org.com.screens;

import org.com.bases.Screen;
import org.com.components.AuthenticatedNavBar;
import org.com.state.UserState;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeScreen extends Screen{
    private UserState userState;

    public HomeScreen(UserState userState){
        this.userState = userState;
    }

    @Override
    public Scene createScreen(Stage stage) {
        GridPane pane = new GridPane();

        pane.add(AuthenticatedNavBar.navBar(stage, this.userState), 0, 0);



      


        return new Scene(pane, 400, 400);
    }
    
}
