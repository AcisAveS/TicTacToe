package src.Utils;

import java.util.Arrays;

public class LocalGame {
    private String playerTurn;
    private boolean enabled;
    private String[] cells = new String[9];
    Patterns patterns;

    public LocalGame(String playerStart) {
        patterns = new Patterns();
        playerTurn = playerStart;
    }

    public void changePlayerTurn() {
        playerTurn = playerTurn == "cross" ? "circle" : "cross";
    }

    public String getPlayerTurn() {
        return playerTurn == "cross" ? "X" : "O";
    }

    public void updateGame(byte index, String player) {
        cells[index] = player;

    }

    public boolean isFull() {
        boolean full = Arrays.stream(cells)
                .map(cell -> cell)
                .filter(cell -> cell != null)
                .toArray(String[]::new).length == 9;

        return full;
    }

    public boolean isThereAWinner() {
        patterns.setPlayer(getPlayerTurn());
        return patterns.checkPatterns(cells);
    }

    public byte[] winnerPattern() {
        return patterns.getWinnerPattern();
    }

    public void restartGame() {
        Arrays.fill(cells, null);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
