package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController {
	@FXML
	private Button effortConsoleButton, editorButton, defectButton, logsButton, definitionsButton, pokerButton;
	
	private Parent root;
	private Scene scene;
	private Stage stage;
	
	public void goToEffortConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
	}
	
	public void goToEditor(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/EffortLogEditor.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
	}
	
	public void goToDefect(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/DefectConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
	}
	
	public void goToLogs(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/DefectConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
	}
	
	public void goToDefinitions(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/Definitions.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
	}
	
	public void goToPoker(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/planningpoker/PlanningPokerStart.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
	}
	
}
