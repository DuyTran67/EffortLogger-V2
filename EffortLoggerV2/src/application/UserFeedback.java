package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UserFeedback extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EffortLogger Risk Reduction Prototype: Feedback Submission and Reporting");

        // Create a VBox to hold UI elements
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Create a TextArea for feedback submission
        TextArea feedbackTextArea = new TextArea();
        feedbackTextArea.setPromptText("Enter your feedback here");
        feedbackTextArea.setPrefHeight(100);

        // Create a button to submit feedback
        Button submitFeedbackButton = new Button("Submit Feedback");

        // Handle feedback submission
        submitFeedbackButton.setOnAction(e -> {
            String feedback = feedbackTextArea.getText();
            if (!feedback.isEmpty()) {
                // Implement logic to store or process the feedback
                // For simplicity, just print the feedback
                System.out.println("Feedback submitted: " + feedback);
                // You can store the feedback in a data structure or send it to a server.
                // For reporting purposes, you can aggregate and display feedback as needed.
            }
        });

        // Create a TextArea for feedback reporting
        TextArea feedbackReportTextArea = new TextArea();
        feedbackReportTextArea.setEditable(false);
        feedbackReportTextArea.setPrefHeight(200);

        // Create a Label for the feedback report
        Label feedbackReportLabel = new Label("Feedback Report:");

        // Add UI elements to the root layout
        root.getChildren().addAll(feedbackTextArea, submitFeedbackButton, feedbackReportLabel, feedbackReportTextArea);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
