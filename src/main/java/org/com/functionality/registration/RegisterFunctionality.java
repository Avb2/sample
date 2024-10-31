package org.com.functionality.registration;


import javafx.scene.control.TextField;
import org.com.components.InputField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;



@FunctionalInterface
interface Validator {
    boolean validate(String input);
}


public class RegisterFunctionality {
    public static String[] validateRegistrationForm(GridPane[] fields){

        Validator[] validators = {
            RegisterFunctionality::validateName, 
            RegisterFunctionality::validateName,
            RegisterFunctionality::validateAddress,
            RegisterFunctionality::validateZipcode,
            RegisterFunctionality::validateState,
            RegisterFunctionality::validateUsername,
            RegisterFunctionality::validatePassword,
            RegisterFunctionality::validateEmail, 
            RegisterFunctionality::validateSSN,
            RegisterFunctionality::validateQuestion,
            RegisterFunctionality::validateQuestion
        };
        

        String[] info = new String[fields.length];



        for (int i = 0; i < fields.length; i++){
            System.out.println(fields[i].getChildren().get(0));
            TextField textField = (TextField) (fields[i].getChildren().get(1));
            // Check if fields are empty
            if (textField.getText().isEmpty() || !validators[i].validate(textField.getText())){
                System.out.println("FAIL TO VALIDATE "+ " "+ textField.getText());
                return new String[]{};
            } 
            info[i] = textField.getText();



            
        }
        return info;
    }

    // If name is greater than 2 digits and only contains letters
    public static boolean validateName(String name){
        
        if (name.length() < 3){
            return false;
        } else if (name.matches(".*\\d.*")){
            return false;
        }
        return true;
    }
    

    // Begins with numbers and contains letters ex: 203 Pryor Street
    public static boolean validateAddress(String address){
        if (address.matches("\\d{1,8}\\s.*")){
            return true;
        }
        return false;
    }


    // Only digits and 5 chars
    public static boolean validateZipcode(String zipcode){
        return zipcode.matches("\\d{5}");
    }


    // 2 letters for state, caps does not matter
    public static boolean validateState(String state){
        return state.matches("(?i)[a-z]{2}");
    }

    // Username contains atleast 1-10 letter and can contain numbers 1-8
    public static boolean validateUsername(String username){
        if (username.matches("(?i)[a-z]{1,10}[0-9]{1,8}")){
            return true;
        }
        return false;
        // make sure no conflicting in db
    }

    // Password contains letters/special chars and numbers
    public static boolean validatePassword(String password){
        if (password.matches("(?i)[a-z1-9!@#$%^&*_+-]{4,15}")){
            return true;
        } 
        return false;
    }
    
    // Email contains atleast 3-10 letters (Not caps sensitive), and ends with .org or .com
    public static boolean validateEmail(String email){
        if (email.matches("(?i).*@[a-z]{3,10}\\.(com|org)$")){
            return true;
        }
        return false;
    }

   
    public static boolean validateSSN(String ssn){
        if (ssn.matches("^\\d{9}$")){
            // Validate no other same ssn
            return true;
        }

        return false;
    }
    

    public static boolean validateQuestion(String string){
        return  !string.isEmpty();
    }
    
    
}