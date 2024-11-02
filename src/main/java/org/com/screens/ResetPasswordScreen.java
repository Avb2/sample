package org.com.screens;

import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;
import org.com.constants.Sizes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.com.db.UserDatabase;

import java.sql.SQLException;
import java.util.Map;
import org.com.components.panes.SecurityQuestionPane;



public class ResetPasswordScreen extends Screen {

    @Override
    public Scene createScreen(Stage stage){
        // Main pane
        GridPane pane = new GridPane();
        pane.setVgap(Sizes.largeGap);
        pane.setAlignment(Pos.CENTER);


        // Main menu Btn
        pane.add(MainMenuBtn.mainMenuButton(stage), 0, 0);

        
        // Reset password label
        Label resetLabel = new Label("Reset Password");
        pane.add(resetLabel, 0, 2);


        GridPane subPane = new GridPane();
        subPane.setVgap(Sizes.mediumGap);
        subPane.setHgap(Sizes.mediumGap);
        pane.add(subPane, 0, 3);


        // Username form
        GridPane usernameField = InputField.inputField("Username");
        subPane.add(usernameField, 0, 0);
        
    
        // Enter Button
       subPane.add(EnterBtn.EnterButton(
            e -> {
                try {
                TextField usernameTextField = (TextField) (usernameField.getChildren().get(1));
                String username = usernameTextField.getText();
                Map<String, String> securityInfo =  new UserDatabase().retrieveSecurityInfo(username);
                pane.getChildren().remove(subPane);
                pane.add(new SecurityQuestionPane(securityInfo.get("question"), securityInfo.get("answer"), username, stage).createComponent(), 0, 3);
                } catch (SQLException err){
                err.printStackTrace();
               }
            }
            ), 1, 1);





        Scene resetPasswordStage = new Scene(pane, 450, 300);

        return resetPasswordStage;
    }

}