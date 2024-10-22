package src;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
// hej med dig virker det her
public class Main {

    // Helper method for waiting for 'y' input with a customizable message
    public static boolean waitForYPress(java.util.Scanner scanner, String message) {
        System.out.println(message);
        return Objects.equals(scanner.nextLine(), "y");
    }

    public static void main(String[] args) {

        var scanner = new java.util.Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        boolean game_ended = false;
        Player player1 = new src.Player();
        System.out.println("Please enter the name of player 1");
        player1.SetName(scanner.nextLine());
        Player player2 = new Player();
        System.out.println("Please enter the name of player 2");
        player2.SetName(scanner.nextLine());
        Random random = new Random();
        int startingPlayer = random.nextInt(2);
        Player initialPlayer;
        Player otherPlayer;
        if (startingPlayer == 0) {
            initialPlayer = player1;
            otherPlayer = player2;
        } else {
            initialPlayer = player2;
            otherPlayer = player1;
        }
        System.out.println(initialPlayer.GetName() + " starts the game!");

        while (!game_ended) {
            System.out.println(initialPlayer.GetName() + "'s turn");

            // Use the helper function for 'y' press check
            waitForYPress(scanner, "please write 'y' if you want to throw dice");
            System.out.println(Arrays.toString(Dice.castDice()));

            initialPlayer.SetPoints(Dice.getSum());
            System.out.println(initialPlayer.GetName() + " now has: " + initialPlayer.GetPoints());
            while (Dice.isEns()) {               
                if (Dice.getSum() == 2) {
                    initialPlayer.SetPoints(-initialPlayer.GetPoints());
                    System.out.println("Oh no " + initialPlayer.GetName() + " has rolled two 1's and has lost all their points!");
                    break;
                }
                if (initialPlayer.hasWon()) {
                    break;
                }
                if (Dice.getSum() == 12) {
                    System.out.println(initialPlayer.GetName() + " has rolled two 6's and gets an extra turn!");
                    waitForYPress(scanner, "please write 'y' if you want to throw dice");
                    System.out.println(Arrays.toString(Dice.castDice()));
                    if (Dice.getSum() == 12) {
                        System.out.println(initialPlayer.GetName() + " has rolled two 6's again and wins the game!!!");
                        initialPlayer.SetPoints(40);
                        break;
                    }
                    initialPlayer.SetPoints(Dice.getSum());
                    System.out.println(initialPlayer.GetName() + " now has: " + initialPlayer.GetPoints());
                }
                else{
                    System.out.println(initialPlayer.GetName() + " has rolled two "+ Dice.getSum()/2 + "'s again and wins the game!!!");
                    System.out.println(initialPlayer.GetName() + "'s turn");

                    // Use the helper function for 'y' press check
                    waitForYPress(scanner, "please write 'y' if you want to throw dice");
                    System.out.println(Arrays.toString(Dice.castDice()));

                    initialPlayer.SetPoints(Dice.getSum());
                    System.out.println(initialPlayer.GetName() + " now has: " + initialPlayer.GetPoints());
                }
            }
            if (initialPlayer.hasWon() && Dice.isEns()) {
                System.out.println(initialPlayer.GetName() + " has won the game with " + initialPlayer.GetPoints() + " points.");
                System.out.println(otherPlayer.GetName() + " has " + otherPlayer.GetPoints() + " points.");

                // Use helper method for restart option
                if (waitForYPress(scanner, "If you want to restart, please write 'y', otherwise the game will end")) {
                    initialPlayer.SetPoints(-initialPlayer.GetPoints());
                    otherPlayer.SetPoints(-otherPlayer.GetPoints());
                    startingPlayer = random.nextInt(2);
                    if (startingPlayer == 0) {
                        initialPlayer = player1;
                        otherPlayer = player2;
                    } else {
                        initialPlayer = player2;
                        otherPlayer = player1;
                    }
                    System.out.println("The game has been restarted.");
                    System.out.println(initialPlayer.GetName() + " starts the game!");
                } else {
                    game_ended = true;
                    break;
                }
            } else {
                System.out.println(otherPlayer.GetName() + "'s turn");
                waitForYPress(scanner, "please write 'y' if you want to throw dice");
                System.out.println(Arrays.toString(Dice.castDice()));
                otherPlayer.SetPoints(Dice.getSum());
                System.out.println(otherPlayer.GetName() + " now has: " + otherPlayer.GetPoints());
            }
            while (Dice.isEns()) {                
                if (Dice.getSum() == 2) {
                    otherPlayer.SetPoints(-otherPlayer.GetPoints());
                    System.out.println("Oh no " + otherPlayer.GetName() + " has rolled two 1's and has lost all their points!");
                    break;
                }
                if (otherPlayer.hasWon()) {
                    break;
                }
                if (Dice.getSum() == 12) {                  
                    System.out.println(otherPlayer.GetName() + " has rolled two 6's and gets an extra turn!");
                    waitForYPress(scanner, "please write 'y' if you want to throw dice");
                    System.out.println(Arrays.toString(Dice.castDice()));
                    if (Dice.getSum() == 12) {
                        System.out.println(otherPlayer.GetName() + " has rolled two 6's again and wins the game!!!");
                        otherPlayer.SetPoints(40);
                        break;
                    }
                    otherPlayer.SetPoints(Dice.getSum());
                    System.out.println(otherPlayer.GetName() + " now has: " + otherPlayer.GetPoints());
                }
                else{
                    System.out.println(otherPlayer.GetName() + "'s turn");

                    // Use the helper function for 'y' press check
                    waitForYPress(scanner, "please write 'y' if you want to throw dice");
                    System.out.println(Arrays.toString(Dice.castDice()));

                    otherPlayer.SetPoints(Dice.getSum());
                    System.out.println(otherPlayer.GetName() + " now has: " + otherPlayer.GetPoints());
                }
            }
            if (otherPlayer.hasWon() && Dice.isEns()) {
                System.out.println(otherPlayer.GetName() + " has won the game with " + otherPlayer.GetPoints() + " points.");
                System.out.println(initialPlayer.GetName() + " has " + initialPlayer.GetPoints() + " points.");

                if (waitForYPress(scanner, "If you want to restart, please write 'y', otherwise the game will end")) {
                    initialPlayer.SetPoints(-initialPlayer.GetPoints());
                    otherPlayer.SetPoints(-otherPlayer.GetPoints());
                    startingPlayer = random.nextInt(2);
                    if (startingPlayer == 0) {
                        initialPlayer = player1;
                        otherPlayer = player2;
                    } else {
                        initialPlayer = player2;
                        otherPlayer = player1;
                    }
                    System.out.println("The game has been restarted.");
                    System.out.println(initialPlayer.GetName() + " starts the game!");
                } else {
                    game_ended = true;
                }
            }
        }

        System.out.println("The game has ended.");
        scanner.close();
    }
}
