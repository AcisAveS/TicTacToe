package src.Test;

import java.util.Arrays;

import src.Utils.Patterns;

public class testPatterns {

    public static void main(String[] args) {
        Patterns pat = new Patterns();
        String[] topHorizontalXPattern = new String[] {
                "X", "X", "X",
                "O", "O", "X",
                "O", "X", "O"
        };

        String[] middleVerticalXPattern = new String[] {
                "O", "X", "O",
                "O", "X", "X",
                "X", "X", "O"
        };

        String[] diagonalOPattern = new String[] {
                "X", "X", "O",
                "X", "O", "O",
                "O", "X", "X"
        };

        pat.setPlayer("X");

        System.out.println(
                pat.checkPatterns(topHorizontalXPattern) + "\n pattern: " + Arrays.toString(pat.getWinnerPattern()));

        System.out.println(
                pat.checkPatterns(middleVerticalXPattern) + "\n pattern: " + Arrays.toString(pat.getWinnerPattern()));

        pat.setPlayer("O");
        System.out.println(
                pat.checkPatterns(diagonalOPattern) + "\n pattern: " + Arrays.toString(pat.getWinnerPattern()));

    }

}
