package org.com.components;

import org.com.bases.Component;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;



public class FlightCard extends Component{
    private String number;
    private String destination;
    private String status;

    public FlightCard(String number, String destination, String status){
        this.number = number;
        this.destination = destination;
        this.status = status;
    }

    @Override
    public Node createComponent() {
        GridPane pane = new GridPane();
        pane.setBorder(new Border(new BorderStroke(
            Color.BLACK,               
            BorderStrokeStyle.SOLID,    
            new CornerRadii(5),      
            new BorderWidths(2)))); 

        pane.setPadding(new Insets(10, 10, 10, 10));

        Label flightNumLabel = new Label(this.number);
        pane.add(flightNumLabel, 0, 0, 5, 1);

        Label flightStatus = new Label(this.status);
        pane.add(flightStatus, 6, 0);

        Label departureLocationLabel = new Label("Harstfield Jackson Intl. Airport");
        pane.add(departureLocationLabel, 0, 1);


        Label toArrowLabel = new Label("----->");
        pane.add(toArrowLabel, 2, 1);

        Label destinationLabel = 
        new Label(this.destination);
        pane.add(destinationLabel, 4, 1);

        Label timeLabel = new Label("10:00");
        pane.add(timeLabel, 2, 2);

      
        return pane;
    }
}
