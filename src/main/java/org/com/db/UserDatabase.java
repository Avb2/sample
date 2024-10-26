package org.com.db;

import java.util.HashMap;

import javax.xml.transform.Result;

import org.com.db.parser.ResultSetParser;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.com.bases.Database;



public class UserDatabase extends Database{
    public Map<String, String>[] retrieveName(String username){
        ResultSet result = super.query("SELECT firstname, lastname FROM users WHERE username=?", new String[] {username}); 
         
         return new ResultSetParser(result).parseToStringDict(new String[] {"firstname", "lastname"});
     }
 
    public Boolean validateUsername(String username, String password){
        // Query db using username and password
        ResultSet rs = super.query("SELECT uid FROM users WHERE username=? AND password=?", new String[]{username, password});

        // Count of returned instances from db
        int count = 0;
        
        // Count instances 
        try {
            while (rs.next()){
                count++;
            }
        } catch (SQLException e) {
            System.out.println("No data found");
        }

        // If there is exactly one matched instance, authenticate the user
        if (count == 1){
            return true;
        }

        return false;
        
    }

}   
