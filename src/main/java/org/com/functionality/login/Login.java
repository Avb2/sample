package org.com.functionality.login;

import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import org.com.state.UserState;
import org.com.screens.HomeScreen;
import org.com.db.UserDatabase;

import java.sql.SQLException;


public class Login {
    public static void login(GridPane usernameFieldPane, GridPane passwordFieldPane, Stage stage){
        UserDatabase conn = new UserDatabase();
            // Extract textfields from gridpanes
            TextField usernameField = (TextField) (usernameFieldPane.getChildren().get(1));
            TextField passwordField = (TextField) (passwordFieldPane.getChildren().get(1));
 
            // Extract text from textfields
            String username = usernameField.getText();
            String password = passwordField.getText();

            try {
                // Validate user by username and password
                Boolean validUser = conn.validateUsername(username, password);

                // Login user if auth was successful
                if (validUser == true) {
                    // Create user state
                    UserState userState = new UserState();
                    
                    // Update user state and status within User State
                    userState.login(conn, username);
                   
                

                    // Push to main logged in screen
                    stage.setScene(new HomeScreen(userState).createScreen(stage));
                } else {
                    System.out.println("Failed to validate user");
                }
            } catch (SQLException error) {
                error.printStackTrace();
            }

    }
}