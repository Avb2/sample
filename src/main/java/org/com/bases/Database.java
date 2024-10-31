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
    private final String url = "jdbc:postgresql://cd1goc44htrmfn.cluster-czrs8kj4isg7.us-east-1.rds.amazonaws.com:5432/dcese51jgd6029"; 
    private final String user = "u98ds5dvffs3sc"; 
    private final String password = "p88e32db4c67278d01d41cf09c25c72c22ce6528476c2e6c350a95068fc329fc6"; 

    // Create a connection to the database;
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
        return conn;
    }

    // Query the database and return info
    public ResultSet query(String query){
        // Connect to the database
        Connection conn = connect();
        ResultSet result = null;
        
        try{
            // Initialize statement
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            result = statement.executeQuery(query);

        } catch (SQLException e){
            System.err.println(e);
        }
        return result;
    }

    public ResultSet query(String query, String[] args){
        // Connect to the database
        Connection conn = connect();

        // Initialize statement
        PreparedStatement statement = null;

        // Create statement
        try {
            statement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        // Connect to the database
        Connection conn = connect();

        // Initialize statement
        PreparedStatement statement = null;

        // Create statement
        try {
            statement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        // Connect to the database
        Connection conn = connect();

        // Initialize statement
        PreparedStatement statement = null;

        // Create statement
        try {
            statement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

        // Update result from the db
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}

