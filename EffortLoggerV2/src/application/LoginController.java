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

public class LoginController extends Application {
    private Scene scene;
    private Stage stage;
    private Login login = new Login();
    
    private TextField usernameField;
    private PasswordField passwordField;
    
    public void submitLogin(ActionEvent event) throws Exception {
    	
    }
}
