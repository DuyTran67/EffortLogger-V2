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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.scene.Parent;

public class MainEffortLogger extends Application {
	@Override
	public void start(Stage stage) {
		try {
			// starting screen
			Parent root1 = FXMLLoader.load(getClass().getResource("/FXML_files/LoginPage.fxml"));
			Scene scene1 = new Scene(root1);
			stage.setScene(scene1);
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
