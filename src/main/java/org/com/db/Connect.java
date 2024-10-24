package org.com.db;


import java.util.Hashtable;
import java.sql.*;



public class Connect {
    private final String url = "jdbc:postgresql://localhost:5432/FlightProj";
    private final String user = "alexbringuel";
    private final String password = "nova";


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


    public ResultSet query(String query, String[] args){
        // Connect to the database
        Connection conn = connect();

        // Initialize statement
        PreparedStatement statement = null;

        // Create statement
        try {
            statement = conn.prepareStatement(query);
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


    public Boolean validateUsername(String username, String password){
        // Query db using username and password
        ResultSet rs = this.query("SELECT uid FROM users WHERE username=? AND password=?", new String[]{username, password});

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


    public Hashtable<String, String> retrieveName(String username){
       ResultSet result = this.query("SELECT firstname, lastname FROM users WHERE username=?", new String[] {username}); 

       Hashtable<String, String> names = new Hashtable<>();
    
       int count = 1;

       try {
        if (result.next()) {
            // Retrieve and store the first and last names
            names.put("firstname", result.getString("firstname"));
            names.put("lastname", result.getString("lastname"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    System.out.println(count);

    return names;



    }
}   
