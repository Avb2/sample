package org.com.components.buttons;

import org.com.bases.Component;
import org.com.state.UserState;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.com.functionality.navigation.PushEditFlight;
import javafx.scene.Node;
import java.sql.Connection;


public class BackToEditFlightsBtn extends Component {
    private Connection connection;
    private UserState userState;
    private Stage stage;

    public BackToEditFlightsBtn(Connection connection, UserState userState, Stage stage){
        this.connection = connection;
        this.userState = userState;
        this.stage = stage;
    }

    @Override
    public Node createComponent(){
        Button backBtn = new Button("<-");
        backBtn.setOnAction(e -> {
            new PushEditFlight().push(this.connection, this.userState, this.stage);
        });

        return backBtn;
    }
}