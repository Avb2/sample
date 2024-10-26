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


    public Map<String, String>[] parseToStringDict(String[] keys){
        Map<String, String>[] dictList = new HashMap[keys.length];
       int count = 0;
        try {
            if (this.rs.next()) {
                HashMap<String, String> dict = new HashMap<String, String>();
                
                for (String key: keys){
                    System.out.println(key);
                    dict.put(key, this.rs.getString(key));
                }

                dictList[count] = dict;
                count++;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return dictList;
    }


    public HashMap<Object, Object> parse(String[] keys, Class<?>[] types){
        // If lengths do not match return empty list
        if (keys.length != types.length){
            return new HashMap<>();
        }

        HashMap<Object, Object> dict = new HashMap<>();


       try { if (this.rs.next()){
            for (int i = 0; i < keys.length; i++){
              if (types[i] == Integer.class){
                dict.put(keys[i], this.rs.getInt(keys[i]));
              } else if (types[i] == String.class){
                dict.put(keys[i], this.rs.getString(keys[i]));
              } else if (types[i] == Double.class){
                dict.put(keys[i], this.rs.getDouble(keys[i]));
              } else if (types[i] == Array.class){
                dict.put(keys[i], this.rs.getArray(keys[i]));
              } else if (types[i] == Date.class){
                dict.put(keys[i], this.rs.getDate(keys[i]));
              } else if (types[i] == Time.class){
                dict.put(keys[i], this.rs.getTime(keys[i]));
              }
            }
        }} catch (SQLException e
        ) {
            e.printStackTrace();
        }
    
        return dict;
    }
}



