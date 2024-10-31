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
    private final String question;
    private final String answer;

  
    public SecurityQuestionScreen(String question, String answer){
       
        this.question = question;
        this.answer = answer;
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

        
        subpane.add(new Label(this.question), 0, 0);


        // Security Question answer field & label
        subpane.add(new Label(), 0, 0);
        GridPane answerPane = InputField.inputField("Answer");
        subpane.add(answerPane, 0, 1);


        // Enter Button
        subpane.add(EnterBtn.EnterButton(e -> {
            TextField answerTextField = (TextField) (answerPane.getChildren().get(1));
            if (answerTextField.getText.equals(this.answer)){
            }
        }), 0, 2);
        return new Scene(pane, 450, 300);
    }
    
}
