package org.com.functionality.navigation;

import org.com.bases.Navigate;
import javafx.stage.Stage;
import org.com.state.UserState;
import org.com.screens.EditFlightScreen;


public class PushEditFlight extends Navigate{
    @Override 
    public void push(UserState userState, Stage stage){
        stage.setScene(new EditFlightScreen(userState).createScreen(stage));
    }
}
