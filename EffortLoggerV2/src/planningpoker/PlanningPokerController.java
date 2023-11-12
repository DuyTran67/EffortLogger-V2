package planningpoker;
/***** This is the controller class for the first screen of planning poker, where user can enter
 * display name, user stories, import historical data, see saved planning poker games, and start
 * a new game.
 * 
 * @author: Duy Tran
 * 
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.*;

public class PlanningPokerController {
	@FXML
	private String displayNameField;
	@FXML
	private TextArea userStoriesText;
	@FXML
	private Button importButton, savedGamesButton, newGameButton;
	
	public void importFile(ActionEvent event) {
		
	}
	
	public void savedGames(ActionEvent event) {
		
	}
	
	public void startNewGame(ActionEvent event) {
		
	}
}
