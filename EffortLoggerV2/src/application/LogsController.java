package application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class LogsController {
	@FXML
    private TextField numberField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField startTimeField;
    @FXML
    private TextField stopTimeField;
    @FXML
    private TextField timeDeltaField;
    @FXML
    private ChoiceBox<String> lifeCycleStepChoice;
    @FXML
    private ChoiceBox<String> categoryChoice;
    @FXML
    private TextArea deliverableTextArea;
    @FXML
    private TextField defectNumberField;
    @FXML
    private TextField defectNameField;
    @FXML
    private TextArea defectDetailTextArea;
    @FXML
    private CheckBox injectedCheckBox;
    @FXML
    private CheckBox removedCheckBox;
    @FXML
    private ChoiceBox<String> defectCategoryChoice;
    @FXML
    private ChoiceBox<String> defectStatusChoice;

    @FXML
    private void saveLog() {
        // Retrieve data from the input fields
        String number = numberField.getText();
        String date = datePicker.getValue().toString();
        String startTime = startTimeField.getText();
        String stopTime = stopTimeField.getText();
        String timeDelta = timeDeltaField.getText();
        String lifeCycleStep = lifeCycleStepChoice.getValue();
        String category = categoryChoice.getValue();
        String deliverable = deliverableTextArea.getText();
        String defectNumber = defectNumberField.getText();
        String defectName = defectNameField.getText();
        String defectDetail = defectDetailTextArea.getText();
        boolean isInjected = injectedCheckBox.isSelected();
        boolean isRemoved = removedCheckBox.isSelected();
        String defectCategory = defectCategoryChoice.getValue();
        String defectStatus = defectStatusChoice.getValue();

        // Process and store the data (not implemented here)

        // Clear the input fields
        clearFields();
    }

    private void clearFields() {
        numberField.clear();
        datePicker.setValue(null);
        startTimeField.clear();
        stopTimeField.clear();
        timeDeltaField.clear();
        lifeCycleStepChoice.setValue(null);
        categoryChoice.setValue(null);
        deliverableTextArea.clear();
        defectNumberField.clear();
        defectNameField.clear();
        defectDetailTextArea.clear();
        injectedCheckBox.setSelected(false);
        removedCheckBox.setSelected(false);
        defectCategoryChoice.setValue(null);
        defectStatusChoice.setValue(null);
    }
}
