package org.com.screens;


import org.com.bases.Screen;
import org.com.components.AuthenticatedNavBar;
import org.com.state.UserState;
import org.com.db.Connect;

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


        Label titleLabel = new Label("Manage flights");
        pane.add(titleLabel, 0 ,1);

        // Get all flights



        // Display flights as flight cards wrapped in a grid pane with add/remove buttons

        return new Scene(pane, 450, 600);
        
    }   
}
