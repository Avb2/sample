package org.com.animations;

import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.scene.Node;


public class Fade {
    private Node node; 

    public Fade(Node node){
        this.node = node;
    }

    public void fade(int seconds){
        FadeTransition animation = new FadeTransition(Duration.millis(seconds * 1000));
                    animation.setNode(this.node);
                    animation.setFromValue(1.0); 
                    animation.setToValue(0.0); 
                    animation.setAutoReverse(false);
                    animation.setCycleCount(1);

                    // Fading aniamtion
                    animation.play();
    }
}
