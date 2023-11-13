package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LogConsoleController implements Initializable {
    @FXML
    private Button startButton, stopButton, editorButton, defectButton, definitionsButton, logsButton, homeButton;
    @FXML
    private ComboBox<String> projectCombo, lifeCycleCombo, effortCategoryCombo, deliverableCombo;
    
    private long startTime;
    private long endTime;

    private Parent root;
    private Scene scene;
    private Stage stage;
    
    // This method loads in all the combobox items
    @Override
    public void initialize(URL url, ResourceBundle resourcebundle) {
    	// Later on, implement ArrayList<String> projects = new ArrayList<>();  from definitions 
    	projectCombo.setItems(FXCollections.observableArrayList("Development Project", "Business Project"));
    	// Load other combo boxes
    }
    
    // This method starts the activity and starts the timer.
    @FXML
    private void startActivity(ActionEvent event) {
    	System.out.println("Activity started");
		startTime = System.nanoTime();        
    }

    // This method stops the activity, record all the data, store them, stop the timer, and display activity time elapsed.
    @FXML
    private void stopActivity(ActionEvent event) {
        // Implement logic to stop an activity and store in the database
        String stoppedProject = projectCombo.getValue();
        String stoppedLifeCycle = lifeCycleCombo.getValue();
        String stoppedEffortCategory = effortCategoryCombo.getValue();
        String stoppedDeliverable = deliverableCombo.getValue();
	    
        // Check that user has selected everything
        if (stoppedProject == null || stoppedLifeCycle == null || stoppedEffortCategory == null || stoppedDeliverable == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Details");
            alert.setHeaderText(null);
            alert.setContentText("One or more lists are not selected");
            alert.showAndWait();
            // Store the data in the database
        } else {
            System.out.println("Activity stopped");
        	storeActivityDataInDatabase(stoppedProject);

	        endTime = System.nanoTime();
	        long timeElapsed = (endTime - startTime) / 1000000000;
	        System.out.println("Time of activity: " + timeElapsed + "s");
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Activity Stopped");
            alert.setHeaderText(null);
            alert.setContentText("Activity has been stopped and logged");
            alert.showAndWait();
        }
	        
    }

    private void storeActivityDataInDatabase(String project) {
        // Implement logic to store activity data in the database
    	
    }

    // The following methods are to navigate to other pages
    @FXML
    private void goToEditor(ActionEvent event) throws Exception {
        // Implement logic to navigate to the Effort Log Editor
		root = FXMLLoader.load(getClass().getResource("/FXML_files/EffortLogEditor.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
    }
    
    @FXML
    private void goToDefectConsole(ActionEvent event) throws Exception {
        // Implement logic to navigate to the Defect Log Console
    	root = FXMLLoader.load(getClass().getResource("/FXML_files/EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
    }
	
    @FXML
    private void goToDefinitions(ActionEvent event) throws Exception {
        // Implement logic to navigate to the Definitions
     	root = FXMLLoader.load(getClass().getResource("/FXML_files/Definitions.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
    }
	@FXML
    private void goToLogs(ActionEvent event) throws Exception {
        // Implement logic to navigate to the Effort and Defect Logs
	 	root = FXMLLoader.load(getClass().getResource("/FXML_files/Logs.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
    }
	
	@FXML
    private void goHome(ActionEvent event) throws Exception {
        // Implement logic to navigate to the Effort and Defect Logs
	 	root = FXMLLoader.load(getClass().getResource("/FXML_files/HomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
    }
    
}