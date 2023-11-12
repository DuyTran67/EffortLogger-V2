import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;
import java.util.Arrays;
import java.util.List;

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
    }
	
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
    }
	
    @FXML
    private void goToDefinitions(ActionEvent event) {
        // Implement logic to navigate to the Definitions
    }
	@FXML
    private void goToEffortandDefectLogs(ActionEvent event) {
        // Implement logic to navigate to the Effort and Defect Logs
    }
}
