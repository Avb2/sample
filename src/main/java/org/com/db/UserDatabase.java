package org.com.db;

import java.util.HashMap;

import javax.xml.transform.Result;

import org.com.db.parser.ResultSetParser;
import java.util.Map;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.com.bases.Database;
import java.sql.Connection;
import org.com.models.RegistrationAdmin;


public class UserDatabase extends Database{
    public UserDatabase(Connection connection){
        super(connection);
    }


    public Map<String, Object>[] retrieveInfoByUsername (String username) throws SQLException{
        ResultSet result = super.query("SELECT id, firstname, lastname, type FROM Users WHERE username=?", new String[] {username});
        
        
        return new ResultSetParser(result).parse(new String[] {"id", "firstname", "lastname", "type"}, new Class<?>[] {Integer.class, String.class, String.class, String.class});
    }

    public Map<String, Object>[] retrieveInfoBySSN (String ssn) throws SQLException{
        ResultSet result = super.query("SELECT id, firstname, lastname, type FROM Users WHERE ssn=?", new String[] {ssn});
        
        
        return new ResultSetParser(result).parse(new String[] {"id", "firstname", "lastname", "type"}, new Class<?>[] {Integer.class, String.class, String.class, String.class});
    }
    

 public Map<String, Object>[] retrieveAllInfoBySSN (String ssn) throws SQLException{
        ResultSet result = super.query("SELECT id, firstname, lastname, type, username, password, zipcode, ssn, address, state, email, question, answer, type FROM Users WHERE ssn=?", new String[] {ssn});
        
        
        return new ResultSetParser(result).parse(
            new String[] {
                "id",
                "firstname",
                "lastname", 
                "type", 
                "username", 
                "password", 
                "zipcode", 
                "ssn", 
                "address", 
                "state", 
                "email", 
                "question", 
                "answer", 
                "type"
            }, new Class<?>[] {
                Integer.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class
                    });
    }
    
    


    public Map<String, String>[] retrieveName(String username) throws SQLException{
        ResultSet result = super.query("SELECT firstname, lastname FROM Users WHERE username=?", new String[] {username}); 
         
         return new ResultSetParser(result).parseToStringDict(new String[] {"firstname", "lastname"});
     }
 
    public boolean validateUsername(String username, String password) throws SQLException{
        // Query db using username and password
        ResultSet rs = super.query("SELECT id FROM Users WHERE username=? AND password=?", new String[]{username, password});

        // Create parser object
        ResultSetParser parser = new ResultSetParser(rs);

        // Count rows in Result set
        int count = parser.countResult(rs);
        // If there is exactly one matched instance, authenticate the user
        if (count == 1){
            return true;
        }
        return false;
        
    }

    public void registerUser(Object[] info) throws SQLException{
        super.updateQuery(
            "INSERT INTO Users(firstname, lastname, address, zipcode, state, username, password, email, ssn, question, answer, type) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
            info,
            new Object[] {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}
            );
    }
    
    public void registerUser(RegistrationAdmin registrationModel) throws SQLException{
        super.updateQuery(
            "INSERT INTO Users(firstname, lastname, username, password, email, ssn, question, answer, type) VALUES(?, ?, ?, ?, ?, ?, ?,?,?)", 
            registrationModel.toArray(true),
            registrationModel.types(true)
            );
    }

    public Map<String, String> retrieveSecurityInfo(String username) throws SQLException {
        ResultSet result = super.query("SELECT question, answer FROM Users WHERE username=?", new String[] {username});
        return new ResultSetParser(result).parseToStringDict(new String[] {"question", "answer"})[0];
    }

    public void changePassword(String username, String password) throws SQLException{
        System.out.println(username + "  " + password);
        super.updateQuery("UPDATE Users SET password=? WHERE username=?", new Object[] {password, username}, new Object[] {String.class, String.class});
    }

    public boolean validateType(String username) throws SQLException{
        ResultSet rs = super.query("SELECT type FROM Users WHERE username=?", new String[] {username});
        String[] keys = new String[]{"type"};
        Map<String, String> typeDict = new ResultSetParser(rs).parseToStringDict(keys)[0];

        if (typeDict.get(keys[0]).matches("admin")){
            return true;
        } 
        return false;

    }


}       
