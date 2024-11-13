package org.com.components.buttons;

import org.com.bases.Component;
import javafx.stage.Stage;
import org.com.state.UserState;
import java.sql.Connection;

import org.com.bases.Navigate;
import org.com.screens.EditAdminScreen;
import javafx.scene.Node;
import javafx.scene.control.Button;


public class ManageAdminsBtn extends Component{
    private Connection connection;
    private UserState userState;
    private Stage stage; 

    public ManageAdminsBtn(Connection connection, UserState userState, Stage stage){
        this.connection = connection;
        this.userState = userState;
        this.stage = stage;
    }


    @Override 
    public Node createComponent(){
        Button button = new Button("Admin");
        button.setOnAction(e -> stage.setScene(new EditAdminScreen(this.connection, this.userState).createScreen(this.stage)));


        return button;
        }
}
