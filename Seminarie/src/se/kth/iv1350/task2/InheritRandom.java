package se.kth.iv1350.task2;
import java.util.Random;

/**
 * Class which inherits the Random class and overrides the nextInt method
 */
public class InheritRandom extends Random{
    /**
     * Constructor for the InheritRandom
     */
    public InheritRandom(){}

    /**
     * Method for generating an even random number based on the nextInt method from Random.
     * @param bond the upper bound (exclusive).  Must be positive.
     * @return The even random number
     */
    @Override
    public int nextInt(int bond) {
        int number = super.nextInt(bond);
        if (number % 2 == 0){
            return number;
        } else{
            return number+1;
        }

    }
}
