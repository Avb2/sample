package org.com.components.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;



public class EnterBtn {
    public static Button EnterButton(EventHandler<ActionEvent> event){
        Button button = new Button("Enter");
        button.getStyleClass().add("button-1");
        button.setPrefSize(120,30);
        button.setOnAction(event);

        return button;
    }
}
