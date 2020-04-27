/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/26/2020
 * Lab Ch. 14 – Two circles and their distance
 *
 * This application creates a window and draws two randomly positioned
 * circles connected by a line. The distance between the two circles is
 * displayed on the line
 */
package twocircles;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class TwoCircles extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a layout and scene
        Pane pane = new Pane();
        ObservableList<Node> paneNodes = pane.getChildren();
        
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        
        // Generate random X and Y coordinates for the two circles
        final double c1X = Math.random() * scene.getHeight();
        final double c1Y = Math.random() * scene.getWidth();
        final double c2X = Math.random() * scene.getHeight();
        final double c2Y = Math.random() * scene.getWidth();
        
        // Draw two circles with the random coordinates
        Circle circle1 = new Circle(c1X, c1Y, 15);
        Circle circle2 = new Circle(c2X, c2Y, 15);
        paneNodes.add(circle1);
        paneNodes.add(circle2);
        
        // Draw a line connecting the two circles
        Line line = new Line(c1X, c1Y, c2X, c2Y);
        paneNodes.add(line);
        
        // Calculate and display the distance between the two circles
        double distance = Math.sqrt(Math.pow(c2X - c1X, 2) + Math.pow(c2Y - c1Y, 2));
        Text distanceText = new Text((c1X + c2X) / 2, (c1Y + c2Y) / 2, "" + distance);
        paneNodes.add(distanceText);
        
        // Display pane
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
