package org.com.components.navbars;


import org.com.bases.Component;
import org.com.state.UserState;
import org.com.components.EditFlightsBtn;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.Node; 
import javafx.geometry.Pos;
import org.com.components.MainMenuBtn;
import org.com.components.LogOutBtn;
import org.com.functionality.navigation.PushEditFlight;
import java.sql.Connection;

public class AdminNavBar extends Component{
    private final Stage stage;
    private UserState userState;
    private Connection connection;

    public AdminNavBar(Stage stage, UserState userState, Connection connection){
        this.stage = stage;
        this.userState = userState;
        this.connection = connection;
    }

    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setHgap(40);

        

        pane.add(MainMenuBtn.mainMenuButton(this.connection, this.stage, this.userState), 0, 0);

        pane.add(new EditFlightsBtn(() -> {new PushEditFlight().push(this.connection, userState, stage);}).createComponent(), 1, 0);
        
        pane.add(LogOutBtn.LogOutButton(this.connection, this.stage, this.userState), 2, 0);

        return pane;




    }
}