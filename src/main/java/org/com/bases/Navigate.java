package org.com.bases;

import org.com.state.UserState;
import javafx.stage.Stage;


public abstract class Navigate {
    public abstract void push(UserState state, Stage stage);
}
