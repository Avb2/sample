package org.com.db;

import org.com.bases.Database;


public class BookingDatabase extends Database{
    public void createBooking(Object[] args, Object[] types){
        super.updateQuery("INSERT INTO bookings(uid, fid) VALUES (?, ?)", args, types);
    }

    public ResultSet retrieveBookingByUser(int uid){
        return super.query("SELECT * FROM flights INNER JOIN bookings ON flights.number = bookings.fid INNER JOIN users ON users.uid = bookings.uid WHERE users.uid = ?", new Object[] {uid}, new Object[] {Integer.class});
   }
}
