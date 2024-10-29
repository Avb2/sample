package org.com.screens;


import java.sql.SQLException;
import java.util.Map;

import org.com.bases.Screen;
import org.com.components.AuthenticatedNavBar;
import org.com.state.UserState;
import org.com.db.FlightDatabase;
import org.com.components.FlightCard;
import org.com.db.parser.ResultSetParser;
import org.com.constants.Sizes;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

import org.com.db.BookingDatabase;
import java.sql.Connection;


public class ManageFlights extends Screen{
    private UserState userState;

    public ManageFlights(UserState userState){
        this.userState = userState;
    }

    @Override
    public Scene createScreen(Stage stage){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setVgap(Sizes.largeGap);
        pane.add(new AuthenticatedNavBar(stage, this.userState).createComponent(), 0, 0);


        Label titleLabel = new Label("Manage flights");
        pane.add(titleLabel, 0 ,1);




        // TODO move this elsewhere, business logic
        // Get all flights
        String[] keys = new String[] {"number", "destination", "status"};

    
        try{
            Map<String, String>[] flightData = new ResultSetParser(new FlightDatabase().retrieveFlights()).parseToStringDict(keys);
               

        for (int i = 0; i < flightData.length; i++){
            if (flightData[i] != null) {
            GridPane tempPane = new GridPane();
            Node flightCard = new FlightCard(flightData[i].get(keys[0]), flightData[i].get(keys[1]), flightData[i].get(keys[2])).createComponent();
            tempPane.add(flightCard, 0, 0, 1, 2);

            // Add delete Button
            Button addBtn = new Button("+");
            final int index = i;
            // Create a booking
            addBtn.setOnAction(e -> {
                Object[] vals = new Object[] {this.userState.getUid(),flightData[index].get(keys[0])};
                Object[] types = new Object[] {Integer.class, String.class};
                new BookingDatabase().createBooking(vals, types);
                });
            tempPane.add(addBtn, 1,0);
            
            // Remove a booking
            Button deleteBtn = new Button("-");
            deleteBtn.setOnAction(e -> {
                new BookingDatabase().removeBooking(this.userState.getUid(), flightData[index].get(keys[0]));
                
            });
            tempPane.add(deleteBtn, 1,1);


            pane.add(tempPane, 0, i + 3);}
        }



        } catch (SQLException e){
            e.printStackTrace();
        }
    

        // Display flights as flight cards wrapped in a grid pane with add/remove buttons

        return new Scene(pane, 450, 600);
        
    }   
}
