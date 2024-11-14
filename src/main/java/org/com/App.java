package org.com;

import org.com.screens.LoginScreen;
import org.com.screens.SplashScreen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.com.state.db.Pool;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pool pool = new Pool();
        Connection connection = pool.returnConnection();
        if (connection != null){
            Scene scene = new SplashScreen(connection).createScreen(stage);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("Error with conn");
        }
    }

    public static void main(String[] args) {
        launch();
    }

}