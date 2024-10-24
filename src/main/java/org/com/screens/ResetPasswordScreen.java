package org.com.screens;

import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;
import org.com.constants.ScreenSizes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class ResetPasswordScreen extends Screen {
    @Override
    public Scene createScreen(Stage stage){
        // Main pane
        GridPane pane = new GridPane();
        pane.setVgap(ScreenSizes.largeGap);
        pane.setAlignment(Pos.CENTER);


        // Main menu Btn
        pane.add(MainMenuBtn.mainMenuButton(stage), 0, 0);

        
        // Reset password label
        Label resetLabel = new Label("Reset Password");
        pane.add(resetLabel, 0, 2);


        GridPane subPane = new GridPane();
        subPane.setVgap(ScreenSizes.mediumGap);
        subPane.setHgap(ScreenSizes.mediumGap);
        pane.add(subPane, 0, 3);


        // Username form
        subPane.add(InputField.inputField("Username"), 0, 0);
        
    
        // Enter Button
        // TODO for now it just navs to next screen but need to add check for username in db which will retrieve security question
        subPane.add(EnterBtn.EnterButton(e -> stage.setScene(new SecurityQuestionScreen().createScreen(stage))), 1, 1);





        Scene resetPasswordStage = new Scene(pane, 450, 300);

        return resetPasswordStage;
    }

}