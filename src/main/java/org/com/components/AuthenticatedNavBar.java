package org.com.components;

import org.com.constants.Sizes;
import org.com.state.UserState;
import org.com.components.ManageFlightsButton;
import org.com.bases.Component;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.Node; 


public class AuthenticatedNavBar extends Component{
    private final Stage stage;
    private UserState userState;

    public AuthenticatedNavBar(Stage stage, UserState userState){
        this.stage = stage;
        this.userState = userState;
    }

    @Override
    public Node createComponent(){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(40);

        

        pane.add(MainMenuBtn.mainMenuButton(this.stage, this.userState), 0, 0);
        pane.add(new ManageFlightsButton(this.stage, this.userState).createComponent(), 1, 0);
        
        pane.add(LogOutBtn.LogOutButton(this.stage, this.userState), 2, 0);

        return pane;




    }
}