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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

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
    
    private DefinitionsController def_page = new DefinitionsController();
    
    
    // This method loads in all the combobox items
    @Override
    public void initialize(URL url, ResourceBundle resourcebundle) {
    	try {
			FXMLLoader.load(getClass().getResource("/FXML_files/Definitions.fxml"));
    	//ArrayList<String> deli = def_page.getDeliverables();
    	//System.out.println("aa:" + deli.get(0));
    	projectCombo.setItems(FXCollections.observableArrayList("Development Project", "Business Project"));
    	lifeCycleCombo.setItems(FXCollections.observableArrayList("Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review", "Detailed Design Plan", "Detailed Design/Prototype", "Detailed Design Review", "Implementation plan", "Test Case Generation", "Solution Specification", "Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update"));
    	effortCategoryCombo.setItems(FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others"));
    	deliverableCombo.setItems(FXCollections.observableArrayList("Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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



    // Store activity data in the database
    public static void storeActivityDataInDatabase(Timestamp startTime, Timestamp endTime, String project, String lifeCycle, String effortCategory, String deliverable) {

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
