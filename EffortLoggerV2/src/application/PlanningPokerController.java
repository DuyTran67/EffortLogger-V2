package application;
/***** This is the controller class for the first screen of planning poker, where user can enter
 * display name, user stories, import historical data, see saved planning poker games, and start
 * a new game.
 * 
 * @author: Duy Tran
 * 
 */

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.Parent;

public class PlanningPokerController {
	@FXML
	private TextField displayNameField, gameNameField;
	@FXML
	private TextArea userStoriesText;
	@FXML
	private Button importButton, newGameButton, pastStoriesButton, startButton, shareButton;
	@FXML
	private Text userStoryText, selectedText, playerText;
	@FXML
	private ToggleButton card0, card1, card2, card3, card5, card8, card13, card21, card34, card55, card89; 

	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	private String displayName, gameName;
	private ArrayList<String> userStories = new ArrayList<>();
	
	private int index = 0;
	
	
	public void goToImportData(ActionEvent event) {
		
	}
	
	public void goToPastStories(ActionEvent event) {
		
	}
	
	public void goToNewGame(ActionEvent event) throws Exception {
		root = FXMLLoader.load(getClass().getResource("/FXML_files/PlanningPokerStart.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EffortLogger V2");
		stage.show();
	}
	
	@FXML
	public void startNewGame(ActionEvent event) {
		displayName = displayNameField.getText();
		gameName = gameNameField.getText();
		ArrayList<String> temp = new ArrayList<>();
		for (String line : userStoriesText.getText().split("\\n")) {
			temp.add(line);
		}
		userStories = temp;
		// Display an error if user leaves one of these fields empty
		if (displayName == null || gameName == null || userStories.get(0) == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Details");
            alert.setHeaderText(null);
            alert.setContentText("One or more fields are empty");
            alert.showAndWait();
		} else {	
			try {
				root = FXMLLoader.load(getClass().getResource("/planningpoker/PlanningPokerRound1.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("EffortLogger V2");
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startRound(ActionEvent event) {
		//userStoryText.setText(userStories.get(index));
		startButton.setOpacity(0);
		playerText.setText("admin");
		
	}
	
	public void chooseCard(ActionEvent event) {
		ToggleButton chosenCard = (ToggleButton) event.getSource();
		selectedText.setText("You have selected:" + chosenCard.getText());
		shareButton.setOpacity(1);
	}
	
	public void shareEstimate(ActionEvent event) {
		
	}
}
