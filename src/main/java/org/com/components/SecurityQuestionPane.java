package org.com.components;

import org.com.bases.Component;

import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;
import org.com.db.UserDatabase;
import org.com.functionality.resetPassword.ResetPassword;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import org.com.screens.LoginScreen;




public class SecurityQuestionPane extends Component{
    private final String question;
    private final String answer;
    private final Stage stage;
    private final String username;

    public SecurityQuestionPane(String question, String answer, String username, Stage stage){
        this.question = question;
        this.answer = answer;
        this.username = username;
        this.stage = stage;
    }
    @Override 
    public Node createComponent() {
        // 
        GridPane pane = new GridPane();

        
        pane.add(new Label(this.question), 0, 0);


        // Security Question answer field & label
        pane.add(new Label(), 0, 0);
        GridPane answerPane = InputField.inputField("Answer");
        pane.add(answerPane, 0, 1);


        // Enter Button
        pane.add(EnterBtn.EnterButton(e -> {
            ResetPassword.answerSecurityQuestion(this.username, this.answer, answerPane, pane, this.stage);
        }), 0, 2);
        return pane;
    }
}
