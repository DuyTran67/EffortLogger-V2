package application;

/* This class establishes a JDBC Connection in Java so that  
 * data from our Effort Logger program can be stored in the
 * database for future use.
 */

import java.sql.*;

public class DBConnection {
    // This method establishes a connection to the database
    public static Connection getConnection() {
    	// creating the JDBC URL, username and password for the database
        String URL = "jdbc:h2:~/EffortLoggerDB";
        String USERNAME = "admin";
        String PASSWORD = "cse360th1";
    	Connection connection;
    	
    	try {
	    	connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	     throw new RuntimeException("Failed to establish connection to the database", e);    		
    	}
    	return connection;
    }
}