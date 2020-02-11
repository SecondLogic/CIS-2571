/*
 * Amos Cabudol
 * CIS 2571-004
 * 02/10/2020
 * Homework Ch. 3 Compare Costs
 *
 * This compares the unit costs of two rice packages with different prices and
 * weights. The program asks the user to input the prices and costs of the two
 * rice packages and displays which package has the better (lower) price.
 *
 * The unit cost of a package of rice is price / weight
 */

package comparecosts;

import java.util.Scanner;  // Scanner class

public class CompareCosts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare variables for package weight, total cost, and unit cost
        double pkg1Weight, pkg1TotalCost, pkg1UnitCost, 
               pkg2Weight, pkg2TotalCost, pkg2UnitCost;
        
        // Create a Scanner object to record user input
        Scanner inputObj = new Scanner(System.in);
        
        // Prompt the user to enter details of package 1
        System.out.print("Enter the weight for package 1: ");
        pkg1Weight = inputObj.nextDouble();
        
        System.out.print("Enter the price for package 1: ");
        pkg1TotalCost = inputObj.nextDouble();
        
        // Prompt the user to enter details of package 2
        System.out.print("Enter the weight for package 2: ");
        pkg2Weight = inputObj.nextDouble();
        
        System.out.print("Enter the price for package 2: ");
        pkg2TotalCost = inputObj.nextDouble();
        
        // Calculate unit costs of the packages
        pkg1UnitCost = pkg1TotalCost / pkg1Weight;
        pkg2UnitCost = pkg2TotalCost / pkg2Weight;
        
        // Compare unit costs of the packages
        if (pkg1UnitCost == pkg2UnitCost)
            System.out.println("The two packages have the same price.");
        else if (pkg1UnitCost < pkg2UnitCost)
            System.out.println("Package 1 has a better price.");
        else
            System.out.println("Package 2 has a better price.");
    }
    
}
