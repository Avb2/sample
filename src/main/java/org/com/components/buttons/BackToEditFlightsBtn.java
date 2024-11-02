package org.com.components.buttons;

import org.com.bases.Component;
import org.com.state.UserState;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.com.functionality.navigation.PushEditFlight;
import javafx.scene.Node;


public class BackToEditFlightsBtn extends Component {
    private UserState userState;
    private Stage stage;

    public BackToEditFlightsBtn(UserState userState, Stage stage){
        this.userState = userState;
         this.stage = stage;
    }

    @Override
    public Node createComponent(){
        Button backBtn = new Button("<-");
        backBtn.setOnAction(e -> {
            new PushEditFlight().push(this.userState, this.stage);
        });

        return backBtn;
    }
}