package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class round1Controller {
	@FXML
	private Text userStoryText;
	
	public void startRound(ActionEvent event) {
		userStoryText.setText("AAAAA");
	}
	
	public void chooseCard(ActionEvent event) {
		
	}
}
