package application;
// A controller class for the register page. User creates a new account and store it in a csv file.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterController {
	@FXML
	private TextField userField;
	@FXML
	private PasswordField passwordField1;
	@FXML
	private PasswordField passwordField2;
	
	private String username, password1, password2;
	// An encryption object to encrypt password later
	Encryption aes = new Encryption();
	
	private Parent root;
	private Scene scene;
	private Stage stage;

	public void createAccount(ActionEvent event) throws Exception {
		username = userField.getText();
		password1 = passwordField1.getText();
		password2 = passwordField2.getText();
		
		// user did not enter in one or more fields
		if (username.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Missing Credentials.");
            alert.showAndWait();
        // user re-entered password does not match
		} else if (!password1.equals(password2)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password does not match.");
            alert.showAndWait();
        // user entered all required credentials
		} else {
			// username already exists
			if (usernameExists(username)) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Username already exists.");
                alert.showAndWait();
            // username or password is too short or too long
			} else if (!(username.length() >= 4 && username.length() <= 32 && password1.length() >= 4 && password1.length() <= 32)) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("username or password is too short or too long.");
                alert.showAndWait();
            // No problems. Add account
			} else {
				// before creating a new account, encrypt password
				aes.storeKey();
				byte[] encryptedData = aes.encrypt(password1);
				password1 = Base64.getEncoder().encodeToString(encryptedData);
				Account newAccount = new Account(username, password1);
				// save account info to csv file
				try {
					saveAccount(newAccount);
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Success");
	                alert.setHeaderText(null);
	                alert.setContentText("New Account Created Successfully.");
	                alert.showAndWait();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//TODO: fix usernameExists
	
	// method to check if username already exists
	public boolean usernameExists(String username) throws FileNotFoundException {
		FileReader csvFile = new FileReader("C:\\Users\\duy67\\git\\EffortLoggerV2Repo\\EffortLoggerV2\\src\\application\\accounts.csv");
		BufferedReader fileReader = new BufferedReader(csvFile);
        
		return false;
	}
	
	// method to save account credentials to csv file
	public void saveAccount(Account acc) throws IOException {
		File csvFile = new File("C:\\Users\\duy67\\git\\EffortLoggerV2Repo\\EffortLoggerV2\\src\\application\\accounts.csv");
		FileWriter fileWriter = new FileWriter(csvFile,true);
        String line = acc.getUser() + "," + acc.getPW();
        fileWriter.write(line.toString());
        fileWriter.append("\n");
        fileWriter.close();
	}
	
	// method to redirect back to login page
	public void returnToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/LoginPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show(); 
	}
}
