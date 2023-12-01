package application;

import java.awt.event.ActionEvent;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class DefectController {
	//By Easton 
	@FXML 
	private Button Submit_btn;
	@FXML 
	private Button EL_btn;
	@FXML
	private Button log_btn;
	@FXML 
	private TextArea defect_description;
	@FXML 
	private ComboBox<String> Projects, group_name, group_num;
	@FXML 
	private TextField keywords;
	//@FXML
	//private Button start_btn;
	@FXML
	private Label Char_text;
	@FXML 
	private Label error_txt;
	@FXML
	private ComboBox<String> step;
	@FXML
	private ComboBox<String> category;
	@FXML
	private AnchorPane screen;
	private Scene scene;
	private Stage stage;
	private int enter = 0;
	
	private static DefectLibrary library = new DefectLibrary();
	
	//Sets Combo boxes
	//Later on it will be specific to what projects the user has access to 
	public void setProjects() {
		Projects.getItems().addAll("Project 1", "Project 2");
	}
	
	public void setName() {
		group_name.getItems().addAll("Engineer", "Developer", "Supervisor");
	}
	
	public void setNum() {
		group_num.getItems().addAll("1","2","3","4","5");
	}
	
	//Sets Combo Boxes
	public void button() {
		enter += 1;
		if(enter == 1) {
			setProjects();
			setName();
			setNum();
			step.getItems().addAll("Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review",
					"Detailed Design Plan","Detailed Design/Prototype", "Detailed Design Review", "Implementation Plan", "Test Case Generation",
					"Solution Specification","Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update");	
			category.getItems().addAll("Not specified", "10 Documentation", "20 Syntax","30 Build, Package", "40 Assignment", "50 Interface",
					"60 Checking", "70 Data", "80 Function","90 System", "100 Environment");
		}
	}
	
	//Works the Submit button
	public void submit() {
		Boolean test = chkDefect();
		if(test) {
			System.out.println("its fully working");
			DefectReport report = new DefectReport(Projects.getValue(),group_name.getValue(), group_num.getValue(), step.getValue(), category.getValue(), "56", defect_description.getText(), keywords.getText());
			library.submitDefectReport(report, group_num.getValue());
			System.out.println(library.getReports().get(0).getReportContent());
			defect_description.setText("");
		}
	}
	
	public static DefectLibrary getLibrary() {
		return library;
	}
	
	//Opens the Log Page
	public void log() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Logs_Page.fxml"));
		scene = new Scene(fxmlLoader.load());
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	
	//Closes the tab
	public void EL() {
	    Stage stage1 = (Stage) EL_btn.getScene().getWindow();
	    // do what you have to do
	    stage1.close();
	}
	//Checks all inputs in the defect report to see if everything is selected properly
	public Boolean chkDefect() {
		String defect = defect_description.getText();
		if(defect.isEmpty() == false) {
			//Creating needed variables
			String txt = defect;
			if(txt.length() > 500) {
				error_txt.setTextFill(Color.RED);
				error_txt.setText("Exceeded Character Limit of 500");
				Char_text.setTextFill(Color.RED);
				return false;
			}else {
				if(Projects.getValue() ==null || group_num.getValue()==null || group_name.getValue()==null || keywords.getText() == null) {
					error_txt.setTextFill(Color.RED);
					error_txt.setText("One of the categories is left empty");
					return false;
				}
				error_txt.setTextFill(Color.BLACK);
				error_txt.setText("Submitted!");
				return true;
			}
		}
		error_txt.setTextFill(Color.RED);
		error_txt.setText("The defect descirption is left empty");
		return false;
	}

}
