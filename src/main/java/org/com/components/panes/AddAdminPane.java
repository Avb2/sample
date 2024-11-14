package org.com.components.panes;

import org.com.bases.Panes;

import java.sql.Connection;

import javafx.scene.layout.GridPane;
import org.com.state.UserState;
import javafx.stage.Stage;
import org.com.components.InputField;
import org.com.components.buttons.EnterBtn;
import org.com.models.RegistrationAdmin;
import org.com.components.navbars.AdminNavBar;
import javafx.stage.Stage;
import org.com.functionality.registration.Register;



public class AddAdminPane extends Panes{
    private Stage stage; 
    public AddAdminPane(Stage stage){
        this.stage = stage;
    }

    @Override
    public void createPane(GridPane mainPane, UserState userState, Connection connection){
        mainPane.getChildren().clear();
        
        GridPane pane = new GridPane();
        mainPane.add(pane, 0, 0);

        GridPane navBar = new AdminNavBar(this.stage, userState, connection).createComponent();
        pane.add(navBar, 0, 0);

        // Add  admins
        GridPane firstNameField = InputField.inputField("First Name");
        pane.add(firstNameField, 0, 1);

        // Add field to delete admins
        GridPane lastNameField = InputField.inputField("Last Name");
        pane.add(lastNameField, 0, 2);

        // Add field to delete admins
        GridPane emailField = InputField.inputField("email");
        pane.add(emailField, 0, 3);

        // OTHER FIELDS WILL BE NULL SINCE NOT USEFUL FOR ADMIN USERS
        // SECURITY QUESTION/ANSWER WILL BE DEFAULTED TO  ssn Number

        // Add field to delete admins
        GridPane ssnField = InputField.inputField("SSN");
        pane.add(ssnField, 0, 4);


        // Add failed to add label with fade animation


        pane.add(EnterBtn.EnterButton(e -> {
            RegistrationAdmin registrationModel = new RegistrationAdmin(
                firstNameField,
                lastNameField,
                emailField,
                ssnField
                );

                String[] valid = Register.validateAdminAcct(registrationModel);

                if (valid.length == 4){
                    Register.createAdmin(connection, registrationModel);
                    System.out.println("Created admin");
                } else {
                    System.out.println("Failed to create admin");
                }

            // Register.createAdminAccount(registrationModel);
                }), 0, 6);



    }


}
