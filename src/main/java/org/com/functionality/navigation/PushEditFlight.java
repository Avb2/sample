package org.com.functionality.navigation;

import org.com.bases.Navigate;
import javafx.stage.Stage;
import org.com.state.UserState;
import org.com.screens.EditFlightScreen;
import java.sql.Connection;

public class PushEditFlight extends Navigate{
    @Override 
    public void push(Connection connection, UserState userState, Stage stage){
        stage.setScene(new EditFlightScreen(connection, userState).createScreen(stage));
    }
}
