/*
 * Amos Cabudol
 * CIS 2571-004
 * 02/14/2020
 * Homework Ch. 5 Compare loans with various interest rates
 *
 * This program prompts the user to enter a loan amount and a loan period in
 * number of years. The program then displays a list of monthly and total
 * payments for each interest rate starting from 5% up to 10%, with an increment
 * of 0.25% between interest rates.
 * 
 */

package compareloans;

import java.util.Scanner;  // Scanner class

public class CompareLoans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare variables to store user input
        double loanAmount;
        int numberOfYears;
        
        // Create a scanner object to record user input
        Scanner inputObj = new Scanner(System.in);
        
        // Prompt the user to enter loan amount
        System.out.print("Loan Amount: ");
        loanAmount = inputObj.nextFloat();
        
        // Prompt the user to enter load period
        System.out.print("Number of years: ");
        numberOfYears = inputObj.nextInt();
        
        // Print list header
        System.out.println("\nInterest Rate \tMonthly Payment \tTotalPayment");
        
        // Count a list of interest rates from 5% to 10% at a 0.25% interval
        for (double interestRate = 5; interestRate <= 10; interestRate += .25) {
            // Calculate monthly interest rate
            double monthlyInterest = interestRate / 12 / 100;
            
            // Calculate the monthly payment for the current rate
            double monthlyPayment = (loanAmount * monthlyInterest) / (1 - (1 / Math.pow(1 + monthlyInterest, numberOfYears * 12)));
            
            // Calculate total payment
            double totalPayment = monthlyPayment * numberOfYears * 12;
            
            // Display the payments for the current interest rate
            System.out.printf("%.3f%%\t\t %.2f \t\t %.2f%n", interestRate, monthlyPayment, totalPayment);
        }
    }
    
}
