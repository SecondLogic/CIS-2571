/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/19/2020
 * Homework Ch. 13 – The Colorable Interface
 *
 * This program creates an array of 5 different geometric objects, displays
 * their areas, and displays how to color the object if it is colorable.
 */
package labch13;

public class Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an array of geometric objects
        GeometricObject[] shapes = {
            new Circle(4),
            new Rectangle(4, 2),
            new Rectangle(1, 3),
            new Square(4),
            new Square(2)
        };
        
        for (GeometricObject shape : shapes) {
            // Display shape area
            System.out.println("Area: " + shape.getArea());
            
            // If shape is colorable, display how to color
            if (shape instanceof Colorable)
                ((Colorable) shape).howToColor();
            
            // Print blank line
            System.out.println();
        }
    }
}
