package org.com.db;

import org.com.bases.Database;


public class BookingDatabase extends Database{
    

    public void createBooking(String[] args){
        super.query("INSERT INTO bookings(uid, fid) VALUES (?, ?)", args);
    }
}
