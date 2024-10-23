package org.com.screens;

import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SecurityQuestionScreen extends Screen{

    @Override
    public Scene createScreen(Stage stage) {
        GridPane pane = new GridPane();

        // Main menu button
        pane.add(MainMenuBtn.mainMenuButton(stage), 0, 0);

        // Reset password label
        Label label = new Label("Reset Password");
        pane.add(label, 0, 1);

        // Sub pane
        GridPane subpane = new GridPane();
        pane.add(subpane, 0, 4);



        // Security Question answer field & label
        subpane.add(new Label("SECURITY QUESTION WILL GO HERE"), 0, 0);
        subpane.add(InputField.inputField("Answer"), 0, 1);

        // Enter Button
        subpane.add(EnterBtn.EnterButton(e -> {}), 0, 2);
        return new Scene(pane, 450, 300);
    }
    
}
