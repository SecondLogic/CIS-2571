/*
 * Amos Cabudol
 * CIS 2571-004
 * 02/05/2020
 * Lab Ch. 5 Conversion from inch to centimeter
 *
 * This program displays a list of inch to centimeter conversions from 1 inch
 * to 10 inches.
 */

package lengthconversion;

public class LengthConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Print list header
        System.out.println("Inches\tCentimetres");
        
        // Loop through inch values 1 to 10
        for (double inchVal = 1; inchVal <=10; inchVal++) {
            // Display centimiter equivalent for current inch value
            System.out.println(inchVal + "\t" + inchVal * 2.54);
        }
    }
}
