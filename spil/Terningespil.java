package spil;
import java.util.Random;

public class Terningespil {
    public static void main(String[] args) {
        int player1Score = 0;
        int player2Score = 0;
        boolean player1Turn = true;
        Random rand = new Random();

        while (true) {
            int die1 = rand.nextInt(6) + 1;
            int die2 = rand.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Player " + (player1Turn ? "1" : "2") + " rolls: " + die1 + " + " + die2 + " = " + sum);

            if (die1 == die2) {
                System.out.println("Player " + (player1Turn ? "1" : "2") + " rolls doubles!");
                if ((player1Turn && player1Score >= 40) || (!player1Turn && player2Score >= 40)) {
                    System.out.println("Player " + (player1Turn ? "1" : "2") + " wins with double " + die1);
                    break;
                } else {
                    // Include the extra turn score
                    if (player1Turn) {
                        player1Score += sum;
                    } else {
                        player2Score += sum;
                    }
                    continue;
                }
            }

            if (die1 == 1 && die2 == 1) {
                System.out.println("Player " + (player1Turn ? "1" : "2") + " loses all points!");
                if (player1Turn) {
                    player1Score = 0;
                } else {
                    player2Score = 0;
                }
            } else {
                if (player1Turn) {
                    player1Score += sum;
                } else {
                    player2Score += sum;
                }
            }

            System.out.println("Player 1 Score: " + player1Score);
            System.out.println("Player 2 Score: " + player2Score);

            if (player1Score >= 40 || player2Score >= 40) {
                if (die1 == die2) {
                    System.out.println("Player " + (player1Turn ? "1" : "2") + " wins with double " + die1);
                } else {
                    System.out.println("Player " + (player1Turn ? "1" : "2") + " needs to roll doubles to win!");
                }
            }
            
            // Player gets the next turn
            player1Turn = !player1Turn;
        }
    }
}