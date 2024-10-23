package org.com.db;

import java.sql.*;



public class Connect {
    private final String url = "jdbc:postgresql://host:port/FlightProj";
    private final String user = "";
    private final String password = "";


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


    public ResultSet Query(String query){
        // Connect to the database
        Connection conn = connect();

        // Initialize statement
        Statement statement = null;

        // Create statement
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }  

        // Initialize result set
        ResultSet result = null;
        
        // Retrieve result from the db
        try {
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}   
