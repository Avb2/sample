package org.com.db.parser;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.HashMap;
import java.sql.Date;
import java.sql.Time;
import java.util.List; 
import java.util.Map;
import java.util.ArrayList;


public class ResultSetParser {
    private ResultSet rs;

    public ResultSetParser(ResultSet rs){
        this.rs = rs;
    }


    // Counts the number of rows in the result set
    public int countResult(ResultSet result) throws SQLException{
      int count = 0;
      while (result.next()){
        count++;
      }
      // Reset the cursor to before the first row
      result.beforeFirst();

      return count;
    }

    public int countResult() throws SQLException{
      int count = 0;
      while (this.rs.next()){
        count++;
      }

      this.rs.beforeFirst();

      return count;
    }

 

    // Parse the Result set to Map<String, String> array, strings ONLY
    public Map<String, String>[] parseToStringDict(String[] keys) throws SQLException{
        Map<String, String>[] dictList = new HashMap[this.countResult(this.rs)];
       int count = 0;
       
            while (this.rs.next()) {
                HashMap<String, String> dict = new HashMap<String, String>();
                
                for (String key: keys){
                    dict.put(key, this.rs.getString(key));
                }

                dictList[count] = dict;
                count++;
            }
        return dictList;
    }

    public Map<String, String>[] parseToStringDict(ResultSet result, String[] keys) throws SQLException{
      Map<String, String>[] dictList = new HashMap[this.countResult(result)];
     int count = 0;
     
          while (result.next()) {
              HashMap<String, String> dict = new HashMap<String, String>();
              
              for (String key: keys){
                  dict.put(key, result.getString(key));
              }

              dictList[count] = dict;
              count++;

          }
    


      return dictList;
  }


    // Parse the result set to Map<String, Object> array for any data type. Must specify datatype
    public Map<String, Object>[] parse(String[] keys, Class<?>[] types) throws SQLException {
      // If lengths do not match return empty array of maps
      if (keys.length != types.length) {
          return new HashMap[0]; 
      }
  
      // Get size of result set
      int resultCount = this.countResult(this.rs); 
      // If the result count is empty, return an empty array of maps
      if (resultCount <= 0){
        return new HashMap[0];
      }

      // Create an array of size of number of rows in the result set
      Map<String, Object>[] objList = new HashMap[resultCount];
  
      int count = 0;
      while (this.rs.next()) {
          Map<String, Object> dict = new HashMap<>();
          for (int i = 0; i < keys.length; i++) {
              if (types[i] == Integer.class) {
                  dict.put(keys[i], this.rs.getInt(keys[i]));
              } else if (types[i] == String.class) {
                  dict.put(keys[i], this.rs.getString(keys[i]));
              } else if (types[i] == Double.class) {
                  dict.put(keys[i], this.rs.getDouble(keys[i]));
              } else if (types[i] == Array.class) {
                  dict.put(keys[i], this.rs.getArray(keys[i]));
              } else if (types[i] == Date.class) {
                  dict.put(keys[i], this.rs.getDate(keys[i]));
              } else if (types[i] == Time.class) {
                  dict.put(keys[i], this.rs.getTime(keys[i]));
              }
          }
          objList[count] = dict; 
          count++;
      }
  
      return objList; 
  }
  
}



