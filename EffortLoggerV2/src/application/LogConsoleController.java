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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogConsoleController implements Initializable {
    @FXML
    private Button startButton, stopButton, editorButton, defectButton, definitionsButton, logsButton, homeButton;
    @FXML
    private ComboBox<String> projectCombo, lifeCycleCombo, effortCategoryCombo, deliverableCombo;
    
    @FXML
    private Text clockText;
    @FXML
    private Rectangle clockRectangle;
    
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
    	lifeCycleCombo.setItems(FXCollections.observableArrayList("Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review", "Detailed Design Plan", "Detailed Design/Prototype", "Detailed Design Review", "Implementation plan", "Test Case Generation", "Solution Specification", "Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update"));
    	effortCategoryCombo.setItems(FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others"));
    	deliverableCombo.setItems(FXCollections.observableArrayList("Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other"));
    }
    
    // This method starts the activity and starts the timer.
    @FXML
    private void startActivity(ActionEvent event) {
    	System.out.println("Activity started");
		startTime = System.nanoTime();        
		clockText.setText("Clock is running");
		clockRectangle.setFill(Color.web("0x0dff3e", 1.0));
		clockRectangle.setStroke(Color.web("0x0dff3e", 1.0));
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
    		clockText.setText("Clock is stopped");
    		clockRectangle.setFill(Color.RED);
    		clockRectangle.setStroke(Color.RED);
            System.out.println("Activity stopped");
        	storeActivityDataInDatabase(stoppedProject, stoppedLifeCycle, stoppedEffortCategory, stoppedDeliverable, startTime, endTime);

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

    // Establish a database connection. Replace with your actual database connection logic.
    private static Connection establishConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    // Store activity data in the database
    public static void storeActivityDataInDatabase(String project, String lifeCycle, String effortCategory, String deliverable, long startTime, long endTime) {
        try (Connection connection = establishConnection()) {
            if (connection != null) {
                String sql = "INSERT INTO activity_log (project, life_cycle, effort_category, deliverable, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, project);
                    preparedStatement.setString(2, lifeCycle);
                    preparedStatement.setString(3, effortCategory);
                    preparedStatement.setString(4, deliverable);
                    preparedStatement.setLong(5, startTime);
                    preparedStatement.setLong(6, endTime);

                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception according to your application's error-handling strategy
        }
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
