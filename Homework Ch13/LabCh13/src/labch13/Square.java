/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/19/2020
 * Homework Ch. 13 – The Colorable Interface
 *
 * This module contains the Square class
 */
package labch13;

public class Square extends GeometricObject implements Colorable {
    private double side;  // Length of square side
    
    /**
     * Constructor with side length
     * 
     * @param side   Length of square side
     */
    public Square(double side) {
        this.side = side;
    }

    /**
     * Getter for square side length
     * 
     @return    Length of square side
     */
    public double getSide() {
        return side;
    }

    /**
     * Setter for square side length
     */
    public void setSide(double side) {
        this.side = side;
    }
    
    /**
     * Calculate and return area of square
     * 
     @return    Area of square
     */
    @Override
    public double getArea() {
        return side * side;
    }
    
    /**
     * Calculate and return perimeter of square
     * 
     @return    Perimeter of square
     */
    @Override
    public double getPerimeter() {
        return side * 4;
    }

    /**
     * Display how to color square
     */
    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
    
    @Override
    public String toString() {
        return "[Square] " + "side = " + side;
    }
}
