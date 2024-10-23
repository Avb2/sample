package org.com.screens;


import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegisterScreen extends Screen{
    public Scene createScreen(Stage stage){
        // Grid pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        // main menu
        pane.add(MainMenuBtn.mainMenuButton(stage), 0 ,0);



        // Register label
        Label registerLabel = new Label("Register");
        pane.add(registerLabel, 0, 1, 2, 1);

        GridPane subpane = new GridPane();
        pane.add(subpane, 0, 4);

        subpane.add(InputField.inputField("First Name"), 0 ,0);
        subpane.add(InputField.inputField("Last Name"),0 ,1);
        subpane.add(InputField.inputField("Address"),0 ,2);
        subpane.add(InputField.inputField("Zipcode"), 0 ,3);
        subpane.add(InputField.inputField("State"), 0 ,4);
        subpane.add(InputField.inputField("Username"), 0 ,5);
        subpane.add(InputField.inputField("Password"), 0 ,6);
        subpane.add(InputField.inputField("Email"), 0 ,7);
        subpane.add(InputField.inputField("SSN"), 0 ,8);
        subpane.add(InputField.inputField("Security Question"), 0 ,9);


        pane.add(EnterBtn.EnterButton(e -> {
            // Create account

            // IF account creation success
            if (true){
                stage.setScene(new LoginScreen().createScreen(stage));
            }
        }), 0, 5, 2, 1);
        
        return new Scene(pane, 600, 450);


    }
}
