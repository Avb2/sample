package org.com.db;

import org.com.bases.Database;

import java.util.Map;
import org.com.db.parser.ResultSetParser;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecurityDatabase extends Database{
    public Map<String, String> passwordRecoveryInfo(String username) throws SQLException{
        // Query db for answer and question based off the username
        ResultSet query = super.query("SELECT question, answer FROM users WHERE username=?", new String[]{username});
        // Return a Map<String, String> containing the question and answer
        return new ResultSetParser(query).parseToStringDict(new String[] {"question", "answer"})[0];

    }
}
  