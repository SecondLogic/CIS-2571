/*
 * Amos Cabudol
 * CIS 2571-004
 * 05/01/2020
 * Lab Ch. 15 – Move the ball
 *
 * This application lets the user move a ball in 4 directions by clicking on
 * the directional buttons.
 */
package movetheball;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MoveTheBall extends Application {
    
    /**
     * clamp
     * Clamps a value to a given upper and lower bound
     * 
     * @param value     value to clamp
     * @param min       lower bound
     * @param max       upper bound
     * @return          bounded value
     */
    private double clamp(double value, double min, double max) {
        return Math.min(Math.max(min, value), max);
    }
    
    /**
     * moveBall
     * Moves a ball deltaX units right and deltaY units down, bounded by the
     * size of the screen
     * 
     * @param ball      ball to move
     * @param scene     scene in which the ball is bounded by
     * @param deltaX    amount to move the ball in the X axis
     * @param deltaY    amount to move the ball in the Y axis
     */
    private void moveBall(Circle ball, Scene scene, double deltaX, double deltaY) {
        // Get the radius of the ball
        double radius = ball.getRadius();
        
        // Move the button in the X direction
        ball.setCenterX(clamp(ball.getCenterX() + deltaX, radius, scene.getWidth() - radius));
        
        // Move the ball in the Y direction
        ball.setCenterY(clamp(ball.getCenterY() + deltaY, radius, scene.getHeight() - radius));
    }
    
    /**
     * createDirButton
     * Creates a button that will move the ball in the given X and Y amounts
     * when clicked
     * 
     * @param ball      ball to move
     * @param scene     scene in which the ball is bounded by
     * @param text      text displayed by the button
     * @param moveX    amount to move the ball in the X axis
     * @param moveY    amount to move the ball in the Y axis
     */
    private Button createDirButton(Circle ball, Scene scene, String text, double moveX, double moveY) {
        // Create a button and assign text
        Button dirButton = new Button();
        dirButton.setText(text);
        
        // Set button size
        dirButton.setPrefSize(50, 20);
        
        // Move the ball in the given X and Y amounts when the button is clicked
        dirButton.setOnAction((event) -> {
            moveBall(ball, scene, moveX, moveY);
        });
        
        // Return button
        return dirButton;
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Create main scene
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 250);
        
        // Create Ball
        Circle ball = new Circle(scene.getWidth()/2, scene.getHeight()/2, 15);
        
        // Create bottom pane for directional buttons
        HBox buttonFrame = new HBox();
        buttonFrame.setSpacing(5);
        buttonFrame.setAlignment(Pos.BOTTOM_CENTER);
        buttonFrame.setPrefSize(scene.getWidth(), scene.getHeight());
        
        // Create the 4 directional buttons
        Button btnRight = createDirButton(ball, scene, "Right", 10, 0);
        Button btnLeft = createDirButton(ball, scene, "Left", -10, 0);
        Button btnUp = createDirButton(ball, scene, "Up", 0, -10);
        Button btnDown = createDirButton(ball, scene, "Down", 0, 10);
        
        // Add the nodes to the panes
        buttonFrame.getChildren().addAll(btnLeft, btnRight, btnUp, btnDown);
        pane.getChildren().addAll(ball, buttonFrame);
        
        // Set scene and make stage visible
        primaryStage.setTitle("Move The Ball");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
