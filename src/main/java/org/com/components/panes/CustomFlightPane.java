package org.com.components.panes;

import javafx.scene.layout.GridPane;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.bases.Component;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.com.state.UserState;
import org.com.functionality.navigation.PushEditFlight;
import org.com.components.buttons.BackToEditFlightsBtn;




public class CustomFlightPane extends Component{
    private UserState userState;
    private Stage stage;
    Runnable onAction;

    public CustomFlightPane(UserState userState, Stage stage, Runnable onAction){
        this.userState = userState;
        this.stage = stage;
        this.onAction = onAction;
    }


    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();

        Button backBtn = (Button) (new BackToEditFlightsBtn(userState, stage).createComponent());
        pane.add(backBtn, 0, 0);

        // destination     
        GridPane destinationField = InputField.inputField("Destination");
        pane.add(destinationField, 0, 1);
        //        departure location         
        GridPane departureField = InputField.inputField("Departure Location");
        pane.add(departureField, 0, 2);
        // capacity 
        GridPane capacityField = InputField.inputField("Capacity");
        pane.add(capacityField, 0, 3);
        //          takeoff       
        GridPane takeoffField = InputField.inputField("Takeoff Time");  
        pane.add(takeoffField, 0, 4);  
        //          landing
        GridPane landingField = InputField.inputField("Landing time");
        pane.add(landingField, 0, 5);          
        //    date   
        GridPane dateField = InputField.inputField("Flight Date"); 
        pane.add(dateField, 0, 6);
        //  status  
        GridPane statusField = InputField.inputField("Current Status");
        pane.add(statusField, 0, 7);

        EnterBtn.EnterButton(e -> {this.onAction.run();});
    
    return pane;
    }
}
