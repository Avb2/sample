package org.com.db;

import java.sql.ResultSet;
import org.com.bases.Database;


public class FlightDatabase extends Database {

    public ResultSet retrieveFlights(){
        return super.query("SELECT * FROM flights");
    }

}   
