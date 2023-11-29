package application;

/* This class establishes a JDBC Connection in Java so that  
 * data from our Effort Logger program can be stored in the
 * database for future use.
 */

import java.sql.*;

public class DBConnection {
	// creating the JDBC URL, username and password for the database
    private static final String URL = "jdbc:h2:~/test";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "cse360th1";

    // creating a connection object
    private static Connection connection;
    
    // establishing the connection to the database
    public static void main(String[] args) throws SQLException {
                try {
					Class.forName("org.h2.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} //loads the h2 driver
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); //establishes the connection
                System.out.println("Connection Established successfully");
                
                connection.close();
                System.out.println("Connection Closed....");
    }
}