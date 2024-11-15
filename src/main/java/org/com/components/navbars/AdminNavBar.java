package org.com.components.navbars;


import org.com.bases.Component;
import org.com.state.UserState;
import org.com.components.buttons.EditFlightsBtn;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.geometry.Pos;
import org.com.components.buttons.MainMenuBtn;
import org.com.components.LogOutBtn;
import org.com.functionality.navigation.PushEditFlight;
import org.com.components.buttons.ManageAdminsBtn;
import java.sql.Connection;

public class AdminNavBar extends Component{
    private final Stage stage;
    private UserState userState;
    private Connection connection;
    private GridPane mainPane;

    public AdminNavBar(Stage stage, UserState userState, Connection connection, GridPane mainPane){
        this.stage = stage;
        this.userState = userState;
        this.connection = connection;
        this.mainPane = mainPane;
    }

    @Override
    public GridPane createComponent(){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setHgap(40);

        

        pane.add(MainMenuBtn.mainMenuButton(this.connection, this.stage, this.userState, this.mainPane), 0, 0);

        pane.add(new EditFlightsBtn(() -> {new PushEditFlight().push(this.connection, userState, stage);}).createComponent(), 1, 0);
        
        pane.add(new ManageAdminsBtn(this.connection, this.userState, this.stage).createComponent(), 2, 0);
        
        pane.add(LogOutBtn.LogOutButton(this.connection, this.stage, this.userState, this.mainPane), 3, 0);

        return pane;
    }
}