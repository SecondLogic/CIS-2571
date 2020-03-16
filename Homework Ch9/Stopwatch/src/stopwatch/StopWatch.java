/*
 * Amos Cabudol
 * CIS 2571-004
 * 03/15/2020
 * Homework Ch. 9 – Stopwatch
 *
 * This module contains the StopWatch class
 */
package stopwatch;

/**
 * StopWatch
 * 
 * This is a class for a stopwatch that keeps track of start and end times and
 * can keep track of elapsed time
 */
public class StopWatch {
    private long startTime;  // Time when stopwatch was started in milliseconds
    private long endTime;  // Time when stopwatch was stopped in milliseconds
    
    
    /**
     * Default constructor
     * Initializes startTime to current time at instantiation
     */
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    /**
     * @return     startTime in milliseconds
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @return     endTime in milliseconds
     */
    public long getEndTime() {
        return endTime;
    }
    
    /**
     * Sets startTime to current time
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Sets stopTime to current time
     */
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    
    /**
     * @return  The time in milliseconds between when stopwatch was started 
     *          and ended or the time since the stopwatch was started if it has
     *          not been ended
     */
    public long getElamsedTime() {
        if (this.endTime > startTime)
            return endTime - startTime;
        else
            return System.currentTimeMillis() - startTime;
    }
}
