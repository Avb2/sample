package org.com.components.navbars;

import org.com.constants.Sizes;
import org.com.state.UserState;
import org.com.components.ManageFlightsButton;
import org.com.bases.Component;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.com.components.MainMenuBtn;
import org.com.components.LogOutBtn;

import javafx.scene.Node; 
import java.sql.Connection;


public class AuthenticatedNavBar extends Component{
    private Connection connection;
    private final Stage stage;
    private UserState userState;

    public AuthenticatedNavBar(Connection connection, Stage stage, UserState userState){
        this.connection = connection;
        this.stage = stage;
        this.userState = userState;
    }

    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setHgap(40);

        

        pane.add(MainMenuBtn.mainMenuButton(this.connection, this.stage, this.userState), 0, 0);
        
        pane.add(new ManageFlightsButton(this.connection, this.stage, this.userState).createComponent(), 1, 0);
        
        pane.add(LogOutBtn.LogOutButton(this.connection, this.stage, this.userState), 2, 0);

        return pane;




    }
}