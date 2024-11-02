package org.com.components;

import org.com.bases.Component;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class EditFlightsBtn extends Component{
    private Runnable onAction;

    public EditFlightsBtn(Runnable onAction){
        this.onAction = onAction;
    }

    @Override
    public Node createComponent(){
        Button button = new Button("Edit Flights");
        button.setOnAction(e-> this.onAction.run());
        return button;
    }
}
