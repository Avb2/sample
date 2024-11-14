package org.com.screens;

import org.com.bases.Screen;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import org.com.components.navbars.AdminNavBar;
import org.com.components.InputField;
import org.com.state.UserState;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.com.functionality.interfaces.ModifyFlightsInterface;
import javafx.geometry.Pos;
import org.com.components.panes.CustomFlightPane;
import org.com.components.panes.EditFlightPane;
import org.com.functionality.modify_flights.DeleteFlight;
import org.com.db.FlightDatabase;
import javafx.scene.control.TextField;

import org.com.functionality.interfaces.CreateFlightsInterface;
import javafx.scene.control.Label;
import javafx.util.Duration;
import java.sql.SQLException;
import org.com.animations.Animate;
import java.sql.Connection;

public class EditFlightScreen extends Screen{
    private UserState userState;
    private Connection connection;

    public EditFlightScreen(Connection connection, UserState userState){
        this.connection = connection;
        this.userState = userState;
    }


    @Override
    public Scene createScreen(Stage stage) {
        GridPane pane = new GridPane();
        pane.add(new AdminNavBar(stage, this.userState, this.connection).createComponent(), 0, 0);
        pane.setAlignment(Pos.TOP_CENTER);


        // Load pane for action
        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> {
            pane.getChildren().clear();

            CreateFlightsInterface createFlightsInterface = (gPane, flight) -> {

                try {
                      // Add data to db 
                    new FlightDatabase(this.connection).addFlight(flight);

                    // Added label
                    Label addedLabel = new Label("Succesffully added");
                    gPane.add(addedLabel, 0 , 8);
                    new Animate(addedLabel).fadeOut(3);
                } catch (SQLException se) {
                    se.printStackTrace();
                }
              

            };

            pane.add(new CustomFlightPane(this.connection, this.userState, stage, createFlightsInterface).createComponent(), 0, 1);
        });
        pane.add(addBtn, 0, 1);


        // Load pane for edit 
        Button editBtn = new Button("Edit");
        editBtn.setOnAction(e -> {
            pane.getChildren().clear();
            ModifyFlightsInterface editFlightInterface = (gPane, tField) -> {
                System.out.println("Modify");
            };
            pane.add(new EditFlightPane(this.connection, this.userState, stage, editFlightInterface).createComponent(), 0, 1);
        });
        pane.add(editBtn, 0, 2);


        // Load pane for delete actions
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> {
            pane.getChildren().clear();
            ModifyFlightsInterface deleteFlightInterface = (gPane, tField) -> {
                TextField textField = (TextField) (tField.getChildren().get(1));
                String text = textField.getText();
                FlightDatabase flightDb = new FlightDatabase(this.connection);

                try {

                    flightDb.deleteFlight(text);
                       // Success label
                    String successText = "Successfully deleted Flight ".concat(text);
                    Label successLabel = new Label(successText);
                    gPane.add(successLabel, 0, 3);

                    //
                   new Animate(successLabel).fadeOut(3);
                
                } catch (SQLException error) {
                    String failText = "Failed ";
                    Label failLabel = new Label(failText);
                    gPane.add(failLabel, 0, 3);

                    //
                    new Animate(failLabel).fadeOut(3);

                   
                }
            };
            pane.add(new EditFlightPane(this.connection, userState, stage, deleteFlightInterface).createComponent(), 0, 1);
        });
        pane.add(deleteBtn, 0, 3);


        return new Scene(pane, 450, 500);
    };
}

