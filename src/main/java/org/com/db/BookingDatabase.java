package org.com.db;

import org.com.bases.Database;
import java.sql.ResultSet;


public class BookingDatabase extends Database{
    public void createBooking(Object[] args, Object[] types){
        super.updateQuery("INSERT INTO bookings(uid, fid) VALUES (?, ?) ON CONFLICT (uid, fid) DO NOTHING", args, types);
    }

    public ResultSet retrieveBookingByUser(int uid){
        return super.query("SELECT * FROM flights INNER JOIN bookings ON flights.number = bookings.fid INNER JOIN users ON users.uid = bookings.uid WHERE users.uid = ?", new Object[] {uid}, new Object[] {Integer.class});
   }


   public void removeBooking(int uid, String fid){
    super.updateQuery("DELETE FROM bookings WHERE uid=? AND fid=?", new Object[] {uid, fid}, new Object[] {Integer.class, String.class});
   }
}
