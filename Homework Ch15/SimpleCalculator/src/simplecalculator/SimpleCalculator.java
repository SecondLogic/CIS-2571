/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class SimpleCalculator extends Application {
    /**
     * getTextFieldNumber
     * Converts a TextField text property to a numeric value and returns the
     * converted Value. Text defaults to 0 if text value is not a valid number.
     * 
     * @param textField     TextField containing text value to be converted to
     *                      numeric value.
     * @return              Numeric value converted from text value. Defaults
     *                      text to 0 if text is not a valid number
     */
    private double getTextFieldNumber(TextField textField) {
        try {
            return Double.parseDouble(textField.getText());
        }
        catch (NumberFormatException numException) {
            textField.setText("0");
            return 0;
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Create main pane and scene
        Pane mainPane = new Pane();
        
        // Set window size
        Scene scene = new Scene(mainPane, 360, 70);
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(scene.getHeight() + 40);
        primaryStage.setMinWidth(scene.getWidth() + 20);
        
        // Create top pane for number input and output
        HBox numberFrame = new HBox();
        numberFrame.setSpacing(5);
        numberFrame.setLayoutY(5);
        numberFrame.setAlignment(Pos.CENTER);
        numberFrame.setPadding(new Insets(0,4,0,4));
        numberFrame.setPrefSize(scene.getWidth(), 20);
        
        // Create bottom pane for directional buttons
        HBox buttonFrame = new HBox();
        buttonFrame.setSpacing(5);
        buttonFrame.setAlignment(Pos.BOTTOM_CENTER);
        buttonFrame.setPadding(new Insets(0,4,4,4));
        buttonFrame.setPrefSize(scene.getWidth(), scene.getHeight());
        
        // Resize panes to scene when window is resized
        scene.heightProperty().addListener((observable, oldHeight, newHeight) -> {
            buttonFrame.setPrefHeight((double) newHeight);
        });
        scene.widthProperty().addListener((observable, oldWidth, newWidth) -> {
            numberFrame.setPrefWidth((double) newWidth);
            buttonFrame.setPrefWidth((double) newWidth);
        });
        
        // Set default font
        Font labelFont = new Font(14);
        
        // Create labelled text field for number 1 input
        Text number1Label = new Text("Number1:");
        number1Label.setFont(labelFont);
        TextField number1 = new TextField("0");
        number1.setPrefWidth(500);
        
        // Validate changes in text input to make sure text is a number
        number1.focusedProperty().addListener((observable, oldFocused, newFocused) -> {
            if (newFocused == false)
                getTextFieldNumber(number1);
        });
        
        // Create labelled text field for number 2 input
        Text number2Label = new Text("Number2:");
        number2Label.setFont(labelFont);
        TextField number2 = new TextField("0");
        number2.setPrefWidth(500);
        
        // Validate changes in text input to make sure text is a number
        number2.focusedProperty().addListener((observable, oldFocused, newFocused) -> {
            if (newFocused == false)
                getTextFieldNumber(number2);
        });
        
        // Create labelled text field for result output
        Text resultLabel = new Text("Result:");
        resultLabel.setFont(labelFont);
        TextField result = new TextField();
        result.setPrefWidth(500);
        result.setEditable(false);
        
        // Create button for addition
        Button btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setFont(labelFont);
        btnAdd.setOnAction((event) -> {
            result.setText("" + (getTextFieldNumber(number1) + getTextFieldNumber(number2)));
        });
        
        // Create button for subtraction
        Button btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setFont(labelFont);
        btnSubtract.setOnAction((event) -> {
            result.setText("" + (getTextFieldNumber(number1) - getTextFieldNumber(number2)));
        });
        
        // Create button for multiplication
        Button btnMultiply = new Button();
        btnMultiply.setText("Multiply");
        btnMultiply.setFont(labelFont);
        btnMultiply.setOnAction((event) -> {
            result.setText("" + (getTextFieldNumber(number1) * getTextFieldNumber(number2)));
        });
        
        // Create button for division
        Button btnDivide = new Button();
        btnDivide.setText("Divide");
        btnDivide.setFont(labelFont);
        btnDivide.setOnAction((event) -> {
            // Handle divide by 0
            if (getTextFieldNumber(number2) != 0)
                result.setText("" + (getTextFieldNumber(number1) / getTextFieldNumber(number2)));
            else
                result.setText("Cannot divide by 0");
        });
        
        // Add input and output controls to number frame
        numberFrame.getChildren().addAll(number1Label, number1, number2Label, number2, resultLabel, result);
        
        // Add buttons to button frame
        buttonFrame.getChildren().addAll(btnAdd, btnSubtract, btnMultiply, btnDivide);
        
        // Add frames to main pane
        mainPane.getChildren().addAll(buttonFrame, numberFrame);
        
        // Make stage visible
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
