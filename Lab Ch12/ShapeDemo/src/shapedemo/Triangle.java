/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/04/2020
 * Homework Ch. 11 – Inheritance and Polymorphism
 *
 * This module contains the Triangle class
 */
package shapedemo;

/**
 * Triangle
 * 
 * This is a class that stores geometric data for a triangle, which includes
 * the length of 3 sides, its color, and whether or not the shape is filled
 */
public class Triangle extends GeometricObject{
    /** Lengths of the 3 sides */
    private double side1, side2, side3;
    
    /** Default constructor */
    public Triangle() {
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }
    
    /**
     * @param side1     Length of side1
     * @param side2     Length of side2
     * @param side3     Length of side3
     * @param color     Color of the Circle
     * @param filled    Filled state of the Circle
     * 
     * @throws IllegalTriangleException
     *                  Invalid triangle side length: one side longer than sum
     *                  of other two
     */
    public Triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalTriangleException {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            throw new IllegalTriangleException();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.setColor(color);
        this.setFilled(filled);
    }

    /**
     * @return      Length of side1
     */
    public double getSide1() {
        return this.side1;
    }

    /**
     * @return      Length of side2
     */
    public double getSide2() {
        return this.side2;
    }

    /**
     * @return      Length of side3
     */
    public double getSide3() {
        return this.side3;
    }

    /**
     * @return      Area of triangle
     */
    public double getArea() {
        double s = (this.side1 + this.side2 + this.side3) / 2;
        double area = Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
        return area;
    }

    /**
     * @return      Perimeter of triangle
     */
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle:\n" + super.toString() + "\nTriangle: side1 = "
               + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
    }
    
}
