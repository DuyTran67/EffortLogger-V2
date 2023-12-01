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
	    connection = DBConnection.getConnection();
        Statement statement = null; //creating statement object
        try {
        	statement = connection.createStatement();
        	String query = "CREATE TABLE IF NOT EXISTS EFFORT_LOGS (" +
        			"ID INT PRIMARY KEY AUTO_INCREMENT," +
        			"START_TIME TIMESTAMP, " +
        			"END_TIME TIMESTAMP, " +
        			"PROJECT_NAME VARCHAR(255), " +       			
        			"LIFE_CYCLE_STEP VARCHAR(255), " +
        			"EFFORT_CATEGORY VARCHAR(255), " +
        			"DELIVERABLE VARCHAR(255));";

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
	
	public static void insertEffortLog(Timestamp startTime, Timestamp endTime, String project, String lifeCycle, String effortCategory, String deliverable) {
		connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO EFFORT_LOGS (START_TIME, END_TIME, PROJECT_NAME, LIFE_CYCLE_STEP, EFFORT_CATEGORY, DELIVERABLE) VALUES (?, ?, ?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setTimestamp(1, startTime);
			preparedStatement.setTimestamp(2, endTime);
			preparedStatement.setString(3, project);
			preparedStatement.setString(4, lifeCycle);
			preparedStatement.setString(5, effortCategory);
			preparedStatement.setString(6, deliverable);
			preparedStatement.executeUpdate();
			System.out.println("Successfully created Effort Log.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //closing the prepared statement
            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	
}
