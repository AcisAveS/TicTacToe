package src.Test;

import java.util.Arrays;
import java.util.Scanner;

import src.Utils.LocalGame;

public class testLocalGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playerStarts = "O";
        String tictactoe[] = new String[9];
        LocalGame localGame = new LocalGame(playerStarts);
        boolean winner = false;
        boolean full = false;
        String playAgain = "";
        byte i = 0;

        do {
            localGame.restartGame();
            Arrays.fill(tictactoe, null);

            while (!winner) {
                System.out.print("\nPlayer " + localGame.getPlayerTurn() + " select your position [0 - 8]: ");
                i = scan.nextByte();

                if (i < 9) {
                    tictactoe[i] = localGame.getPlayerTurn();
                    localGame.updateGame(i, localGame.getPlayerTurn());
                    localGame.isFull();
                    winner = localGame.isThereAWinner();
                    full = localGame.isFull();

                    showGame(tictactoe);

                    if (full || winner)
                        break;

                    localGame.changePlayerTurn();
                } else {
                    System.out.println("Invalid position!");
                }
            }

            if (winner)
                System.out.println(
                        "The Winner is " + localGame.getPlayerTurn() + " with the pattern "
                                + Arrays.toString(localGame.winnerPattern()));

            if (full && !winner)
                System.out.println("No more patterns possibles.");

            scan.nextLine();
            System.out.println("Do you wanna play again? [Yes/No]");
            playAgain = scan.nextLine();

            winner = false;
            full = false;

        } while (playAgain.toLowerCase().equals("yes"));

        scan.close();
    }

    private static void showGame(String[] game) {

        System.out.print("\n[ ");
        for (int i = 0; i < 9; i++) {
            System.out
                    .print((game[i] != null ? game[i] : " ") +
                            ((i + 1) % 3 == 0 ? (i + 1 == 9) ? "]" : "\n " : ", "));
        }
        System.out.println("\n");
    }
}
