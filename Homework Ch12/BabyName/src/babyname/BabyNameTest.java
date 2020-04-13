/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/12/2020
 * Homework Ch. 12 – Baby name popularity ranking
 *
 * This program reads a file containing a list of baby names and their
 * popularity rankings, and stores the information into a container class.
 * The user can lookup names and rankings of names using the console menu.
 */

package babyname;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BabyNameTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // Names file path
        final String FILE_NAME = "babynamesrankings.txt";
        
        // Create a list for each gender
        ArrayList<BabyName> boyNames = new ArrayList();
        ArrayList<BabyName> girlNames = new ArrayList();
        
        // Open names file
        File namesFile = new File(FILE_NAME);
        try {
            // Create new scanner to read names file
            Scanner fileReader = new Scanner(namesFile);
            
            // Read each line of the file
            while (fileReader.hasNext()) {
                // Split fields by whitespace
                String[] nameFields = fileReader.nextLine().split("\\s+");
                
                // Set default list to boyNames
                ArrayList<BabyName> babyNames = boyNames;
                
                // Change insertion to girlNames if female name
                if (nameFields[0].equals("Female")) {
                    babyNames = girlNames;
                }
                
                // Insert name into selected list
                babyNames.add(new BabyName(nameFields[2], nameFields[0], Integer.parseInt(nameFields[1]), Integer.parseInt(nameFields[3])));
                
            }
            
            // Close file scanner
            fileReader.close();
        }
        
        // File missing or invalid filename
        catch (FileNotFoundException error) {
            System.out.println("File not found!");
        }
        
        // Create Scanner to record user input
        Scanner inputObj = new Scanner(System.in);
        int option = -1;  // Menu option
        
        // Menu selection loop
        while (option != 3) {
            // Display Menu
            System.out.println("Main menu"
                             + "\n1: Look up a baby name"
                             + "\n2: List a baby name by rank"
                             + "\n3: Exit program");
            
            // Prompt user to select option
            System.out.print("\nEnter a choice: ");
            try {
                option = inputObj.nextInt();
            }
            // Set option to default if invalid option
            catch (InputMismatchException optionError) {
                option = -1;
            }
            inputObj.skip(".*");
            
            // Process user option
            switch (option) {
                // 1: Look up a baby name
                case 1:
                    // Prompt the user to enter baby name
                    System.out.print("\nEnter name to look up: ");
                    String searchName = inputObj.next();
                    inputObj.skip(".*");
                    
                    // Flag for name found
                    boolean nameFound = false;
                    
                    // Search for name in both gender lists
                    for (ArrayList<BabyName> genderList : new ArrayList[] {boyNames, girlNames}) {
                        
                        // Search for name in current gender list linearly
                        for (BabyName babyName : genderList) {
                            if (babyName.getName().toLowerCase().equals(searchName.toLowerCase())) {
                                // Set found flag
                                nameFound = true;
                                
                                // Display name details
                                System.out.println("\nName Found:\n" + babyName);
                                break;
                            }
                        }
                    }
                    
                    // Display error if name not found
                    if (!nameFound) {
                        System.out.println("Name not found");
                    }
                    
                    break;

                // 2: List a baby name by rank
                case 2:
                    // Prompt the user to enter baby name
                    System.out.print("\nEnter rank to look up: ");
                    try {
                        int searchRank = inputObj.nextInt();
                        
                        // Flag for rank found
                        boolean rankFound = false;
                    
                        // Search for name in both gender lists
                        for (ArrayList<BabyName> genderList : new ArrayList[] {boyNames, girlNames}) {

                            // Search for name in current gender list linearly
                            for (BabyName babyName : genderList) {
                                if (babyName.getRank() == searchRank) {
                                    // Set found flag
                                    rankFound = true;

                                    // Display name details
                                    System.out.println("\nName Found:\n" + babyName);
                                    break;
                                }
                            }
                        }

                        // Display error if rank not found
                        if (!rankFound) {
                            System.out.println("Invalid Rank: Possibly out of range");
                        }
                    }
                    // Display error if invalid input
                    catch (InputMismatchException rankError) {
                        System.out.println("Invalid Rank: Not a number");
                    }
                    inputObj.skip(".*");
                    
                    break;

                // 3: Exit program
                case 3:
                    // Do nothing
                    break;

                // Invalid Option
                default:
                    System.out.println("Invalid option. Please select "
                                       + "an option between 1 and 3.");
                    break;
            }
            
            // Display line break before resuming loop
            System.out.println("\n-----------------------------------------\n");
        }
        
        // Close input Scanner
        inputObj.close();
    }
    
}
