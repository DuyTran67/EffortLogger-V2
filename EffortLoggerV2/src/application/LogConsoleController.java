package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
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
=======
import javafx.scene.control.SplitMenuButton;
import java.util.Arrays;
import java.util.List;
>>>>>>> refs/remotes/origin/main

<<<<<<< HEAD
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
=======
public class LogConsoleController {

    @FXML
    private SplitMenuButton projectSplitMenuButton;

    @FXML
    private SplitMenuButton lifeCycleSplitMenuButton;

    @FXML
    private SplitMenuButton effortCategorySplitMenuButton;

    @FXML
    private SplitMenuButton deliverableSplitMenuButton;

    // Placeholder methods, you need to implement the actual logic

    @FXML
    private void startActivity(ActionEvent event) {
	System.out.println("Activity started");

        // Load or refresh data for project, life cycle, effort category, deliverable, etc.
        loadProjects();
        loadLifeCycles();
        loadEffortCategories();
        loadDeliverables();
    }

    @FXML
    private void stopActivity(ActionEvent event) {
        // Implement logic to stop an activity and store in the database
        String stoppedProject = projectSplitMenuButton.getText();
        String stoppedLifeCycle = lifeCycleSplitMenuButton.getText();
        String stoppedEffortCategory = effortCategorySplitMenuButton.getText();
        String stoppedDeliverable = deliverableSplitMenuButton.getText();
	    
        // Store the stopped activity information in the database
        storeActivityDataInDatabase(stoppedProject, stoppedLifeCycle, stoppedEffortCategory, stoppedDeliverable);

        // Display a confirmation message
        showAlert("Activity Stopped", "Activity stopped and logged successfully.");
    }

    private void storeActivityDataInDatabase(/* pass necessary parameters */) {
        // Implement logic to store activity data in the database
>>>>>>> refs/remotes/origin/main
    }
	
<<<<<<< HEAD
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
=======
	private void showAlert(String title, String content) {
	        // Helper method to display an alert
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }

    private void loadProjects() {
        // Simulate fetching projects from the database. Replace this with your actual database logic.
        List<String> projects = List.of("Development Project", "Business Project");

        // Clear existing items in the menu button
        projectSplitMenuButton.getItems().clear();

        // Populate the menu button with projects
        for (String project : projects) {
            MenuItem menuItem = new MenuItem(project);
            projectSplitMenuButton.getItems().add(menuItem);
        }
    }

    private void loadLifeCycles() {
        List<String> projects = List.of("Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review", "Detailed Design Plan", "Detailed Design Review", "Implementation Plan", "Test Case Generation", "Solution Specification", "Solution Review", "Solution Implementation", "Unit System Test", "Reflection", "Repository Update");

        // Clear existing items in the menu button
        projectSplitMenuButton.getItems().clear();

        // Populate the menu button with projects
        for (String project : projects) {
            MenuItem menuItem = new MenuItem(project);
            projectSplitMenuButton.getItems().add(menuItem);
        }
    }

    private void loadEffortCategories() {
        List<String> projects = List.of("Deliverables", "Plans", "Interruptions", "Defects", "Others");

        // Clear existing items in the menu button
        projectSplitMenuButton.getItems().clear();

        // Populate the menu button with projects
        for (String project : projects) {
            MenuItem menuItem = new MenuItem(project);
            projectSplitMenuButton.getItems().add(menuItem);
        }
    }

    private void loadDeliverables() {
        List<String> projects = List.of("Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other");

        // Clear existing items in the menu button
        projectSplitMenuButton.getItems().clear();

        // Populate the menu button with projects
        for (String project : projects) {
            MenuItem menuItem = new MenuItem(project);
            projectSplitMenuButton.getItems().add(menuItem);
        }
    }

    @FXML
    private void goToEditor(ActionEvent event) {
        // Implement logic to navigate to the Effort Log Editor
    }

    @FXML
    private void goToDefectConsole(ActionEvent event) {
        // Implement logic to navigate to the Defect Log Console
>>>>>>> refs/remotes/origin/main
    }
	
<<<<<<< HEAD
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
=======
    @FXML
    private void goToDefinitions(ActionEvent event) {
        // Implement logic to navigate to the Definitions
    }
	@FXML
    private void goToEffortandDefectLogs(ActionEvent event) {
        // Implement logic to navigate to the Effort and Defect Logs
    }
}
>>>>>>> refs/remotes/origin/main
