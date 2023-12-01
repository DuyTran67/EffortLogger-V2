package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogsController {
    @FXML
    private TableView<EffortLogs> effortTable;    
    @FXML
    private TableColumn<EffortLogs, String> projectCol, startCol, stopCol, stepCol, effortCategoryCol, deliverableCol;

    @FXML
    private TableView<DefectReport> defectTable;
    
    public void viewLogs(ActionEvent event) {
    	try {
	    	Connection con = DBConnection.getConnection();
	        Statement statement = con.createStatement();
	        String query = "Select * FROM EFFORT_LOGS";
	        // Read data from the sql table to get effort log objects
	        ResultSet rst;
	        rst = statement.executeQuery(query);
	        List<EffortLogs> effortList = new ArrayList<>();
	        while(rst.next()) {
	        	EffortLogs effortLog = new EffortLogs(rst.getString("PROJECT_NAME"), rst.getTimestamp("START_TIME"), rst.getTimestamp("END_TIME"), rst.getString("LIFE_CYCLE_STEP"), rst.getString("EFFORT_CATEGORY"), rst.getString("DELIVERABLE"));
	        	effortList.add(effortLog);
	        }
	        // Add data to the table
	        ObservableList<EffortLogs> logs = FXCollections.observableList(effortList);
	        projectCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("project"));
	        startCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("start"));
	        stopCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("stop"));
	        stepCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("step"));
	        effortCategoryCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("effort"));
	        deliverableCol.setCellValueFactory(new PropertyValueFactory<EffortLogs,String>("deliverable"));
	        effortTable.setItems(logs);
	        
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
}
