/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/18/2020
 * Lab Ch. 13 – Sum the areas of geometric objects
 *
 * This program creates a list of various geometric objects and displays the
 * of their areas.
 */
package labch13;

public class SumAreas {
    
    /**
     * sumOfAreas
     * This function accepts an array of geometric objects and returns the sum
     * of the areas of those objects
     * 
     * @param a     array of geometric objects to sum
     * @return      sum of areas of all geometric objects in the array
     */
    public static double sumArea(GeometricObject[] a) {
        double sumOfAreas = 0;
        
        for (GeometricObject shape : a) {
            sumOfAreas += shape.getArea();
        }
        
        return sumOfAreas;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Create a list of 4 geometric objects
        GeometricObject[] shapes = new GeometricObject[] {
            new Circle(5),
            new Circle(10),
            new Rectangle(4, 6),
            new Rectangle(3, 7)
        };
        
        // Calculate and display the sum of the areas of the objects
        System.out.println("Sum of Areas: " + sumArea(shapes));
    }
}
