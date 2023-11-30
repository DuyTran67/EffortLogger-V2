package application;

/* This class establishes a JDBC Connection in Java so that  
 * data from our Effort Logger program can be stored in the
 * database for future use.
 */

import java.sql.*;

public class DBConnection {
	// creating the JDBC URL, username and password for the database
    private static final String URL = "jdbc:h2:./EffortLoggerDB";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "cse360th1";

    // creating a connection object
    private static Connection connection;
   
    // establishing the connection to the database
    public static Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName("org.h2.Driver"); //loads the h2 driver
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); //establishes the connection
                System.out.println("Successfully established connection to the database.");
            }
            catch(ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to establish connection to the database", e);
            }
        }
        return connection;
    }
}