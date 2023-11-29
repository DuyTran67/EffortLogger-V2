package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PastDataController {
	@FXML 
	private Button back;
	@FXML 
	private Button setup, set;
	@FXML 
	private Button el_btn;
	@FXML 
	private TextArea projects, points, step, category, keywords;
	@FXML 
	private TextArea story;
	@FXML 
	private TextField word;
	@FXML
	private ComboBox<String> point_select;
	private Scene scene;
	
	//Sets up the ComboBox
	public void setup() {
		point_select.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","20","25","30","40",
				"50","60","70","80","90","100");
	}
	
	//Goes through updates the screen based on what the user inputs
	public void set() {
		String p = point_select.getValue();
		String[] text = word.getText().split("\\, ");
		System.out.println(text[0]);
		PPLibrary library = PPController.getLibrary();
		int num = library.getLibrary().size();
		projects.setText("");
		points.setText("");
		story.setText("");
		step.setText("");
		category.setText("");
		keywords.setText("");
		int exit = 0;
		for(int i = 0; i<num; i++) {
			String[] parts = library.getLibrary().get(i).getKey().split("\\, ");
			System.out.println(parts.length);
			exit = 0;
			if(library.getLibrary().get(i).getProject() == "Project 2" && library.getLibrary().get(i).getPoints() == p ) {
				for(int j = 0; j < text.length; j++) {
					for(int k = 0; k < parts.length; k++) {
						if(text[j].compareTo(parts[k]) == 0 && exit == 0) {
							projects.setText(projects.getText() + library.getLibrary().get(i).getProject() + "\n");
							points.setText(points.getText() + library.getLibrary().get(i).getPoints() + "\n");
							story.setText(story.getText() + library.getLibrary().get(i).getStory() + "\n");
							step.setText(step.getText() + library.getLibrary().get(i).getStep() + "\n");
							category.setText(category.getText() + library.getLibrary().get(i).getCat() + "\n");
							keywords.setText(keywords.getText() + library.getLibrary().get(i).getKey() + "\n");
							exit = 1;
							break;
						}
					}
				}
			}else if (library.getLibrary().get(i).getPoints() == p){
				for(int j = 0; j < text.length; j++) {
					for(int k = 0; k < parts.length; k++) {
						if(text[j].compareTo(parts[k]) == 0 && exit == 0) {
							projects.setText(library.getLibrary().get(i).getProject() + "\n" + projects.getText());
							points.setText(library.getLibrary().get(i).getPoints() + "\n" +points.getText());
							story.setText(library.getLibrary().get(i).getStory() + "\n" + story.getText());
							step.setText(library.getLibrary().get(i).getStep() + "\n" + step.getText());
							category.setText(library.getLibrary().get(i).getCat() + "\n" + category.getText());
							keywords.setText(library.getLibrary().get(i).getKey() + "\n" + keywords.getText());
							exit = 1;
							break;
						}
					}
				}
			}
		}
	}
	
	//Closes Window
	public void exit() {
	    Stage stage = (Stage) back.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	//Closes Window and Opens effortLogger
	public void EL() throws IOException {
	    Stage stage = (Stage) el_btn.getScene().getWindow();
	    // do what you have to do
	    stage.close();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EffortLoggerConsole.fxml"));
		scene = new Scene(fxmlLoader.load());
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	
}
