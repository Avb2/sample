package org.com.db.parser;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.sql.Date;
import java.sql.Time;


public class ResultSetParser {
    private ResultSet rs;

    public ResultSetParser(ResultSet rs){
        this.rs = rs;
    }


    public Hashtable<String, String> parseToStringDict(String[] keys){
        Hashtable<String, String> dict = new Hashtable<>();

        try {
            if (this.rs.next()) {
                for (String key: keys){
                    System.out.println(key);
                    dict.put(key, this.rs.getString(key));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return dict;
    }


    public Hashtable<Object, Object> parse(String[] keys, Class<?>[] types){
        // If lengths do not match return empty list
        if (keys.length != types.length){
            return new Hashtable<>();
        }

        Hashtable<Object, Object> dict = new Hashtable<>();


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



