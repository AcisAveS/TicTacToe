package src.Utils;

public class Patterns {

    private final byte patternsCoordinates[][] = { { 0, 3, 6 }, { 0, 1, 2 }, { 0, 2 } };
    private String player;
    private byte[] pattern;

    public boolean checkPatterns(String[] cells) {
        boolean horizontalChecked = false;
        boolean verticalChecked = false;

        for (byte pos[] : patternsCoordinates) {

            for (byte position : pos) {
                pattern = new byte[3];
                byte i = 0;
                byte counter = 0;

                if (!horizontalChecked || !verticalChecked)
                    for (byte index = position; index < position
                            + (!horizontalChecked ? 3 : 7); index += (!horizontalChecked ? 1 : 3)) {

                        counter = (byte) (cells[index] == player ? counter += 1 : counter + 0);
                        pattern[i] = index;
                        i++;
                    }

                if (horizontalChecked && verticalChecked)
                    for (byte index = position; index <= (8 - position); index += (4 - position)) {
                        counter = (byte) (cells[index] == player ? counter += 1 : counter + 0);
                        pattern[i] = index;
                        i++;
                    }

                if (counter == 3) {
                    return true;
                } else {
                    pattern = null;
                }
            }

            if (horizontalChecked && !verticalChecked)
                verticalChecked = !verticalChecked;
            if (!horizontalChecked && !verticalChecked)
                horizontalChecked = !horizontalChecked;
        }
        return false;
    }

    public byte[] getWinnerPattern() {
        return pattern;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

}
