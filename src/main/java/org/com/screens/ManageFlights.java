package org.com.screens;


import org.com.bases.Screen;
import org.com.components.AuthenticatedNavBar;
import org.com.state.UserState;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Pos;


public class ManageFlights extends Screen{
    private UserState userState;

    public ManageFlights(UserState userState){
        this.userState = userState;
    }

    @Override
    public Scene createScreen(Stage stage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.add(new AuthenticatedNavBar(stage, this.userState).createComponent(), 0, 0);


        Label label = new Label("Manage flights");

        return new Scene(pane, 300, 300);
        
    }   
}
