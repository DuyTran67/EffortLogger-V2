package application;

/***** Mainline class for the EffortLogger V2 project. Calls all the function and invokes the login mechanism. 
 *****DO NOT CHANGE*****
 * 
 * 
 */

import javafx.application.Application;         
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.h2.engine.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.sql.Connection;

import javafx.scene.control.*;
import javafx.scene.Parent;

public class MainEffortLogger extends Application {
	private static Connection connection;
	
	@Override
	public void start(Stage stage) {
		try {
			// Connect to the database
			DBConnection.getConnection();
			DBCreation.createEffortLogs();

			// Load the definitions
			FXMLLoader.load(getClass().getResource("/FXML_files/Definitions.fxml"));
			// starting screen
			Parent root = FXMLLoader.load(getClass().getResource("/FXML_files/LoginPage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("EffortLogger V2");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
