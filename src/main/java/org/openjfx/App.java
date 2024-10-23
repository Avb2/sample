package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.LabelSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();

        Label label = new Label("QualityAirlines.com");
        pane.add(label, 0, 0);

        Button loginBtn = new Button("Login");
        pane.add(loginBtn, 0, 2);


        Button registerbtn = new Button("Register");
        pane.add(registerbtn, 0, 3);


        



        Scene scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}