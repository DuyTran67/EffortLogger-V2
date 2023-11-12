package application;

// Mainline class for the EffortLogger V2 project.

import javafx.application.Application;        
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;

public class MainEffortLogger extends Application {
    private TextArea logArea;
    private ComboBox<String> projectComboBox;
    private ComboBox<String> lifeCycleStepComboBox;
    private ComboBox<String> effortCategoryComboBox;
    private ComboBox<String> deliverableComboBox;
    
    BorderPane root = new BorderPane();
    root.setPadding(new Insets(10));

    ToolBar toolbar = new ToolBar();
    Button startActivityButton = new Button("Start an Activity");
    Button stopActivityButton = new Button("Stop this Activity");
    toolbar.getItems().addAll(startActivityButton, stopActivityButton);

    root.setTop(toolbar);

    logArea = new TextArea();
    logArea.setEditable(false);
    root.setCenter(logArea);
    
    HBox projectBox = new HBox(10);
    projectBox.setPadding(new Insets(10));
    Label projectLabel = new Label("Project:");
    projectComboBox = new ComboBox<>(FXCollections.observableArrayList("", "Project 1", "Project 2", "Project 3"));
    projectBox.getChildren().addAll(projectLabel, projectComboBox);

    HBox lifeCycleStepBox = new HBox(10);
    lifeCycleStepBox.setPadding(new Insets(10));
    Label lifeCycleStepLabel = new Label("Life Cycle Step:");
    lifeCycleStepComboBox = new ComboBox<>(FXCollections.observableArrayList("", "Design", "Development", "Testing", "Deployment"));
    lifeCycleStepBox.getChildren().addAll(lifeCycleStepLabel, lifeCycleStepComboBox);

    HBox effortCategoryBox = new HBox(10);
    effortCategoryBox.setPadding(new Insets(10));
    Label effortCategoryLabel = new Label("Effort Category:");
    effortCategoryComboBox = new ComboBox<>(FXCollections.observableArrayList("", "High", "Medium", "Low"));
    effortCategoryBox.getChildren().addAll(effortCategoryLabel, effortCategoryComboBox);

    HBox deliverableBox = new HBox(10);
    deliverableBox.setPadding(new Insets(10));
    Label deliverableLabel = new Label("Deliverable:");
    deliverableComboBox = new ComboBox<>(FXCollections.observableArrayList("", "Software 1", "Software 2", "Software 3"));
    deliverableBox.getChildren().addAll(deliverableLabel, deliverableComboBox);

    VBox sidePanel = new VBox(20);
    sidePanel.getChildren().addAll(projectBox, lifeCycleStepBox, effortCategoryBox, deliverableBox);

    root.setLeft(sidePanel);
    
    startActivityButton.setOnAction(event -> {
        logActivity();
    });

    stopActivityButton.setOnAction(event -> {
        logActivity();
    });
    
    private void logActivity() {
        String project = projectComboBox.getValue();
        String lifeCycleStep = lifeCycleStepComboBox.getValue();
        String effortCategory = effortCategoryComboBox.getValue();
        String deliverable = deliverableComboBox.getValue();

        // Your logic to log the activity goes here
    }
    
	@Override
	public void start(Stage stage) {
		try {
			// starting screen
			Parent root1 = FXMLLoader.load(getClass().getResource("/FXML_files/LoginPage.fxml"));
			Scene scene1 = new Scene(root1);
			stage.setScene(scene1);
			stage.setTitle("EffortLogger V2");
			stage.show();
			// Create buttons for each action
	        Button effortLogEditorButton = new Button("Effort Log Editor");
	        Button defectLogConsoleButton = new Button("Defect Log Console");
	        Button definitionsButton = new Button("Definitions");
	        Button effortDefectLogsButton = new Button("Effort and Defect Logs");

	        // Set button on action
	        effortLogEditorButton.setOnAction(event -> System.out.println("Effort Log Editor"));
	        defectLogConsoleButton.setOnAction(event -> System.out.println("Defect Log Console"));
	        definitionsButton.setOnAction(event -> System.out.println("Definitions"));
	        effortDefectLogsButton.setOnAction(event -> System.out.println("Effort and Defect Logs"));

	        // Add padding to buttons
	        effortLogEditorButton.setPadding(new Insets(10, 20, 10, 20));
	        defectLogConsoleButton.setPadding(new Insets(10, 20, 10, 20));
	        definitionsButton.setPadding(new Insets(10, 20, 10, 20));
	        effortDefectLogsButton.setPadding(new Insets(10, 20, 10, 20));

	        // Add buttons to a VBox layout
	        VBox vbox = new VBox(10);
	        vbox.setPadding(new Insets(20));
	        vbox.getChildren().addAll(effortLogEditorButton, defectLogConsoleButton, definitionsButton, effortDefectLogsButton);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
