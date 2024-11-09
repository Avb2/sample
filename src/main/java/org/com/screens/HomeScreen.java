package org.com.screens;

import org.com.bases.Screen;
import org.com.components.navbars.AuthenticatedNavBar;
import org.com.state.UserState;
import org.com.components.FlightCard;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Node;

import java.sql.SQLException;
import org.com.constants.Sizes;

import org.com.db.BookingDatabase;

import java.util.Map;

import org.com.db.parser.ResultSetParser;
import java.sql.Connection;




public class HomeScreen extends Screen{
    private Connection connection;
    private UserState userState;
    

    public HomeScreen(Connection connection, UserState userState){
        this.connection = connection;
        this.userState = userState;
    }

    @Override
    public Scene createScreen(Stage stage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setVgap(Sizes.largeGap);
        pane.setPadding(new Insets(10,10,10,10));

        pane.add(new AuthenticatedNavBar(this.connection, stage, this.userState).createComponent(), 0, 0);

        String name = null;
        try {
            name  = userState.getName().get("first name");
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        pane.add(new Label("Welcome, " + name + "!"), 0, 1);

        GridPane subPane = new GridPane();
        subPane.setVgap(Sizes.smallGap);
        pane.add(subPane, 0, 2);

        // Refresh button to load new flights
        // Retrieve flights

        // Create flight cards

           // TODO move this elsewhere, business logic
        // Get all flights
        String[] keys = new String[] {"number", "destination", "status"};

    
        try{
            Map<String, String>[] flightData = new ResultSetParser(new BookingDatabase(this.connection).retrieveBookingByUser(userState.getUid())).parseToStringDict(keys);
               

        for (int i = 0; i < flightData.length; i++){
            if (flightData[i] != null) {
                final int index = i;
                GridPane tempPane = new GridPane();
                Node flightCard = new FlightCard(flightData[i].get(keys[0]), flightData[i].get(keys[1]), flightData[i].get(keys[2])).createComponent();
                tempPane.add(flightCard, 0, 0, 1, 2);

            
                
                // Remove a booking
                Button deleteBtn = new Button("-");
                deleteBtn.setOnAction(e -> {
                    try {
                        new BookingDatabase(this.connection).removeBooking(this.userState.getUid(), Integer.parseInt(flightData[index].get(keys[0])));

                        tempPane.getChildren().remove(flightCard);
                        tempPane.getChildren().remove(deleteBtn);
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    
                });
                tempPane.add(deleteBtn, 1,0);


                pane.add(tempPane, 0, i + 2);
            }
        }



        } catch (SQLException e){
            e.printStackTrace();
        }
        
        // Pagination button to load more flights
        


      


        return new Scene(pane, 400, 600);
    }
    
}
