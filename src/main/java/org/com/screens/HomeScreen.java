package org.com.screens;

import org.com.bases.Screen;
import org.com.components.AuthenticatedNavBar;
import org.com.state.UserState;
import org.com.components.FlightCard;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import org.com.constants.Sizes;



public class HomeScreen extends Screen{
    private UserState userState;

    public HomeScreen(UserState userState){
        this.userState = userState;
    }

    @Override
    public Scene createScreen(Stage stage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setVgap(Sizes.largeGap);
        pane.setPadding(new Insets(10,10,10,10));

        pane.add(new AuthenticatedNavBar(stage, this.userState).createComponent(), 0, 0);

        String name = null;
        try {
            name  = userState.getName().get("first name");
            
        } catch (NullPointerException e) {
            System.out.println("");
        }
        pane.add(new Label("Welcome, " + name + "!"), 0, 1);

        GridPane subPane = new GridPane();
        subPane.setVgap(Sizes.smallGap);
        pane.add(subPane, 0, 2);

        // Refresh button to load new flights
        // Retrieve flights

        // Create flight cards
        
        // Pagination button to load more flights
        


      


        return new Scene(pane, 400, 600);
    }
    
}
