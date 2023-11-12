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
	private Button logs_btn;
	@FXML
	private Button defect_btn;
	
	public void logs() {
		DefectLibrary library = DefectController.getLibrary();
		int num = library.getReports().size();
		Group_name.setText("");
		group_num.setText("");
		Project_name.setText("");
		defects.setText("");
		for(int i = 0; i<num; i++) {
			Project_name.setText(Project_name.getText() + library.getReports().get(i).getProject() + "\n");
			Group_name.setText(Group_name.getText() + library.getReports().get(i).getName() + "\n");
			group_num.setText(group_num.getText() + library.getReports().get(i).getNum() + "\n");
			defects.setText(defects.getText() + library.getReports().get(i).getReportContent() + "\n");
		}

	}
	public void defect() {
	    // get a handle to the stage
	    Stage stage = (Stage) defect_btn.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
}
