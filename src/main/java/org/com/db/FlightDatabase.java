package org.com.db;

import java.sql.ResultSet;
import org.com.bases.Database;


public class FlightDatabase extends Database {

    public ResultSet retrieveFlights(){
        return super.query("SELECT * FROM flights");
    }


    public ResultSet retrieveFlightsByUser(int uid){

        //TODO add a sql join. Need to query bookings to get matches for uid and then query flights to get flightt data
        return super.query("SELECT * FROM flights INNER JOIN bookings ON flights.number = bookings.fid INNER JOIN users ON users.uid = bookings.uid WHERE users.uid = ?", new Object[] {uid}, new Object[] {Integer.class});
    }



}   
