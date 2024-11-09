package org.com.bases;


import java.sql.*;

import java.util.List; 
import java.util.Map;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.HashMap;
import java.sql.Date;
import java.sql.Time;



public abstract class Database {
    private Connection connection;

    public Database(Connection connection){
        this.connection = connection;
    }

    // Query the database and return info
    public ResultSet query(String query){
        ResultSet result = null;
        
        try{
            // Initialize statement
            Statement statement =  this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            result = statement.executeQuery(query);

        } catch (SQLException e){
            System.err.println(e);
        }
        return result;
    }

    public ResultSet query(String query, String[] args){
        // Initialize statement
        PreparedStatement statement = null;

        // Create statement
        try {
            statement =  this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }  

        for (int index = 0; index < args.length; index++){
            try {
                statement.setString(index + 1, args[index]);
            } catch (SQLException e) {
            }
        }

        // Initialize result set
        ResultSet result = null;
        
        // Retrieve result from the db
        try {
            result = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet query(String query, Object[] args, Object[] types){
        // Initialize statement
        PreparedStatement statement = null;

        // Create statement
        try {
            statement =  this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }  

        for (int i = 0; i < args.length; i++){
            try {
                if (types[i] == Integer.class) {
                    statement.setInt(i + 1, (Integer) (args[i]));
                } else if (types[i] == String.class) {
                    statement.setString(i + 1, (String) (args[i]));
                } else if (types[i] == Double.class) {
                    statement.setDouble(i + 1, (Double) (args[i]));
                
                } else if (types[i] == Date.class) {
                    statement.setDate(i + 1, (Date)(args[i]));
                } else if (types[i] == Time.class) {
                    statement.setTime(i + 1, (Time)(args[i]));
                }
                
            } catch (SQLException e) {
            }
        }

        // Initialize result set
        ResultSet result = null;
        
        // Retrieve result from the db
        try {
            result = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


      // Update db
      public void updateQuery(String query, Object[] args, Object[] types){
        System.out.println(args.length);
        // Initialize statement
        PreparedStatement statement = null;

        // Create statement
        try {
            statement =  this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }  

        for (int i = 0; i < args.length; i++){
            try {
                if (types[i] == Integer.class) {
                    statement.setInt(i + 1, (Integer) (args[i]));
                } else if (types[i] == String.class) {
                    statement.setString(i + 1, (String) (args[i]));
                } else if (types[i] == Double.class) {
                    statement.setDouble(i + 1, (Double) (args[i]));
                
                } else if (types[i] == Date.class) {
                    statement.setDate(i + 1, (Date)(args[i]));
                } else if (types[i] == Time.class) {
                    statement.setTime(i + 1, (Time)(args[i]));
                } else if (types[i] == Timestamp.class) {
                    statement.setTimestamp (i + 1, (Timestamp)(args[i]));
                }
            } catch (SQLException e) {
            }
        }

        // Update result from the db
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

