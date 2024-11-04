package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.com.bases.Database;


public class FlightDatabase extends Database {

    public ResultSet retrieveFlights() throws SQLException{
        return super.query("SELECT * FROM Flights");
    }

    public void deleteFlight(String flightNumber) throws SQLException{
        super.updateQuery(
            "DELETE FROM Flights WHERE number =?",
            new Object[] {Integer.parseInt(flightNumber)},
            new Object[] {Integer.class}
        );
    }

}   
