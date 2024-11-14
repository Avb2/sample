package org.com.components.panes;

import java.sql.Connection;

import javafx.scene.layout.GridPane;
import org.com.state.UserState;
import javafx.stage.Stage;
import org.com.components.InputField;
import org.com.components.buttons.EnterBtn;
import org.com.components.navbars.AdminNavBar;
import org.com.bases.Panes;
import org.com.db.UserDatabase;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.util.Map;


public class LookupAdminPane extends Panes{
    private Stage stage;

    public LookupAdminPane(Stage stage){
        this.stage = stage;
    }


    @Override
    public void createPane(GridPane mainPane, UserState userState, Connection connection){
        mainPane.getChildren().clear();
        
        GridPane pane = new GridPane();
        mainPane.add(pane, 0, 0);


        GridPane adminNavBar = new AdminNavBar(this.stage, userState, connection).createComponent();
        pane.add(adminNavBar, 0, 0);

        GridPane lookupField = InputField.inputField("Username or SSN");
        pane.add(lookupField, 0, 1);



        // Fading error label

        // 
        pane.add(EnterBtn.EnterButton(
            e -> {
                try{
                    UserDatabase userDb = new UserDatabase(connection);
                    TextField textField = (TextField) (lookupField.getChildren().get(1));

                    Map<String, Object> userInfo = userDb.retrieveAllInfoBySSN(textField.getText())[0];
    
                    new UserInfoPane(this.stage, userInfo).createPane(mainPane, userState, connection);
                } catch (SQLException err){
                    err.printStackTrace();
                }
               
            }
        ), 0, 3);


    }
}
