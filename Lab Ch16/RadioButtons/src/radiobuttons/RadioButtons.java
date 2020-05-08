/*
 * Amos Cabudol
 * CIS 2571-004
 * 05/08/2020
 * Lab Ch. 16 – Lab Ch. 16 – Use radio buttons
 *
 * This application lets the user move the message displayed to the left or
 * right and lets them change the color of the message with the provided colors
 */
package radiobuttons;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderWidths;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
/**
 *
 * @author SLogic
 */
public class RadioButtons extends Application {
    /**
     * clamp
     * Clamps a value to a given upper and lower bound
     * 
     * @param value     value to clamp
     * @param min       lower bound
     * @param max       upper bound
     * @return          bounded value
     */
    private static double clamp(double value, double min, double max) {
        return Math.min(Math.max(min, value), max);
    }
    
    /**
     * moveText
     * Moves a text object deltaX units right and deltaY units down, bounded by
     * the size of the pane it is in
     * 
     * @param textObject    textObject to move
     * @param deltaX        amount to move the ball in the X axis
     * @param deltaY        amount to move the ball in the Y axis
     */
    private static void moveText(Text textObject, double deltaX, double deltaY) {
        // Get parent pane of text
        Pane bound = (Pane) textObject.parentProperty().getValue();
        
        // Move the button in the X direction
        textObject.setX(clamp(textObject.getX() + deltaX, 0, bound.getWidth() - textObject.getBoundsInLocal().getWidth()));
        
        // Move the ball in the Y direction
        textObject.setY(clamp(textObject.getY() + deltaY, textObject.getFont().getSize(), bound.getHeight()));
    }
    
    /**
     * createDirButton
     * Creates a button that will move the textObject in the given X and Y
     * amounts when clicked
     * 
     * @param textObject    text object to move
     * @param scene         scene in which the ball is bounded by
     * @param text          text displayed by the button
     * @param moveX         amount to move the ball in the X axis
     * @param moveY         amount to move the ball in the Y axis
     */
    private static Button createDirButton(Text textObject, String text, double moveX, double moveY) {
        // Create a button and assign text
        Button dirButton = new Button();
        dirButton.setText(text);
        
        // Set button size
        dirButton.setPrefSize(50, 20);
        
        // Move the ball in the given X and Y amounts when the button is clicked
        dirButton.setOnAction(e -> {
            moveText(textObject, moveX, moveY);
        });
        
        // Return button
        return dirButton;
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Define color options
        final String[] colorNames = {"Red", "Yellow", "Black", "Orange", "Green"};
        final Color[] colors = {Color.RED, Color.YELLOW, Color.BLACK, Color.ORANGE, Color.GREEN};
        
        // Create main pane and scene
        Pane mainPane = new Pane();
        
        // Set window size
        Scene scene = new Scene(mainPane, 350, 120);
        primaryStage.setMinHeight(scene.getHeight() + 40);
        primaryStage.setMinWidth(scene.getWidth() + 20);
        
        // Create top pane for color buttons
        HBox radioButtonPane = new HBox();
        radioButtonPane.setSpacing(8);
        radioButtonPane.setAlignment(Pos.CENTER);
        radioButtonPane.setPrefSize(scene.getWidth(), 20);
        
        // Create bottom pane for directional buttons
        HBox dirButtonFrame = new HBox();
        dirButtonFrame.setSpacing(5);
        dirButtonFrame.setAlignment(Pos.BOTTOM_CENTER);
        dirButtonFrame.setPadding(new Insets(0,4,4,4));
        dirButtonFrame.setPrefSize(scene.getWidth(), scene.getHeight());
        
        // Create output frame to bound output text
        Pane outputFrame = new Pane();
        outputFrame.setPrefSize(scene.getWidth(), scene.getHeight()-50);
        outputFrame.setLayoutX(2);
        outputFrame.setLayoutY(20);
        outputFrame.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        // Create output text to modify on runtime
        Text outputText = new Text("Programming is fun");
        outputText.setFont(new Font(20));
        outputText.setX(outputFrame.getPrefWidth()/2 - outputText.getBoundsInLocal().getWidth()/2);
        outputText.setY(outputFrame.getPrefHeight()/2 + outputText.getFont().getSize()/2);
        outputFrame.getChildren().add(outputText);
        
        // Resize panes to scene when window is resized
        scene.heightProperty().addListener((observable, oldHeight, newHeight) -> {
            double newSceneHeight = (double) newHeight;
            dirButtonFrame.setPrefHeight(newSceneHeight);
            outputFrame.setPrefHeight(newSceneHeight-50);
            outputText.setY((newSceneHeight - 50)/2  + outputText.getFont().getSize()/2);
        });
        scene.widthProperty().addListener((observable, oldWidth, newWidth) -> {
            double newSceneWidth = (double) newWidth;
            radioButtonPane.setPrefWidth(newSceneWidth);
            dirButtonFrame.setPrefWidth(newSceneWidth);
            outputFrame.setPrefWidth(newSceneWidth - 4);
            outputText.setX(clamp(outputText.getX(), 0, newSceneWidth - 4 - outputText.getBoundsInLocal().getWidth()));
        });
        
        // Create group for color radio buttons
        ToggleGroup colorRadioGroup = new ToggleGroup();
        
        // Create radio buttons for each color
        for (int colorIndex = 0; colorIndex < colorNames.length; colorIndex++) {
            RadioButton rBtnColor = new RadioButton();
            rBtnColor.setText(colorNames[colorIndex]);
            rBtnColor.setToggleGroup(colorRadioGroup);
            
            // Change the output text color when color button is selected
            final Color currentColor = colors[colorIndex];
            rBtnColor.setOnAction(e -> {
                outputText.setFill(currentColor);
            });
            
            // Add radio button to color frame
            radioButtonPane.getChildren().add(rBtnColor);
        }
        
        // Create directional buttons to move text left and right
        dirButtonFrame.getChildren().addAll(
            createDirButton(outputText, "<=", -10, 0),
            createDirButton(outputText, "=>", 10, 0)
        );
        
        // Add frames to main frame
        mainPane.getChildren().addAll(dirButtonFrame, radioButtonPane, outputFrame);
        
        // Make stage visible
        primaryStage.setTitle("Radio Buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
