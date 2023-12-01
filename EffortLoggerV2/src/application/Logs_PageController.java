package application;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.text.LabelView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Logs_PageController {
	@FXML
	private TextArea name;
	@FXML
	private TextArea Group_name;
	@FXML
	private TextArea group_num;
	@FXML
	private TextArea Project_name;
	@FXML
	private TextArea defects;
	@FXML
	private TextArea step, category, words;
	@FXML
	private TextField keywords;
	@FXML
	private Button logs_btn;
	@FXML
	private ComboBox<String> projects;
	@FXML
	private Button defect_btn, setup;
	@FXML
	private AnchorPane screen;
	private int num = 0;
	
	public void logs() {
		DefectLibrary library = DefectController.getLibrary();
		int num = library.getReports().size();
		String p = projects.getValue();
		int exit = 0;
		Group_name.setText("");
		group_num.setText("");
		Project_name.setText("");
		defects.setText("");
		step.setText("");
		category.setText("");
		words.setText("");
		String[] text = keywords.getText().split("\\, ");
		for(int i = 0; i<num; i++) {
			exit = 0;
			String[] parts = library.getReports().get(i).getKey().split("\\, ");
			if(library.getReports().get(i).getProject() == "Project 2" && library.getReports().get(i).getProject() == p) {
				for(int j = 0; j < text.length; j++) {
					for(int k = 0; k < parts.length; k++) {
						if(text[j].compareTo(parts[k]) == 0 && exit == 0) {
							Project_name.setText(Project_name.getText() + library.getReports().get(i).getProject() + "\n");
							Group_name.setText(Group_name.getText() + library.getReports().get(i).getName() + "\n");
							group_num.setText(group_num.getText() + library.getReports().get(i).getNum() + "\n");
							defects.setText(defects.getText() + library.getReports().get(i).getReportContent() + "\n");
							step.setText(step.getText() + library.getReports().get(i).getStep() + "\n");
							category.setText(category.getText() + library.getReports().get(i).getCat() + "\n");
							words.setText(words.getText() + library.getReports().get(i).getKey() + "\n");
						}
					}
				}
			}else if (library.getReports().get(i).getProject() == p){
				for(int j = 0; j < text.length; j++) {
					for(int k = 0; k < parts.length; k++) {
						if(text[j].compareTo(parts[k]) == 0 && exit == 0) {
							Project_name.setText(library.getReports().get(i).getProject() + "\n" + Project_name.getText());
							Group_name.setText(library.getReports().get(i).getName() + "\n" + Group_name.getText());
							group_num.setText(library.getReports().get(i).getNum() + "\n" + group_num.getText());
							defects.setText(library.getReports().get(i).getReportContent() + "\n" + defects.getText());
							step.setText(library.getReports().get(i).getStep() + "\n" + step.getText());
							category.setText(library.getReports().get(i).getCat() + "\n" + category.getText());
							words.setText(library.getReports().get(i).getKey() + "\n" + words.getText());
						}
					}
				}
			}
			if(keywords.getText().isBlank()) {
				if(library.getReports().get(i).getProject() == "Project 2" && library.getReports().get(i).getProject() == p) {
								Project_name.setText(Project_name.getText() + library.getReports().get(i).getProject() + "\n");
								Group_name.setText(Group_name.getText() + library.getReports().get(i).getName() + "\n");
								group_num.setText(group_num.getText() + library.getReports().get(i).getNum() + "\n");
								defects.setText(defects.getText() + library.getReports().get(i).getReportContent() + "\n");
								step.setText(step.getText() + library.getReports().get(i).getStep() + "\n");
								category.setText(category.getText() + library.getReports().get(i).getCat() + "\n");
								words.setText(words.getText() + library.getReports().get(i).getKey() + "\n");
				}else if (library.getReports().get(i).getProject() == p){
								Project_name.setText(library.getReports().get(i).getProject() + "\n" + Project_name.getText());
								Group_name.setText(library.getReports().get(i).getName() + "\n" + Group_name.getText());
								group_num.setText(library.getReports().get(i).getNum() + "\n" + group_num.getText());
								defects.setText(library.getReports().get(i).getReportContent() + "\n" + defects.getText());
								step.setText(library.getReports().get(i).getStep() + "\n" + step.getText());
								category.setText(library.getReports().get(i).getCat() + "\n" + category.getText());
								words.setText(library.getReports().get(i).getKey() + "\n" + words.getText());
				}
			}
		}

	}
	
	public void setup() {
		num += 1;
		if(num == 1) {
			projects.getItems().addAll("Project 1", "Project 2");
		}
	}
	public void defect() {
	    // get a handle to the stage
	    Stage stage = (Stage) defect_btn.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
}
