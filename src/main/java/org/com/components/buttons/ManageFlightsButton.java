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
    private GridPane mainPane;

    public ManageFlightsButton(Connection connection, Stage stage, UserState userState, GridPane mainPane){
        this.connection = connection;
        this.stage = stage;
        this.userState = userState;
        this.mainPane = mainPane;
    }

    @Override
    public Node createComponent(){
        Button button = new Button("Manage Flights");
        button.setOnAction(e -> {
            new ManageFlights(this.connection, this.userState).createPane(this.mainPane, this.stage);
        
        });



        return button;
    }
}

