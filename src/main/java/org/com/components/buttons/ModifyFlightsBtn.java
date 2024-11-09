package org.com.components.buttons;

import org.com.bases.Component;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.com.state.UserState;
import javafx.scene.Node;
import java.util.function.Consumer;
import org.com.components.panes.EditFlightPane;
import org.com.functionality.interfaces.ModifyFlightsInterface;
import java.sql.Connection;


public class ModifyFlightsBtn extends Component{
    private Connection connection;
    private UserState userState;
    private Stage stage;
    private GridPane pane;
    private String label;
    private int xPos;
    private int yPos;
    private ModifyFlightsInterface consumer;
    

    public ModifyFlightsBtn(Connection connection, UserState userState, Stage stage, String label, int xPos, int yPos, ModifyFlightsInterface consumer){
        this.connection = connection;
        this.userState = userState;
        this.stage = stage;
        this.pane = pane;
        this.label = label;
        this.xPos = xPos;
        this.yPos = yPos;
        this.consumer = consumer;
    }

    @Override 
    public Node createComponent(){
        Button btn = new Button(this.label);
        btn.setOnAction(e -> {
            this.pane.getChildren().clear();
            this.pane.add(new EditFlightPane(this.connection, this.userState, this.stage, this.consumer).createComponent(), this.xPos, this.yPos);
        });

        return btn;
    }
}
