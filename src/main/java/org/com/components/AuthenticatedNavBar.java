package org.com.components;

import org.com.constants.ScreenSizes;
import org.com.state.UserState;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AuthenticatedNavBar{

    public static GridPane navBar(Stage stage, UserState userState){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(40);

        String name;
        try {
            name  = userState.getName().get("first name");
        } finally {
            System.out.println("Cant find name");
        }

        pane.add(MainMenuBtn.mainMenuButton(stage, userState), 0, 0);
        pane.add(new Label("Welcome, " + name + "!"), 1, 0);
        pane.add(LogOutBtn.LogOutButton(stage, userState), 2, 0);

        return pane;




    }
}