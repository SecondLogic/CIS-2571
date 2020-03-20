/*
 * Amos Cabudol
 * CIS 2571-004
 * 03/20/2020
 * Homework Ch. 10 – The Time class
 *
 * This is a driver program for the Time class that tests the 4 constructors
 * as well as the setTime() method and displays the times created.
 */
package time;

public class TimeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create 3 Time objects using three different constructors
        Time time1 = new Time();
        Time time2 = new Time(555550000);
        Time time3 = new Time(10, 19, 10);
        
        // Display the times
        System.out.println("Time 1: " + time1 
                           + "\nTime 2: " + time2 
                           + "\nTime 3: " + time3);
        
        // Set the third time object to a random time
        time3.setTime((long) (Math.random() * Time.DAY_AS_MILLIS));
        
        // Create and display fourth time object based on the third one
        Time time4 = new Time(time3);
        System.out.println("Time 4: " + time4);
    }
    
}
