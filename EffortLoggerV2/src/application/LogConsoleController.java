package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogConsoleController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void goToDefectConsole(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/FXML_files/DefectConsole.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene  = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goToEditor(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/FXML_files/EffortLogEditor.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene  = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
