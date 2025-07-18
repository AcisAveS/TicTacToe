package src.Utils;

import java.util.Arrays;

public class Patterns {

    private final byte patternsCoordinates[][] = { { 0, 3, 6 }, { 0, 1, 2 }, { 0, 2 } };
    private String player;
    private int[] pattern;

    public boolean checkPatterns(String[] cells) {
        boolean horizontalChecked = false;
        boolean verticalChecked = false;

        System.out.println("----------");
        for (byte pos[] : patternsCoordinates) {

            for (byte position : pos) {
                pattern = new int[] { -1, -1, -1 };
                byte i = 0;

                if (!horizontalChecked || !verticalChecked)
                    for (byte index = position; index < position
                            + (!horizontalChecked ? 3 : 7); index += (!horizontalChecked ? 1 : 3)) {
                        pattern[i] = (cells[index] == player ? index : -1);
                        i++;
                    }

                if (horizontalChecked && verticalChecked)
                    for (byte index = position; index <= (8 - position); index += (4 - position)) {
                        pattern[i] = (cells[index] == player ? index : -1);
                        i++;
                    }

                boolean patternComplete = Arrays.stream(pattern).filter(p -> p != -1).count() == 3;

                if (patternComplete) {
                    return true;
                }
            }

            if (horizontalChecked && !verticalChecked)
                verticalChecked = !verticalChecked;
            if (!horizontalChecked && !verticalChecked)
                horizontalChecked = !horizontalChecked;
        }
        return false;
    }

    public int[] getWinnerPattern() {
        return pattern;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

}
