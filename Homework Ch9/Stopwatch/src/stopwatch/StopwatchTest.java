/*
 * Amos Cabudol
 * CIS 2571-004
 * 03/15/2020
 * Homework Ch. 9 – Stopwatch
 *
 * This is a driver program for the StopWatch class that displays the amount
 * of time it takes to sort an array of 100000 random numbers.
 */
package stopwatch;

public class StopwatchTest {

    /** 
     * The method for sorting the numbers 
     *
     * @param list  The array of numbers to be sorted
     */
    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length; i++) {
            // Find the minimum in the list[i..list.length-1]
            double currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Size of array of random numbers to sort
        final int ARRAY_SIZE = 100000;
        
        // Instantiate stopwatch to record sort time
        StopWatch stopwatch = new StopWatch();
        
        // Create array of random numbers to sort
        System.out.println("Creating array of size " + ARRAY_SIZE);
        double[] numbers = new double[ARRAY_SIZE];
        for (int arrayIndex = 0; arrayIndex < ARRAY_SIZE; arrayIndex++) {
            numbers[arrayIndex] = Math.random();
        }
        
        // Start timer before sorting array
        System.out.println("Sorting array...");
        stopwatch.start();
        
        // Sort array using selection sort
        selectionSort(numbers);
        
        // Stop timer after sort has finished
        stopwatch.stop();
        
        // Display elapsed time
        System.out.println("\nSort finished\nElapsed time: " 
                           + stopwatch.getElamsedTime() / 1000f + " seconds");
    }
    
}
