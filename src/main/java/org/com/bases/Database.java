package org.com.bases;


import java.sql.*;

import java.util.List; 
import java.util.Map;
import java.util.ArrayList;



public abstract class Database {
    private final String url = "jdbc:postgresql://localhost:5432/FlightProj";
    private final String user = "alexbringuel";
    private final String password = "nova";

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


}
