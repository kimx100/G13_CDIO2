package src;

import java.util.Arrays;
import static java.lang.System.exit;

public class Test {
    public static void main(String[] args) {
       /**
        * Creating an array that can hold the amount of times each sum is being presented
        */
        int[] results = new int[13];
        int[] die;
        int numberOfTests = 1000;

        /**
         * Looping 1000 times to cast the dice and count the amount of times each sum is
         * being presented and the amount of times each die is being cast
         */
        for (int i = 0; i < numberOfTests; i++) {
            die = Dice.castDice();
            countDieOutput(die[0]);
            countDieOutput(die[1]);
            int sum = Dice.getSum();
            results[sum]++;
        }
        for (int i = 0; i < 6; i++) {
            System.out.println((i+1) + " was casted: " + dieCount[i] + " times");
        }
        System.out.println("Total amount of times the dice was casted: " + Arrays.stream(dieCount).sum());

        for (int i = 2; i <= 12; i++) {
            System.out.println("Sum " + i + ": " + results[i]); // prints the result of the amount of times each sum showed up
        }
    }

    private static final int[] dieCount = new int[6];

    private static void countDieOutput(int die) {
        if (die >= 1 && die <= 6) {
            dieCount[die - 1]++;
        } else {
            exit(1);
        }
    }

}

