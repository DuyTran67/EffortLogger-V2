
package application;

import javafx.application.Application;  
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.*;

public class LoginController {
    private Scene scene;
    private Stage stage;
    private Login login = new Login();
    
    private TextField usernameField;
    private PasswordField passwordField;
    
    @FXML
    public void submitLogin(ActionEvent event) throws Exception {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
    	login.setName(usernameField.getText());
    	login.setPassword(passwordField.getText());
    	
    	// Check that username/password length is 4 <= x <= 32
    	int userLen = login.getUsernameLength();
    	int pwLen = login.getPasswordLength();
    	if (userLen >= 4 && userLen <= 32 && pwLen >= 4 && pwLen <= 32) {
        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	scene = new Scene(FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml")));
        	stage.setScene(scene);
        	stage.show(); 
    	}
    }
}

