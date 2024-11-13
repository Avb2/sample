package org.com.models;


import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import java.sql.Connection;




// Convert to child of Registration Base class
public class RegistrationAdmin {
    public String firstName;
    private String lastName;
    private String email;
    private String ssn;

    public RegistrationAdmin(
         GridPane firstName,
         GridPane lastName,
         GridPane email,
         GridPane ssn
    ){
        this.firstName = this.toString(firstName);
        this.lastName = this.toString(lastName);
        this.email = this.toString(email);
        this.ssn = this.toString(ssn);
    }

    private String toString(GridPane pane){
        TextField textField = (TextField) (pane.getChildren().get(1));
        
        String string = textField.getText();

        return string;
    }

    public Object[] types(){
        return new Object[] {String.class, String.class, String.class, String.class};
    }

    public Object[] types(boolean register){
        if (register == true){
            return new Object[] {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
        } else {
            return this.types();
        }
        
    }


    public Object[] toArray(){
        return new Object[] {this.firstName, this.lastName, this.email, this.ssn};
    }

    public Object[] toArray(boolean register){
        if (register){
            String username = "admin_"+ this.ssn.substring(6);
            return new Object[] {this.firstName, this.lastName, username, this.ssn, this.email, this.ssn, "What is your SSN?", this.ssn, "admin"};
        } else {
            return this.toArray();
        }
       
    }


    public String generateAdminUsername(Connection connection){
        return "";
    }

    public String generateAdminPassword(Connection connection){
        return "";
    }

}