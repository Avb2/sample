package org.com.functionality.registration;


import javafx.scene.control.TextField;
import org.com.components.InputField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;

public class RegisterFunctionality {
    public static boolean validateRegistrationForm(GridPane[] fields){
       
        for (int i = 0; i < fields.length; i++){
            TextField textField = (TextField) (fields[i].getChildren().get(1));
            // Check if fields are empty
            if (textField.getLength() == 0){
                return false;
            }
            
        }
        return true;
    }


    public static void validateFirstName(){

    }
    public static void validateLastName(){

    }
    public static void validateAddress(){

    }

    public static void validateZipcode(){
        
    }

    public static void validateState(){
        
    }



    public static void validateUsername(){

    }

    public static void validatePassword(){
        
    }
    
    public static void validateEmail(){
        
    }

    public static void validateSSN(){
        
    }
    
    public static void validateQuestion(){
        
    }
    public static void validateAnswer(){
        
    }
    
    
}
