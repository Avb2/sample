package org.com.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.com.animations.Animate;
import java.sql.Connection;
import org.com.bases.Screen;
import org.com.constants.Sizes;



public class SplashScreen extends Screen{
    private Connection connection;

    public SplashScreen(Connection connection){
        this.connection = connection;
    }

    @Override
    public Scene createScreen(Stage stage){

        
        // Main splash screen
        GridPane mainPane = new GridPane();
        mainPane.getStyleClass().add("background-primary");
        mainPane.setVgap(Sizes.largeGap);
        mainPane.setAlignment(Pos.CENTER);

        Label label = new Label("QualityAirlines.com");
        label.getStyleClass().add("title");
        mainPane.add(label, 0, 0);


        Animate animationLabel = new Animate(label);
        animationLabel.rotate(1, 360);
        animationLabel.fadeIn(2);


        GridPane subPane = new GridPane();
        subPane.setAlignment(Pos.CENTER);
        subPane.setVgap(Sizes.smallGap);
        mainPane.add(subPane, 0, 2);

        Button loginBtn = new Button("Login");
        loginBtn.setPrefSize(100,30);
        loginBtn.getStyleClass().add("button-1");
        loginBtn.setOnAction(e -> stage.setScene(new LoginScreen(this.connection).createScreen(stage)));
        subPane.add(loginBtn, 0, 0);


        Button registerBtn = new Button( "Register");
        registerBtn.setPrefSize(100,30);
        registerBtn.getStyleClass().add("button-1");
        registerBtn.setOnAction(e -> stage.setScene(new RegisterScreen(this.connection).createScreen(stage)));
        subPane.add(registerBtn, 0, 1);



        Scene scene = new Scene(mainPane, Sizes.primaryHeight, Sizes.primaryWidth);
        scene.getStylesheets().add(getClass().getResource("/org/com/style.css").toExternalForm());

        return scene;
    }
}
