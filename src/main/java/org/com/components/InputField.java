package org.com.components;

import org.com.constants.Sizes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class InputField {
    public static GridPane inputField(String label){
        GridPane pane = new GridPane();
        pane.setHgap(Sizes.mediumGap);

        // Username Label
        Label usernamLabel = new Label(label);
        pane.add(usernamLabel, 0, 0);

        // Username Field
        TextField usernameField = new TextField();
        pane.add(usernameField, 1, 0);


        return pane;
    }
}
