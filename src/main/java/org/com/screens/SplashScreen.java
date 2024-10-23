package org.com.screens;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.com.bases.Screen;
import org.com.constants.ScreenSizes;

public class SplashScreen extends Screen{
    public Scene createScreen(Stage stage){

        
        // Main splash screen
        GridPane mainPane = new GridPane();
        mainPane.setVgap(ScreenSizes.largeGap);
        mainPane.setAlignment(Pos.CENTER);

        Label label = new Label("QualityAirlines.com");
        label.setStyle("-fx-font-size: 20");
        mainPane.add(label, 0, 0);


        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000), label);
        rotateTransition.setByAngle(360);
        
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), label);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();


        GridPane subPane = new GridPane();
        subPane.setAlignment(Pos.CENTER);
        subPane.setVgap(ScreenSizes.smallGap);
        mainPane.add(subPane, 0, 2);

        Button loginBtn = new Button("Login");
        loginBtn.setPrefSize(100,30);
        loginBtn.setStyle("-fx-font-size: 15");
        loginBtn.setOnAction(e -> stage.setScene(new LoginScreen().createScreen(stage)));
        subPane.add(loginBtn, 0, 0);


        Button registerBtn = new Button( "Register");
        registerBtn.setPrefSize(100,30);
        registerBtn.setStyle("-fx-font-size: 15");
        registerBtn.setOnAction(e -> stage.setScene(new RegisterScreen().createScreen(stage)));
        subPane.add(registerBtn, 0, 1);



        Scene scene = new Scene(mainPane, 300, 300);

        return scene;
    }
}
