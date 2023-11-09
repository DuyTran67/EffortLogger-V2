package application;

// Controller class for Login page. Checks to see if username and password exist and let users log into 

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Alert;

public class LoginController {
    private Scene scene;
    private Stage stage;
    private Parent root;
    
    private String username, pw;
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    
    public void submitLogin(ActionEvent event) {
		try {
			// get user and pw from text fields
			username = usernameField.getText();
			pw = passwordField.getText();
			
			// if user and pw valid, show success pop up
			if (isValid(username, pw)) {
                // open effort log console
        			root = FXMLLoader.load(getClass().getResource("/FXML_files/EffortLoggerConsole.fxml"));
        			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        			scene = new Scene(root);
        			stage.setScene(scene);
        			stage.setTitle("EffortLogger V2");
        			stage.show();    
        			
	    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Success");
	                alert.setHeaderText(null);
	                alert.setContentText("You have successfully logged in!");
	                alert.getButtonTypes();
	                alert.showAndWait();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Credentials");
                alert.setHeaderText(null);
                alert.setContentText("Your username and password do not match.");
                alert.showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   	
	public boolean isValid(String username, String password) {
		// admin access
		if (username.equals("teamth1") && password.equals("cse360")) {
			return true;
		}
		return false;
	}
	
	public void register(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/CreateAccount.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();  
	}

}

