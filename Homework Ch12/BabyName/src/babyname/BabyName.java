/*
 * Amos Cabudol
 * CIS 2571-004
 * 04/12/2020
 * Homework Ch. 12 – Baby name popularity ranking
 *
 * This module contains the BabyName class
 */

package babyname;


/**
 * BabyName
 * 
 * This is a class that stores information about a baby name including its
 * gender, popularity rank, and number of babies born with this name within
 * the year
 */
public class BabyName extends Object {
    private final String name;  // Baby name
    private final String gender;  // Baby gender
    private final int rank;  // Name popularity rank
    private final int numberOfBirths;  // Number of babies born with this name
    
    /**
     * Construct a BabyName with the name, gender, rank, and number of births
     * @param name              Baby name
     * @param gender            Baby gender
     * @param rank              Name popularity rank
     * @param numberOfBirths    Number of babies born with this name
     */
    public BabyName(String name, String gender, int rank, int numberOfBirths) {
        this.name = name;
        this.gender = gender;
        this.rank = rank;
        this.numberOfBirths = numberOfBirths;
    }

    /**
     * @return      Baby name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return      Gender of baby
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return      Name popularity rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @return      Number of babies born with this name
     */
    public int getNumberOfBirths() {
        return numberOfBirths;
    }

    @Override
    public String toString() {
        return "Name:\t" + name 
               + "\nGender:\t" + gender 
               + "\nRank:\t" + rank 
               + "\nBirths:\t" + numberOfBirths;
    }
}
