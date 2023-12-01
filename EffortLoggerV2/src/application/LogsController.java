import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogsController implements Initializable {
    @FXML
    private TableView<EffortLogs> effortTable;    
    @FXML
    private TableColumn<EffortLogs, String> projectCol;
    @FXML
    private TableColumn<EffortLogs, Timestamp> startCol;
    @FXML
    private TableColumn<EffortLogs, Timestamp> stopCol;
    @FXML
    private TableColumn<EffortLogs, String> stepCol;
    @FXML
    private TableColumn<EffortLogs, String> effortCategoryCol;
    @FXML
    private TableColumn<EffortLogs, String> deliverableCol;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
	    	Connection con = DBConnection.getConnection();
	        Statement statement = con.createStatement();
	        String query = "Select * FROM EFFORT_LOGS";
	        // Read data from the sql table to get effort log objects
	        ResultSet rst;
	        rst = statement.executeQuery(query);
	        ArrayList<EffortLogs> effortList = new ArrayList<>();
	        while(rst.next()) {
	        	EffortLogs effortLog = new EffortLogs(rst.getTimestamp("START_TIME"), rst.getTimestamp("STOP_TIME"), rst.getString("PROJECT_NAME"), rst.getString("LIFE_CYCLE_STEP"), rst.getString("EFFORT_CATEGORY"), rst.getString("DELIVERABLE"));
	        	effortList.add(effortLog);
	        }
	        // Add data to the table
	        ObservableList<EffortLogs> logs = FXCollections.observableArrayList(effortList);
	        projectCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("PROJECT_NAME"));
	        startCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,Timestamp>("START_TIME"));
	        stopCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,Timestamp>("STOP_TIME"));
	        stepCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("LIFE_CYCLE_STEP"));
	        effortCategoryCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("EFFORT_CATEGORY"));
	        deliverableCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("DELIVERABLE"));
	        effortTable.setItems(logs);
	        
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
    	
    }
}
