package org.com.models;


import javafx.scene.Node;
import javafx.scene.layout.GridPane;



// public class Registration {
//     private String firstName;
//     private String lastName;
//     private String address;
//     private String zipcode;
//     private String state;
//     private String username;
//     private String password;
//     private String email;
//     private String question;
//     private String answer;
//     private String type;

//     public Registration(
//          GridPane firstName,
//          GridPane lastName,
//          GridPane address,
//          GridPane zipcode,
//          GridPane state,
//          GridPane username,
//          GridPane password,
//          GridPane email,
//          GridPane question,
//          GridPane answer
//     ){
//         this.firstName = this.toString(firstName);
//         this.lastName = this.toString(lastName);
//         this.address = this.toString(address);
//         this.zipcode = this.toString(zipcode);
//         this.state = this.toString(state);
//         this.username = this.toString(username);
//         this.password = this.toString(password);
//         this.email = this.toString(email);
//         this.question = this.toString(question);
//         this.answer = this.toString(answer);
//     }

//     private GridPane toString(GridPane pane){
//         Node[] nodes = pane.getChildren();
//         TextField textField = nodes.get(1);
//         String string = textField.getText();

//         return string;
//     }


//     public Object[] toArray(){
//         return new Object[] {this.firstName, this.lastName, this.address, this.zipcode, this.state, this.username, this.password, this.email, this.question, this.email};
//     }

// }
