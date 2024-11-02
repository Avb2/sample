package org.com.screens;

import org.com.bases.Screen;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import org.com.components.navbars.AdminNavBar;
import org.com.components.InputField;
import org.com.state.UserState;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import org.com.components.panes.CustomFlightPane;
import org.com.components.panes.EditFlightPane;


public class EditFlightScreen extends Screen{
    private UserState userState;

    public EditFlightScreen(UserState userState){
        this.userState = userState;
    }


    @Override
    public Scene createScreen(Stage stage) {
        GridPane pane = new GridPane();
        pane.add(new AdminNavBar(stage, userState).createComponent(), 0, 0);
        pane.setAlignment(Pos.CENTER);


        // Load pane for action
        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> {
            pane.getChildren().clear();
            pane.add(new CustomFlightPane(userState, stage, () -> {}).createComponent(), 0, 1);
        });
        pane.add(addBtn, 0, 1);

        Button editBtn = new Button("Edit");
        editBtn.setOnAction(e -> {
            pane.getChildren().clear();
            pane.add(new EditFlightPane(userState, stage).createComponent(), 0, 1);
        });
        pane.add(editBtn, 0, 2);

        Button deleteBtn = new Button("Delete");
        pane.add(deleteBtn, 0, 3);


        return new Scene(pane, 450, 500);
    };
}

