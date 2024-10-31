package org.com.components;

import org.com.bases.Component;

import org.com.bases.Screen;
import org.com.components.EnterBtn;
import org.com.components.InputField;
import org.com.components.MainMenuBtn;
import org.com.db.UserDatabase;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.TextField;



public class SecurityQuestionPane extends Component{
    private final String question;
    private final String answer;
    private final Stage stage;

    public SecurityQuestionPane(String question, String answer, Stage stage){
        this.question = question;
        this.answer = answer;
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
            TextField answerTextField = (TextField) (answerPane.getChildren().get(1));
            if (answerTextField.getText().equals(this.answer)){
                pane.getChildren().clear();
                
                // New password/ confirm fields
                GridPane newPasswordPane = InputField.inputField("New password");
                pane.add(newPasswordPane, 0, 0);
                GridPane confirmPasswordPane = InputField.inputField("Confirm password");
                pane.add(confirmPasswordPane, 0 , 1);

                pane.add(EnterBtn.EnterButton(lam -> {
                    TextField newPasswordTextField = (TextField) (newPasswordPane.getChildren().get(1));
                    TextField confirmPasswordTextField = (TextField) (confirmPasswordPane.getChildren().get(1));
                    try{
                        new UserDatabase().changePassword(newPasswordTextField.getText(), confirmPasswordTextField.getText());
                    } catch (SQLException err){
                        err.printStackTrace();
                    }
                    }), 0, 2);

            }
        }), 0, 2);
        return pane;
    }
}
