/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/26/2020
 * Homework Ch. 14 – Display four cards
 * 
 * This application selects and displays a random card from each suit of a 52
 * card deck.
 */

package homework14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Homework14 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // My name is...
        String myName = "Amos";
        
        // Set number of suites
        final int NUMBER_OF_SUITS = 4;
        
        // Create a list to contain selected cards
        ArrayList<Image> randomHand = new ArrayList(NUMBER_OF_SUITS);
        
        // Randomly select a card from each suit and place card randomly on hand
        for (int currentSuit = 0; currentSuit < NUMBER_OF_SUITS; currentSuit++) {
            // Pick a random position for the current suit
            int cardIndex = (int)Math.round(Math.random() * randomHand.size());
            
            // Pick a random card from the current suit
            int pickedCard = (int)(Math.random() * 12) + 13 * currentSuit + 1;
            
            // Get the image for the selected card and add it to hand
            randomHand.add(cardIndex, new Image("images/" + pickedCard + ".png"));
        }
        
        // Layout grid
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        // Make cards visible on the pane
        randomHand.forEach(card -> pane.getChildren().add(new ImageView(card)));
        
        // Place pane on scene
        Scene scene = new Scene(pane);

        // Setup and show stage
        primaryStage.setTitle(myName + "'s Lab 14");
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
