package org.com.screens;


import java.sql.SQLException;
import java.util.Map;

import javax.xml.transform.Result;
import java.sql.Timestamp;
import org.com.bases.Screen;
import org.com.components.navbars.AuthenticatedNavBar;
import org.com.state.UserState;
import org.com.db.FlightDatabase;
import org.com.components.cards.FlightCard;
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
import java.sql.ResultSet;
import org.com.db.parser.ResultSetParser;


public class ManageFlights extends Screen{
    private Connection connection;
    private UserState userState;
    

    public ManageFlights(Connection connection, UserState userState){
        this.connection = connection;
        this.userState = userState;
    }

    @Override
    public Scene createScreen(Stage stage){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setVgap(Sizes.largeGap);
        pane.add(new AuthenticatedNavBar(this.connection, stage, this.userState).createComponent(), 0, 0);


        Label titleLabel = new Label("Manage flights");
        pane.add(titleLabel, 0 ,1);




        // TODO move this elsewhere, business logic
        // Get all flights
        String[] keys = new String[] {"number", "destination", "status"};

    
        try{
            Map<String, String>[] flightData = new ResultSetParser(new FlightDatabase(this.connection).retrieveFlights()).parseToStringDict(keys);
               

        for (int i = 0; i < flightData.length; i++){
            if (flightData[i] != null) {
            GridPane tempPane = new GridPane();
            Node flightCard = new FlightCard(flightData[i].get(keys[0]), flightData[i].get(keys[1]), flightData[i].get(keys[2])).createComponent();
            tempPane.add(flightCard, 0, 0, 1, 2);



            final int index = i;
            // Get the flight number of the selected flight
            int flightNumber = Integer.parseInt(flightData[index].get(keys[0]));


            

            // Add Button
            Button addBtn = new Button("+");
            // Create a booking
            addBtn.setOnAction(e -> {
                try {
                    
                    // Create Db objects
                    FlightDatabase flightDb = new FlightDatabase(this.connection);
                    BookingDatabase bookingDb = new BookingDatabase(this.connection);

                    
                    
                    // Retrieve the selected flight time by fid
                    ResultSet selectedFlight = flightDb.retrieveFlight(flightNumber);
                    ResultSetParser selectedFlightRP = new ResultSetParser(selectedFlight);
                    // Convert to an array of Maps
                    Map<String, Object>[] selectedFlightDict = selectedFlightRP.parse(new String[] {"takeoff", "landing"}, new Class<?>[] {Timestamp.class, Timestamp.class});
                    // Select the first map in the array which contains the selected flights information
                    Map<String, Object> selectedFlightData = selectedFlightDict[0];
                    // Get the takeoff and landing time from the selected flight data
                    Timestamp selectedTakeoff = (Timestamp) (selectedFlightData.get("takeoff"));
                    Timestamp selectedLanding = (Timestamp) (selectedFlightData.get("landing"));


                
                    // Retrieve current booking times
                    ResultSet bookedTimes  = bookingDb.retrieveTimes(flightNumber);
                    ResultSetParser bookedTimesRP= new ResultSetParser(bookedTimes);
                    // Convert to an array of maps
                    Map<String, Object>[] bookedTimesDict = bookedTimesRP.parse(new String[] {"takeoff", "landing"}, new Class<?>[] {Timestamp.class, Timestamp.class});
                    
                    // Default conflict value set to false
                    boolean conflict = false;

                    // If bookings for the user exist check for conflicts
                    if ( bookedTimesDict != null) {
                          // Compare booking times with time of selected flights for time conflicts 
                          for (Map<String, Object> times: bookedTimesDict) {
                            // Get the takeoff and landing time of the indexed flight booking
                            Timestamp existingTakeoff = (Timestamp) (times.get("takeoff"));
                            Timestamp existingLanding = (Timestamp) (times.get("landing"));
    
                            
                            System.out.println(selectedTakeoff);
                            System.out.println(selectedLanding);
                            System.out.println(existingLanding);
                            System.out.println(existingTakeoff);
                            
                            if ((existingTakeoff.before(selectedLanding) && selectedTakeoff.after(existingTakeoff)) || 
                            (existingTakeoff.before(selectedTakeoff) && selectedLanding.after(existingTakeoff)) || 
                            (selectedTakeoff.before(existingTakeoff) && selectedLanding.after(existingLanding))){
                                conflict = true;
                            }
                        }
    
                    }

                      
                    if (conflict == false){
                        try {
                          // Add flight if no conflicts
                            bookingDb.createBooking(this.userState.getUid(), flightNumber);   
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }
                        
                    } else {
                        System.out.println("Time Conflict!");
                    } 
               
               
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                    
               
                });
            tempPane.add(addBtn, 1,0);
            





            // Delete button
            Button deleteBtn = new Button("-");
            // remove a booking
            deleteBtn.setOnAction(e -> {
                try {
                    new BookingDatabase(this.connection).removeBooking(this.userState.getUid(), flightNumber);
                } catch (SQLException se) {
                    se.printStackTrace();
                }
              
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
