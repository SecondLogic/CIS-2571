/*
 * Amos Cabudol
 * CIS 2571-004
 * 02/05/2020
 * Homework Ch. 2 Computing BMI
 *
 * This program calculates and displays Body Mass Index (BMI) based on
 * height (inches) and weight (pounds) entered by the user.
 *
 * The formula for body mass index is weight / height ^ 2
 * Weight and height used in the formula are in metric (meters and kilograms)
 */

package computingbmi;

import java.util.Scanner;  // Scanner class

public class ComputingBMI {

    /**
     * @param args
     * Program entry point
     */
    public static void main(String[] args) {
        // Constants for metric unit conversions
        final double WEIGHT_LB_TO_KG = 0.45359237;
        final double HEIGHT_IN_TO_M = 0.0254;
        
        // Declare variables for the BMI formula
        double weight, height, bodyMassIndex;
        
        // Create a Scanner object to record user input
        Scanner inputObj = new Scanner(System.in);
        
        // Prompt the user to enter weight in pounds
        System.out.print("Enter weight in pounds: ");
        weight = inputObj.nextDouble();
        
        // Prompt the user to enter height in iniches
        System.out.print("Enter height in inches: ");
        height = inputObj.nextDouble();
        
        // Convert height and weight to metric
        weight *= WEIGHT_LB_TO_KG;
        height *= HEIGHT_IN_TO_M;
        
        // Calculate body mass index
        bodyMassIndex = weight / Math.pow(height, 2d);
        
        // Round body mass index 4 decimal places to the right
        bodyMassIndex = Math.round(bodyMassIndex * 10000d) / 10000d;
        
        // Display the result
        System.out.println("BMI is " + bodyMassIndex);
    }
    
}
