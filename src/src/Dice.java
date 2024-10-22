package src;

public class Dice {
    private static int[] die = new int[2];

    public static int[] castDice() {
        die[0] = (int) (Math.random() * 6) + 1;
        die[1] = (int) (Math.random() * 6) + 1;
        return die;
    }
    public static int getSum() {
        return die[0] + die[1];
    }
    public static boolean isEns() {
        return die[0] == die[1];
    }
}
