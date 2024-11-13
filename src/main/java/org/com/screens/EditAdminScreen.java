package org.com.screens;

import org.com.bases.Screen;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.com.state.UserState;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import java.sql.Connection;
import org.com.components.navbars.AdminNavBar;
import org.com.components.panes.AddAdminPane;


public class EditAdminScreen extends Screen{
    private Connection connection;
    private UserState userState;

    public EditAdminScreen(Connection connection, UserState userState){
        this.connection = connection;
        this.userState = userState;
    }
    
    
    @Override
    public Scene createScreen(Stage stage){
        GridPane pane = new GridPane();

        // Admin nav bar
        GridPane adminNavBar = new AdminNavBar(stage, userState, connection).createComponent();
        pane.add(adminNavBar, 0, 0);




        // Manage admins button
        Button manageAdminBtn = new Button("Add Admin");
        manageAdminBtn.setOnAction(e -> new AddAdminPane(stage).createPane(pane, userState, connection));
        pane.add(manageAdminBtn, 0, 1);




        return new Scene(pane, 450, 450);
    }
}
