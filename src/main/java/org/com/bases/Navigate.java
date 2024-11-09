package org.com.bases;

import org.com.state.UserState;
import javafx.stage.Stage;
import java.sql.Connection;


public abstract class Navigate {
    public abstract void push(Connection connection, UserState state, Stage stage);
}
