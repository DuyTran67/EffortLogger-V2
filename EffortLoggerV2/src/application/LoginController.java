package application;

/***** Controller class for Login page. Checks to see if username and password exist and let users log into the system.
 * 
 * @author: Duy Tran
 * 
 */

import javafx.scene.Node; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

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
    private String csvPath = "C:\\Users\\duy67\\git\\EffortLoggerV2Repo\\EffortLoggerV2\\src\\application\\accounts.csv";
    
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
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   	
    // method to check if username and password are valid. Return true if admin.
    // Reads credentials from csv file and check if user and password are correct.
	public boolean isValid(String username, String password) throws IOException {
		// admin access
		if (username.equals("admin") && password.equals("admin")) {
			return true;
		}
		
		// Encryption to decrypt the stored passwords and compare 
		Encryption aes = new Encryption();		
		List<List<String>> records = new ArrayList<>();
		FileReader csvFile = new FileReader(csvPath);
		BufferedReader fileReader = new BufferedReader(csvFile);
		String line;
		
    	while((line = fileReader.readLine()) != null) {
    		String[] items = line.split(",");
        	records.add(Arrays.asList(items));
    	}
        fileReader.close();
        
        for (List<String> curr : records) {
        	// turn input password into encrypted form and compare
        	try {
				byte[] encryptedPW = aes.encrypt(password);
				password = Base64.getEncoder().encodeToString(encryptedPW);				
			} catch (Exception e) {
				e.printStackTrace();
			}

        	if (username.equals(curr.get(0)) && password.equals(curr.get(1))) {
        		return true;
        	}
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

