package org.com.db;

import org.com.bases.Database;


public class BookingDatabase extends Database{
    public void createBooking(Object[] args, Object[] types){
        super.updateQuery("INSERT INTO bookings(uid, fid) VALUES (?, ?)", args, types);
    }
}
