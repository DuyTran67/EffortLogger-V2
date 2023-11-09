package application;
// A controller class for the register page. User creates a new account and store it in a csv file.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

public class RegisterController {
	@FXML
	private TextField userField;
	@FXML
	private PasswordField passwordField1, passwordField2;
	
	private String username, password1, password2;
	private ArrayList<Account> accountList = new ArrayList<Account>();

	public void createAccount(ActionEvent event) {
		username = userField.getText();
		password1 = passwordField1.getText();
		password2 = passwordField2.getText();
		
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("/EffortLoggerV2/src/application/accounts.csv"));
			// check if user entered all the required fields
			if (username.equals(null) || password1.equals(null) || password2.equals(null)) {
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
				Account newAccount = new Account(username, password1);
				if (usernameExists(newAccount)) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("Username already exists.");
	                alert.showAndWait();
                // else if everything is fine, add new account
				} else {
					accountList.add(newAccount);
					// save account info to csv file
					try {
						saveAccount(newAccount);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// method to check if username already exists
	public boolean usernameExists(Account acc) {
		for (Account current : accountList) {
			if (current.getUser().equals(acc.getUser())) {
				return true;
			}
		}
		return false;
	}
	
	public void saveAccount(Account acc) throws IOException {
		File csvFile = new File("/EffortLoggerV2/src/application/accounts.csv");
		FileWriter fileWriter = new FileWriter(csvFile,true);
        String[] data = {acc.getUser(), acc.getPW()};
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            line.append(data[i].replaceAll("\"","\"\""));
            if (i != data.length - 1) {
                line.append(',');
            }
        }
        line.append("\n");
        fileWriter.write(line.toString());
        fileWriter.close();
	}
}
