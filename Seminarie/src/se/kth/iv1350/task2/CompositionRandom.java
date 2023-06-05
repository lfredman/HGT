package se.kth.iv1350.task2;

import java.util.Random;

/**
 * Class which uses the Random class.
 */
public class CompositionRandom {
    private Random random;

    /**
     * Constructor which initializes the class and the Random class.
     */
    public CompositionRandom(){
        random = new Random();
    }
    /**
     * Method for generating an even random number based on the nextInt method from Random.
     * @param bond the upper bound (exclusive).  Must be positive.
     * @return The even random number
     */
    public int nextInt(int bond) {
        int number = this.random.nextInt(bond);
        if (number % 2 == 0){
            return number;
        } else{
            return number+1;
        }

    }
}
