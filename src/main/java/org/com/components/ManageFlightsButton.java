package org.com.components;

import org.com.bases.Component;
import org.com.screens.ManageFlights;
import org.com.state.UserState;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class ManageFlightsButton extends Component{
    private final Stage stage;
    private UserState userState;

    public ManageFlightsButton(Stage stage, UserState userState){
        this.stage = stage;
        this.userState = userState;
    }

    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();

        Button button = new Button("Manage Flights");
        button.setOnAction(e -> {
            ManageFlights screen = new ManageFlights(this.userState);
            this.stage.setScene(screen.createScreen(this.stage));
        });

        pane.add(button, 0, 0);


        return pane;
    }
}

