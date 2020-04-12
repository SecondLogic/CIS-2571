/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/04/2020
 * Homework Ch. 11 – Inheritance and Polymorphism
 *
 * This is a driver program for GeometricObject subclasses that creates a list
 * of geometric objects and displays their details.
 */
package homeworkch11;

import java.util.ArrayList;
import java.util.Date;

public class HomeworkCh11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create list of objects
        ArrayList<Object> list = new ArrayList<Object>();
        
        // Add one of each type of object into list
        list.add(new Triangle());
        list.add(new String("String"));
        list.add(new Rectangle(2, 4, "red", false));
        list.add(new Date());
        list.add(new Circle(1.5, "green", true));
        
        // Print details of each object in the list
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).toString());
            // Display perimeter if object is a geometric object
            if (list.get(i) instanceof Circle) {
                System.out.println("Perimeter:"
                + ((Circle)list.get(i)).getPerimeter());
            }
            if (list.get(i) instanceof Rectangle) {
                System.out.println("Perimeter:"
                + ((Rectangle)list.get(i)).getPerimeter());
            }
            if (list.get(i) instanceof Triangle) {
                System.out.println("Perimeter:"
                + ((Triangle)list.get(i)).getPerimeter());
            }
            System.out.println(); //print blank line after each object
        }
    }
    
}
