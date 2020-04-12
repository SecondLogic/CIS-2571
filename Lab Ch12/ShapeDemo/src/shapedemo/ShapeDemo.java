/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/12/2020
 * Lab Ch. 12 – IllegalTriangleException
 *
 * This program will create at least one triangle object and attempt to create 
 * a triangle that will cause the triangle exception, IllegalTriangleException, 
 * to be thrown. 
 * 
 * The exception will be handled in a try and catch block.
 */

package shapedemo;

public class ShapeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Make a valid triangle
        try {
            Triangle goodTriangle = new Triangle(1, 1, 1, "Green", true);
            System.out.println("Good triangle");
        }
        catch(IllegalTriangleException itException) {
            System.out.println("Invalid side length");
        }
        
        // Make an invalid triangle
        try {
            Triangle badTriangle = new Triangle(1, 1, 4, "Green", true);
            System.out.println("Good triangle");
        }
        catch(IllegalTriangleException itException) {
            System.out.println("Bad Triangle: Invalid side length");
        }
    }
    
}
