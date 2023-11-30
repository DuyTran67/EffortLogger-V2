package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditorController extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("EffortLogEditor.fxml"));
            
            // Set the title of the window
            primaryStage.setTitle("Effort Log Editor");

            // Set the scene to the stage with the specified dimensions
            primaryStage.setScene(new Scene(root, 822, 536)); // Width and Height of the window

            // Display the stage
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
