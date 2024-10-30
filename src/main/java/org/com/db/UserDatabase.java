package org.com.db;

import java.util.HashMap;

import javax.xml.transform.Result;

import org.com.db.parser.ResultSetParser;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.com.bases.Database;


public class UserDatabase extends Database{

    public Map<String, Object>[] retrieveAllInfo (String username) throws SQLException{
        ResultSet result = super.query("SELECT uid, firstname, lastname FROM users WHERE username=?", new String[] {username});
        
        
        return new ResultSetParser(result).parse(new String[] {"uid", "firstname", "lastname"}, new Class<?>[] {Integer.class, String.class, String.class});
    }

    public Map<String, String>[] retrieveName(String username) throws SQLException{
        ResultSet result = super.query("SELECT firstname, lastname FROM users WHERE username=?", new String[] {username}); 
         
         return new ResultSetParser(result).parseToStringDict(new String[] {"firstname", "lastname"});
     }
 
    public Boolean validateUsername(String username, String password) throws SQLException{
        // Query db using username and password
        ResultSet rs = super.query("SELECT uid FROM users WHERE username=? AND password=?", new String[]{username, password});

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
            "INSERT INTO users(firstname, lastname, address, zipcode, state, username, password, email, ssn, question, answer) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
            info,
            new Object[] {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}
            );
    }
}   
