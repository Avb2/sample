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
import java.util.function.Consumer;
import javafx.scene.control.TextField;





public class EditFlightPane extends Component{
    private UserState userState;
    private Stage stage;
    private Consumer<String> consumer;

    public EditFlightPane(UserState userState, Stage stage, Consumer<String> consumer){
        this.userState = userState;
        this.stage = stage;
        this.consumer = consumer;
    }


    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();

        Button backBtn = (Button) (new BackToEditFlightsBtn(userState, stage).createComponent());
        pane.add(backBtn, 0, 0);

        // Flight Number field     
        GridPane flightNumberField = InputField.inputField("Flight Number");
        pane.add(flightNumberField, 0, 1);
        
      
        Button enterBtn = EnterBtn.EnterButton(e -> {
            TextField textField = (TextField) (flightNumberField.getChildren().get(1));
            this.consumer.accept(textField.getText());
        });
        pane.add(enterBtn, 0, 2);
    
        return pane;
    }

    public Node createComponent(GridPane newPane){
        GridPane pane = new GridPane();

        Button backBtn = (Button) (new BackToEditFlightsBtn(userState, stage).createComponent());
        pane.add(backBtn, 0, 0);

        // Flight Number field     
        GridPane flightNumberField = InputField.inputField("Flight Number");
        pane.add(flightNumberField, 0, 1);
        
      
        Button enterBtn = EnterBtn.EnterButton(e -> {
            TextField textField = (TextField) (flightNumberField.getChildren().get(1));
            this.consumer.accept(textField.getText());
            pane.getChildren().clear();
            pane.add(newPane, 0, 1);
        });
        pane.add(enterBtn, 0, 2);
    
        return pane;
    }


    
}



