package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PPController {
	@FXML
	private Button EL_btn;
	@FXML
	private Button logs;
	@FXML
	private TextArea user_story;
	@FXML
	private ComboBox<String> projects, points, step, category;
	@FXML
	private Button add;
	@FXML
	private Button past_data, setup;
	@FXML
	private TextField keywords;
	@FXML
	private Label error;
	@FXML
	private AnchorPane screen;
	private int num = 0;
	private Scene scene;
	private Stage stage;
	
	private static PPLibrary library = new PPLibrary();
	
	//Sets the ComboBoxes
	public void set() {
		num += 1;
		if(num == 1) {
			projects.getItems().addAll("Project 1", "Project 2");
			points.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","20","25","30","40",
					"50","60","70","80","90","100");
			step.getItems().addAll("Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review",
					"Detailed Design Plan","Detailed Design/Prototype", "Detailed Design Review", "Implementation Plan", "Test Case Generation",
					"Solution Specification","Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update");
			category.getItems().addAll("Not specified", "Documentation", "Syntax","Build, Package", "Assignment", "Interface",
					"Checking", "Data", "Function","System", "Environment");
		}
	}
	//Closes the Window
	public void EL() throws IOException {
	    Stage stage1 = (Stage) EL_btn.getScene().getWindow();
	    // do what you have to do
	    stage1.close();
	}
	
	//Opens the Logs Page
	public void logs() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Logs_Page.fxml"));
		scene = new Scene(fxmlLoader.load());
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	
	//Opens the Past Data Page
	public void past() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PastData.fxml"));
		scene = new Scene(fxmlLoader.load());
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	
	//Adds a Planning Poker Report
	public void add() {
		String story = user_story.getText();
		if(story.isEmpty() == true) {
			//Creating needed variables
			error.setTextFill(Color.RED);
			error.setText("Enter a User Story");
		}else if(projects.getValue() ==null || points.getValue()==null || step.getValue() == null || category.getValue() == null || keywords.getText() == null) {
			error.setTextFill(Color.RED);
			error.setText("One of the categories is left empty");
		}else {
			error.setTextFill(Color.BLACK);
			error.setText("Submitted!");
			PPReport report = new PPReport(projects.getValue(),points.getValue(), user_story.getText(), step.getValue(), category.getValue(), keywords.getText());
			library.report(report);
			user_story.setText("");
			String[] parts = keywords.getText().split("\\, ");
			System.out.println(parts[0]);
			System.out.println(parts[1]);
		}
	}
	
	
	public static PPLibrary getLibrary() {
		return library;
	}
}
