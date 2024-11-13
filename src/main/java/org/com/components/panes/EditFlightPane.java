package org.com.components.panes;

import javafx.scene.layout.GridPane;
import org.com.components.buttons.EnterBtn;
import org.com.components.InputField;
import org.com.bases.Component;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.com.state.UserState;
import org.com.functionality.navigation.PushEditFlight;
import org.com.components.buttons.BackToEditFlightsBtn;
import java.util.function.Consumer;
import javafx.scene.control.TextField;
import org.com.functionality.interfaces.ModifyFlightsInterface;
import java.sql.Connection;




public class EditFlightPane extends Component{
    private Connection connection;
    private UserState userState;
    private Stage stage;
    public ModifyFlightsInterface modifyFlightInterface;

    public EditFlightPane(Connection connection, UserState userState, Stage stage, ModifyFlightsInterface modifyFlightInterface){
        this.connection = connection;
        this.userState = userState;
        this.stage = stage;
        this.modifyFlightInterface = modifyFlightInterface;
    }


    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();

        Button backBtn = (Button) (new BackToEditFlightsBtn(this.connection, this.userState, this.stage).createComponent());
        pane.add(backBtn, 0, 0);

        // Flight Number field     
        GridPane flightNumberField = InputField.inputField("Flight Number");
        pane.add(flightNumberField, 0, 1);
        
      
        Button enterBtn = EnterBtn.EnterButton(e -> {
            TextField textField = (TextField) (flightNumberField.getChildren().get(1));
            this.modifyFlightInterface.onClick(pane, flightNumberField);
        });
        pane.add(enterBtn, 0, 4);
    
        return pane;
    }

    public Node createComponent(GridPane newPane){
        GridPane pane = new GridPane();

        Button backBtn = (Button) (new BackToEditFlightsBtn(this.connection, this.userState, this.stage).createComponent());
        pane.add(backBtn, 0, 0);

        // Flight Number field     
        GridPane flightNumberField = InputField.inputField("Flight Number");
        pane.add(flightNumberField, 0, 1);
        


        Button enterBtn = EnterBtn.EnterButton(
            e -> this.modifyFlightInterface.onClick(pane, flightNumberField)
        );
        pane.add(enterBtn, 0, 4);
    
        return pane;
    }


    
}



