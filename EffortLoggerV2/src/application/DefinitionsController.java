package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class DefinitionsController {
	@FXML
	private TextArea testTextArea;
	@FXML
	private Button testButton;
	
	public void test() {
		ArrayList<String> test = new ArrayList<>();
		for (String line : testTextArea.getText().split("\\n")) {
			System.out.println(line);
			test.add(line);
		}
		
		for (String curr : test) {
			System.out.println(curr);
		}
	}
}
