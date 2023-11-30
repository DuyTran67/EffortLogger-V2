package application;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class DefinitionsController {
	@FXML
	private TextArea planArea, deliverableArea, defectCategoryArea, interruptionArea, stepArea;
	@FXML
	private Button updateButton;
	private ArrayList<String> plans = new ArrayList<>();
	private ArrayList<String> deliverables = new ArrayList<>();
	private ArrayList<String> interruptions = new ArrayList<>();
	private ArrayList<String> defectCategories = new ArrayList<>();
	private HashMap<Integer, String> steps = new HashMap<>();
	
	// This method updates all the data lists as the user enters or removes items
	public void update(ActionEvent event) {
		// Extract items from the text areas and add to the arraylists
		for (String line : planArea.getText().split("\\n")) {
			plans.add(line);
		}		
		for (String line : deliverableArea.getText().split("\\n")) {
			deliverables.add(line);
		}
		for (String line : interruptionArea.getText().split("\\n")) {
			interruptions.add(line);
		}
		for (String line : defectCategoryArea.getText().split("\\n")) {
			defectCategories.add(line);
		}
		
		// Add items from the life cycle step areas into a hashmap with their corresponding numerical index as keys
		int i = 1;
		for (String line : stepArea.getText().split("\\n")) {
			steps.put(i, line);
			i++;
		}
	}
	
	public ArrayList<String> getPlans() {
		return plans;
	}
	
	public ArrayList<String> getDeliverables() {
		return deliverables;
	}
	
	public ArrayList<String> getInterruptions() {
		return interruptions;
	}
	
	public ArrayList<String> getDefectCategories() {
		return defectCategories;
	}
	
	
}
