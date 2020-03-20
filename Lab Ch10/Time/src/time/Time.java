/*
 * Amos Cabudol
 * CIS 2571-004
 * 03/20/2020
 * Homework Ch. 10 – The Time class
 *
 * This module contains the Time class
 */
package time;

public class Time {
    // Constants representing time units as milliseconds
    public static final long MINUTE_AS_MILLIS = 1000 * 60;
    public static final long HOUR_AS_MILLIS = MINUTE_AS_MILLIS * 60;
    public static final long DAY_AS_MILLIS = HOUR_AS_MILLIS * 24;
    
    // Time fields
    private long hour, minute, second;
    
    /**
     * Converts total time in milliseconds hour, minute, and second components
     * and sets these to the objects respective time fields 
     * 
     * @param elapseTime    total time in milliseconds
     */
    private void convertAndSetTime(long elapseTime) {
        // Get current day scope from total time
        long currentDayMillis = elapseTime % DAY_AS_MILLIS;
        
        // Calculate and set individual time components
        this.hour = currentDayMillis / HOUR_AS_MILLIS;
        this.minute = currentDayMillis / MINUTE_AS_MILLIS % 60;
        this.second = currentDayMillis / 1000 % 60;
    }
    
    /**
     * Default constructor
     */
    public Time() {
        this.convertAndSetTime(System.currentTimeMillis());
    }
    
    /**
     * @param elapseTime    total time in milliseconds
     */
    public Time(long elapseTime) {
        this.convertAndSetTime(elapseTime);
    }

    /**
     * @param hour    hours field of time
     * @param minute  minutes field of time
     * @param second  seconds field of time
     */
    public Time(long hour, long minute, long second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    /**
     * Copy constructor
     * 
     * @param source    time object to copy
     */
    public Time(Time source) {
        this.hour = source.hour;
        this.minute = source.minute;
        this.second = source.second;
    }

    // Getters
    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }
    
    /**
     * @param elapseTime    total time in milliseconds
     */
    public void setTime(long elapseTime) {
        this.convertAndSetTime(elapseTime);
    }

    /**
     * @return  time formatted as "HH:MM:SS"
     */
    @Override
    public String toString() {
        return String.format("%02d", hour) + ":"
               + String.format("%02d", minute) + ":"
               + String.format("%02d", second);
    }
}
