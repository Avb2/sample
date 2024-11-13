package org.com.bases;

import java.sql.Connection;

import javafx.scene.layout.GridPane;
import org.com.state.UserState;
import javafx.stage.Stage;


public abstract class Panes {
    public abstract void createPane(GridPane mainPane, UserState userState, Connection connection);
    public void createPane(GridPane mainPane, UserState userState, Connection connection, Stage stage){}

}
