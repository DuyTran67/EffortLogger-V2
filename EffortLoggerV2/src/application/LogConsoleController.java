import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;

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

        // Perform additional validation if needed

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
        List<String> projects = fetchProjectsFromDatabase();

        // Clear existing items in the menu button
        projectSplitMenuButton.getItems().clear();

        // Populate the menu button with projects
        for (String project : projects) {
            MenuItem menuItem = new MenuItem(project);
            menuItem.setOnAction(event -> handleProjectSelection(project));
            projectSplitMenuButton.getItems().add(menuItem);
        }
    }

    private List<String> fetchProjectsFromDatabase() {
        // Implement logic to fetch projects from the database
        // This is a placeholder, replace it with your actual database logic
        return List.of("Development Project", "Business Project");
    }

    private void handleProjectSelection(String selectedProject) {
        // Implement any additional logic when a project is selected
        System.out.println("Selected Project: " + selectedProject);
    }

    private void loadLifeCycles() {
        // Implement logic to load life cycles from the database and populate the lifeCycleSplitMenuButton
    }

    private void loadEffortCategories() {
        // Implement logic to load effort categories from the database and populate the effortCategorySplitMenuButton
    }

    private void loadDeliverables() {
        // Implement logic to load deliverables from the database and populate the deliverableSplitMenuButton
    }

    // Add more methods as needed for managing other data

    @FXML
    private void goToEditor(ActionEvent event) {
        // Implement logic to navigate to the Effort Log Editor
    }

    @FXML
    private void goToDefectConsole(ActionEvent event) {
        // Implement logic to navigate to the Defect Log Console
    }
}
