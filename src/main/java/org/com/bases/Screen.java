package org.com.bases;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import org.com.constants.Sizes;


public abstract class Screen {
    public Scene createScreen(Stage stage){
        GridPane pane = this.createPane(stage); 
        Scene scene =  new Scene(pane, Sizes.primaryHeight, Sizes.primaryWidth);
        scene.getStylesheets().add(getClass().getResource("/org/com/style.css").toExternalForm());
        return scene;
    }

    public abstract GridPane createPane(Stage stage);
}
