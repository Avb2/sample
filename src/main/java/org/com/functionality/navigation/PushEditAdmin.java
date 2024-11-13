package org.com.functionality.navigation;

import org.com.bases.Navigate;
import org.com.state.UserState;
import javafx.stage.Stage;
import java.sql.Connection;
import org.com.screens.EditAdminScreen;



public class PushEditAdmin extends Navigate{
    @Override
    public void push(Connection connection, UserState state, Stage stage){
        stage.setScene(new EditAdminScreen(connection, state).createScreen(stage));
    }
}
