package org.com.db;

import org.com.bases.Database;

import java.util.Map;
import org.com.db.parser.ResultSetParser;


public class SecurityDatabase extends Database{
    public Map<String, String> passwordRecoveryInfo(String uid){
        ResultSet query = super.query("SELECT question, answer FROM users WHERE username=?", new String[]{username});
        return new ResultSetParser(query).parseToStringDict()[0];

    }
}
  