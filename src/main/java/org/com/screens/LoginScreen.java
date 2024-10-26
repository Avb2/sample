package org.com.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.util.HashMap;

import java.util.List; 
import java.util.Map;
import java.util.ArrayList;

import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;
import org.com.constants.Sizes;
import org.com.state.UserState;
import org.com.db.Connect;


public class LoginScreen extends Screen {
    @Override
    public Scene createScreen(Stage stage){
        // Grid
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(Sizes.mediumGap);

        
        // Return to Main Menu Button
        pane.add(MainMenuBtn.mainMenuButton(stage), 0, 0);

        // Login title label
        Label loginTitle = new Label("LOGIN");
        pane.add(loginTitle, 0, 3);

        

        // Add subpane to main pane
        GridPane subPane = new GridPane();
        subPane.setVgap(Sizes.smallGap);
        pane.add(subPane, 0, 4);


        // Username Label
        GridPane usernameFieldPane = InputField.inputField("Username");
        subPane.add(usernameFieldPane, 0, 0, 2, 1);


        // Password Label
        GridPane passwordFieldPane = InputField.inputField("Password");
        subPane.add(passwordFieldPane, 0, 1, 2, 1);


        // Login Button
        subPane.add(EnterBtn.EnterButton(e -> {
            Connect conn = new Connect();
            // Extract textfields from gridpanes
            TextField usernameField = (TextField) (usernameFieldPane.getChildren().get(1));
            TextField passwordField = (TextField) (passwordFieldPane.getChildren().get(1));

            // Extract text from textfields
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Validate user by username and password
            Boolean validUser = conn.validateUsername(username, password);

            // Login user if auth was successful
            if (validUser == true){
                // Create user state
                UserState userState = new UserState();
                userState.setLoggedInState();

                // Get users name
                Map<String, String>[] names = conn.retrieveName(username);
                // Set name in UserState
                userState.setName(names[0].get("firstname"), names[0].get("lastname"));

                // Push to main logged in screen
                stage.setScene(new HomeScreen(userState).createScreen(stage));
            } else {
                System.out.println("Failed to validate user");
            }

            
        }), 0, 2);


        // Reset Password Button
        Button resetButton = new Button("Reset Password");
        resetButton.setPrefSize(150,30);
        resetButton.setStyle("-fx-font-size: 15");
        resetButton.setOnAction(e -> stage.setScene(new ResetPasswordScreen().createScreen(stage)));
        subPane.add(resetButton, 1, 2);


        return new Scene(pane, 450, 300);
    }

  
}
