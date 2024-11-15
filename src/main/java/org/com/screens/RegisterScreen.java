package org.com.screens;


import java.sql.SQLException;

import org.com.bases.Screen;
import org.com.components.buttons.EnterBtn;
import org.com.components.InputField;
import org.com.components.buttons.MainMenuBtn;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.com.functionality.registration.Register;
import org.com.functionality.login.Login;
import org.com.db.UserDatabase;
import org.com.state.db.Pool;
import java.sql.Connection;



public class RegisterScreen extends Screen{
    private Connection connection;


    public RegisterScreen(Connection connection){
        this.connection = connection;
    }

    @Override
    public GridPane createPane(Stage stage){
        
        
        // Grid pane
        GridPane pane = new GridPane();
        pane.getStyleClass().add("background-primary");
        pane.setAlignment(Pos.CENTER);

        // main menu
        pane.add(MainMenuBtn.mainMenuButton(this.connection, stage), 0 ,0);



        // Register label
        Label registerLabel = new Label("Register");
        pane.add(registerLabel, 0, 1, 2, 1);

        GridPane subpane = new GridPane();
        pane.add(subpane, 0, 4);

        // First name
        GridPane firstNameField = InputField.inputField("First Name");
        subpane.add(firstNameField, 0 ,0);
        
        // last name 
        GridPane lastNameField = InputField.inputField("Last Name");
        subpane.add(lastNameField,0 ,1);

        // Address
        GridPane addressField =  InputField.inputField("Address");
        subpane.add(addressField,0 ,2);

        // Zipcode field
        GridPane zipcodeField =  InputField.inputField("Zipcode");
        subpane.add(zipcodeField, 0 ,3);

        // State field
        GridPane stateField =  InputField.inputField("State");
        subpane.add(stateField, 0 ,4);

        // Username
        GridPane usernameField = InputField.inputField("Username");
        subpane.add(usernameField, 0 ,5);

        // Password
        GridPane passwordField = InputField.inputField("Password");
        subpane.add(passwordField, 0 ,6);

        // Email
        GridPane emailField = InputField.inputField("Email");
        subpane.add(emailField, 0 ,7);

        // SSN 
        GridPane ssnField = InputField.inputField("SSN");
        subpane.add(ssnField, 0 ,8);

        // Security Question
        GridPane securityQuestion = InputField.inputField("Security Question");
        subpane.add(securityQuestion, 0 ,9);

        // Security Question
        GridPane securityAnswer = InputField.inputField("Security Answer");
        subpane.add(securityAnswer, 0 ,10);
 


        pane.add(EnterBtn.EnterButton(e -> {
            Register.createAccount(this.connection, pane,  firstNameField, lastNameField, addressField, zipcodeField, stateField, usernameField, passwordField, emailField, ssnField, securityQuestion, securityAnswer, stage);
        }), 0, 5, 2, 1);


        return pane; 


    }
}
