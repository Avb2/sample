package org.com.screens;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;
import org.com.constants.ScreenSizes;



public class LoginScreen extends Screen {
    @Override
    public Scene createScreen(Stage stage){
        // Grid
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(ScreenSizes.mediumGap);

        
        // Return to Main Menu Button
        pane.add(MainMenuBtn.MainMenuBtn(stage), 0, 0);

        // Login title label
        Label loginTitle = new Label("LOGIN");
        pane.add(loginTitle, 0, 3);

        

        // Add subpane to main pane
        GridPane subPane = new GridPane();
        subPane.setVgap(ScreenSizes.smallGap);
        pane.add(subPane, 0, 4);


        // Username Label
        subPane.add(InputField.inputField("Username"), 0, 0, 2, 1);


        // Password Label
        subPane.add(InputField.inputField("Password"), 0, 1, 2, 1);


        // Login Button
        subPane.add(EnterBtn.EnterButton(e -> {}), 0, 2);


        // Reset Password Button
        Button resetButton = new Button("Reset Password");
        resetButton.setPrefSize(150,30);
        resetButton.setStyle("-fx-font-size: 15");
        resetButton.setOnAction(e -> stage.setScene(new ResetPasswordScreen().createScreen(stage)));
        subPane.add(resetButton, 1, 2);


        return new Scene(pane, 450, 300);
    }

  
}
