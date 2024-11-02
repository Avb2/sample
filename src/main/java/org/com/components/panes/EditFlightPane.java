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




public class EditFlightPane extends Component{
    private UserState userState;
    private Stage stage;

    public EditFlightPane(UserState userState, Stage stage){
        this.userState = userState;
        this.stage = stage;
    }


    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();

        Button backBtn = (Button) (new BackToEditFlightsBtn(userState, stage).createComponent());
        pane.add(backBtn, 0, 0);

        // Flight Number field     
        GridPane flightNumberField = InputField.inputField("Flight Number");
        pane.add(flightNumberField, 0, 1);
      
        Button enterBtn = EnterBtn.EnterButton(e->{
            // Get Flight info from db

            pane.getChildren().clear();
            // Add flight info at top in its own pane 

            // Attach fields so admin can customize
            pane.add(new CustomFlightPane(userState, stage, () -> {}).createComponent(), 0, 0);
        });
        pane.add(enterBtn, 0, 2);
    
    return pane;
    }


    
}
