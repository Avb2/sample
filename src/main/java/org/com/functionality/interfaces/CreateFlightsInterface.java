package org.com.functionality.interfaces;

import org.com.models.Flight;
import javafx.scene.layout.GridPane;


@FunctionalInterface
public interface CreateFlightsInterface {
    void onClick(GridPane pane, Flight flight);
    
}
