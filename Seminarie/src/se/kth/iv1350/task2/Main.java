package se.kth.iv1350.task2;

/**
 * This is the main class for the higher grade task 2.
 */
public class Main {

    /**
     * Main method which manages the lottery and instantiates the Random classes.
     * @param Args Arguments from terminal
     */
    public static void main(String[] Args){
        InheritRandom inheritRandom = new InheritRandom();
        CompositionRandom compositionRandom = new CompositionRandom();
        int bond = 21;

        System.out.println("This program generates two random even numbers between 0-20!");
        System.out.println("If they are equal you win the big prize! Good luck!");

        int numberOne = inheritRandom.nextInt(20);
        int numberTwo = compositionRandom.nextInt(20);

        System.out.println("The first number from inheritRandom is: " + numberOne);
        System.out.println("The second number from compositionRandom is: " + numberTwo);

        if (numberOne == numberTwo){
            System.out.println("You won the big prize. We will mail it to you in 2 years.");

        } else{
            System.out.println("Sorry sorry! Try again!");

        }


    }

}
