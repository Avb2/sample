package org.com.components.panes;

import java.sql.Connection;

import javafx.scene.layout.GridPane;
import org.com.state.UserState;
import javafx.stage.Stage;
import org.com.components.InputField;
import org.com.components.buttons.EnterBtn;
import org.com.components.navbars.AdminNavBar;
import org.com.bases.Panes;


public class DeleteAdminPane extends Panes{
    private Stage stage;

    public DeleteAdminPane(Stage stage){
        this.stage = stage;
    }


    @Override
    public void createPane(GridPane mainPane, UserState userState, Connection connection){
        mainPane.getChildren().clear();
        
        GridPane pane = new GridPane();
        mainPane.add(pane, 0, 0);


        GridPane adminNavBar = new AdminNavBar(this.stage, userState, connection).createComponent();
        pane.add(adminNavBar, 0, 0);

        GridPane usernameField = InputField.inputField("Username");
        pane.add(usernameField, 0, 1);

        // Fading error label

        // 
        pane.add(EnterBtn.EnterButton(
            e -> {
                System.out.println("hi");
            }
        ), 0, 3);


    }
}
