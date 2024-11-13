package org.com.components.buttons;

import org.com.bases.Component;
import org.com.screens.ManageFlights;
import org.com.state.UserState;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.sql.Connection;


public class ManageFlightsButton extends Component{
    private Connection connection;
    private final Stage stage;
    private UserState userState;

    public ManageFlightsButton(Connection connection, Stage stage, UserState userState){
        this.connection = connection;
        this.stage = stage;
        this.userState = userState;
    }

    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();

        Button button = new Button("Manage Flights");
        button.setOnAction(e -> {
            ManageFlights screen = new ManageFlights(this.connection, this.userState);
            this.stage.setScene(screen.createScreen(this.stage));
        });

        pane.add(button, 0, 0);


        return pane;
    }
}

