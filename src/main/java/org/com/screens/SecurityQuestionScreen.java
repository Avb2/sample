package org.com.screens;

import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;
import org.com.db.SecurityDatabase;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Map;

public class SecurityQuestionScreen extends Screen{
    private String question;
    private String answer;

    public SecurityQuestionScreen(String username){
        Map<String, String> securityInfo = null;
        try {
            securityInfo = new SecurityDatabase().passwordRecoveryInfo(username);
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }

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
        subpane.add(new Label(), 0, 0);
        subpane.add(InputField.inputField("Answer"), 0, 1);

        // Enter Button
        subpane.add(EnterBtn.EnterButton(e -> {}), 0, 2);
        return new Scene(pane, 450, 300);
    }
    
}
