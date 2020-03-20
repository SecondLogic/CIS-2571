/*
 * Amos Cabudol
 * CIS 2571-004
 * 03/20/2020
 * Homework Ch. 10 – ATM machine
 *
 * This program simulates an ATM by providing a console menu interface. The user
 * enters an ID from 0 to 9 and the program will give them the option to check
 * balance, withdraw, deposit, and exit to choose a different ID.
 */
package homeworkch10;

import java.util.Scanner;
import exercise09_07.Account;

public class HomeworkCh10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an array of ten accounts
        Account[] accounts = new Account[10];
        for (int accountID = 0; accountID <= 9; accountID++)
            accounts[accountID] = new Account(accountID, 100.0);
        
        // Create Scanner to record user input
        Scanner inputObj = new Scanner(System.in);
        
        int option = -1;  // Menu option
        int currentID;  // Account ID index
        
        // Account selection loop
        while (true) {
            // Prompt user to enter ID
            System.out.print("Enter an id: ");
            currentID = inputObj.nextInt();
            
            // Validate account with ID exists
            if (currentID >= 0 && currentID <= 9) {
                Account currentAccount = accounts[currentID];
                
                // Main menu loop
                while (option != 4) {
                    // Print main menu and prompt user for option
                    System.out.print("\nMain menu"
                                       + "\n1: check balance"
                                       + "\n2: withdraw"
                                       + "\n3: deposit"
                                       + "\n4: exit"
                                       + "\nEnter a choice: ");
                    option = inputObj.nextInt();
                    
                    // Process user option
                    switch (option) {
                        // 1: Check Balance
                        case 1:
                            System.out.println("The balance is " 
                                               + String.format("%.2f", 
                                               currentAccount.getBalance()));
                            break;
                        
                        // 2: Withdraw
                        case 2:
                            System.out.print("Enter an amount to withdraw: ");
                            double withdrawAmt = inputObj.nextDouble();
                            
                            // Check if balance is enough to withdraw
                            if (withdrawAmt <= currentAccount.getBalance())
                                currentAccount.withdraw(withdrawAmt);
                            else
                                System.out.println("Insufficient balance!");
                            break;
                        
                        // 3: Deposit 
                        case 3:
                            System.out.print("Enter an amount to deposit: ");
                            currentAccount.deposit(inputObj.nextDouble());
                            break;
                        
                        // 4: Exit
                        case 4:
                            System.out.println();
                            break;
                        
                        // Invalid Option
                        default:
                            System.out.println("Invalid option. Please select "
                                               + "an option between 1 and 4.");
                            break;
                    }
                }
            }
            // Entered account ID does not exist
            else {
                System.out.println("Account with id " + currentID 
                                   + " does not exist.\n");
            }
        }
    }
    
}
