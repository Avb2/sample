package org.com.state;

import java.util.HashMap;

public class UserState {
    private String firstName;
    private String lastName;
    private boolean loggedIn;



    // Getters
    public HashMap<String, String> getName(){
        HashMap<String, String> name = new HashMap<>();

        name.put("first name", this.firstName);
        name.put("last name", this.lastName);
        name.put("full name", this.firstName + " " + this.lastName);

        return name;
    }

    public boolean getLoggedInState(){
        return this.loggedIn;
    }

    // Setters
    private void setLoggedInStatePriv(){
        this.loggedIn = !this.loggedIn;
    }

    private void setFirstNamePriv(String name){
        this.firstName = name;
    }

    private void setLastNamePriv(String name){
        this.lastName = name;
    }


    // Methods

    // TODO this should validate name by some measure through db and then set name
    public void setName(String firstName, String lastName){
        if (this.loggedIn == true){
            setFirstNamePriv(firstName);
            setLastNamePriv(lastName);
        }
    }

    public void setLoggedInState(){
        setLoggedInStatePriv();
    }


}
