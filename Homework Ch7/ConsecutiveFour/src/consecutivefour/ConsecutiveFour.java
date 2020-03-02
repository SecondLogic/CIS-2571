/*
 * Amos Cabudol
 * CIS 2571-004
 * 03/02/2020
 * Homework Ch. Pattern recognition: consecutive four equal numbers
 *
 * This program promps the user to enter an array size and array values and
 * displays whether there are four consecutive equal numbers in the array
 * 
 */

package consecutivefour;

import java.util.Scanner;

public class ConsecutiveFour {
    /**
     * A function that accepts an integer array and returns whether it has
     * four consecutive equal values or not
     * 
     * @param values    integer array to check for consecutive values
     *
     * @return          true if array has four consecutive values and false
     *                  if not
    */
    public static boolean isConsecutiveFour(int[] values) {
        // Declare and initialize previous number to first value in array
        int previousValue = values[0];
        
        // Declare and initialize consecutive number  counter to 0
        int consecutiveCoutner = 0;
        
        // Analyze each value in array
        for (int currentValue : values) {
            // Is consecutive
            if (currentValue == previousValue) {
                consecutiveCoutner++;
                
                // Return true if consecutive counter reaches 4
                if (consecutiveCoutner >= 4)
                    return true;
            }
            // Is not consecutive
            else {
                consecutiveCoutner = 1;
                previousValue = currentValue;
            }
        }
        
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a scanner object to record user input
        Scanner inputObj = new Scanner(System.in);
        
        // Declare variable for array size
        final int arraySize;
        
        // Prompt user to enter number of values
        System.out.print("Enter the number of values: ");
        arraySize = inputObj.nextInt();
        
        // Create integer array with size that user entered
        int[] arrayToCheck = new int[arraySize];
        
        // Prompt user to enter values
        System.out.print("Enter the values: ");
        
        for (int valueIndex = 0; valueIndex < arraySize; valueIndex++)
            arrayToCheck[valueIndex] = inputObj.nextInt();
        
        // Determine whether array has four consecutive values
        if (isConsecutiveFour(arrayToCheck))
            System.out.println("The list has consecutive fours");
        else
            System.out.println("The list has no consecutive fours");
    }
    
}
