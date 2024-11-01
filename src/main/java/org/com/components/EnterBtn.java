package org.com.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;



public class EnterBtn {
    public static Button EnterButton(EventHandler<ActionEvent> event){
        Button button = new Button("Enter");
        button.setPrefSize(150,30);
        button.setStyle("-fx-font-size: 15");
        button.setOnAction(event);

        return button;
    }
}
