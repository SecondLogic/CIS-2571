/*
 * Amos Cabudol
 * CIS 2571-004
 * 02/14/2020
 * Homework Ch. 4 Student major and status
 *
 * This program prompts the user to enter two characters indicating the user's
 * major and year. The characters are represented as follows:
 *     I: Information Management
 *     C: Computer Science
 *     A: Accounting
 *     1: Freshman
 *     2: Sophomore
 *     3: Junior
 *     4: Senior
 */

package studentmajor;

import java.util.Scanner;  // Scanner class

public class StudentMajor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare and initialize input error flag
        boolean inputError = false;
        
        // Declare and initialize input and output strings
        String inputString, outputString = "";
        
        // Create scanner object to receive user input
        Scanner inputObj = new Scanner(System.in);
        
        // Prompt user to enter two characters
        System.out.print("Enter two characters: ");
        inputString = inputObj.next().toUpperCase();
        
        // Read first character
        switch (inputString.charAt(0)) {
            case 'I':
                outputString += "Information Management";
                break;
            case 'C':
                outputString += "Computer Science";
                break;
            case 'A':
                outputString += "Accounting";
                break;
            
            // Invalid character
            default:
                inputError = true;
                outputString = "Invalid Input";
                break;
        }
        
        // Read second character if there is no error
        if (!inputError) {
            switch (inputString.charAt(1)) {
                case '1':
                    outputString += " Freshman";
                    break;
                case '2':
                    outputString += " Sophomore";
                    break;
                case '3':
                    outputString += " Junior";
                    break;
                case '4':
                    outputString += " Senior";
                    break;
                
                // Invalid character
                default:
                    outputString = "Invalid Input";
                    break;
            }
        }
        
        // Display the status according to the user's input
        System.out.println(outputString);
    }
    
}
