package org.com.state.db;

import java.sql.Connection;
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





public class Pool {
    private final String url = "jdbc:postgresql://cd1goc44htrmfn.cluster-czrs8kj4isg7.us-east-1.rds.amazonaws.com:5432/dcese51jgd6029"; 
    private final String user = "u98ds5dvffs3sc"; 
    private final String password = "p88e32db4c67278d01d41cf09c25c72c22ce6528476c2e6c350a95068fc329fc6"; 
    private Connection connection = null;

    // Create a connection to the database;
    private void connect() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Getter
    public Connection returnConnection(){
        this.connect();
        return this.connection;
    }
}