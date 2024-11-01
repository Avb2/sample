package org.com.functionality.resetPassword;


import javafx.scene.control.TextField;
import org.com.components.InputField;
import javafx.scene.layout.GridPane;
import org.com.components.EnterBtn;
import org.com.db.UserDatabase;
import javafx.stage.Stage;
import org.com.screens.LoginScreen;
import javafx.scene.control.Label;
import java.sql.SQLException;


public class ResetPassword {
    public static void answerSecurityQuestion(String username , String answer, GridPane answerPane, GridPane pane, Stage stage){
        // Extract the textfield from the grid pane
        TextField answerTextField = (TextField) (answerPane.getChildren().get(1));
            // Check if the inputted answer matches the security answer
            if (answerTextField.getText().equals(answer)){
                // Clear existing content from the pane
                pane.getChildren().clear();
                
                // New password/confirm fields
                GridPane newPasswordPane = InputField.inputField("New password");
                pane.add(newPasswordPane, 0, 0);

                GridPane confirmPasswordPane = InputField.inputField("Confirm password");
                pane.add(confirmPasswordPane, 0 , 1);

                // Submit security answer button
                pane.add(EnterBtn.EnterButton(lam -> {
                    TextField newPasswordTextField = (TextField) (newPasswordPane.getChildren().get(1));
                    TextField confirmPasswordTextField = (TextField) (confirmPasswordPane.getChildren().get(1));
                    String newPassword = newPasswordTextField.getText();
                    String confirmPassword = confirmPasswordTextField.getText();
                    
                    if (newPassword.matches(confirmPassword)){
                        try{
                            new UserDatabase().changePassword(username, confirmPassword);
                            stage.setScene(new LoginScreen().createScreen(stage));
                        } catch (SQLException err){
                            err.printStackTrace();
                        }
                    } else {
                        pane.add(new Label("Passwords did not match"), 0, 3);
                    }
                    }), 0, 2);

            }
    }
}
