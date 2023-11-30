package application;

/**** This class implements SQL to create database tables and operations relating to data management
 * 
 * 
 * 
 */

import java.sql.*;

public class DBCreation {
	private static Connection connection;
	public static void createEffortLogs() {
	    DBConnection.getConnection(connection);
        Statement statement = null; //creating statement object
        try {
        	statement = connection.createStatement();
        	String query = "CREATE TABLE IF NOT EXISTS EFFORT_LOGS ("
        			+ "ID INT PRIMARY KEY AUTO INCREMENT,"
        			+ "START_TIME TIMESTAMP, "
        			+ "END_TIME TIMESTAMP, "
        			+ "PROJECT_NAME VARCHAR(255), "        			
        			+ "LIFE_CYCLE_STEP VARCHAR(255), "
        			+ "EFFORT_CATEGORY VARCHAR(255), "
        			+ "DELIVERABLE VARCHAR(255));";
        	statement.executeUpdate(query);
        	System.out.println("Effort Log Table created successfully.");        			
        } catch(SQLException e) {
        	e.printStackTrace();
        } finally {
        	try {
        		if (statement != null) {
        			statement.close();
        		}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        }
	}
	
	public static void insertEffortLog() {
			
	}
	
	
}
