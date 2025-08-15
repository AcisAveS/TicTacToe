package src.Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LateralPane extends JPanel {
    private JLabel turnLabel;
    private JLabel crossPoints;
    private JLabel circlePoints;

    public LateralPane() {
        GridBagConstraints gbc = new GridBagConstraints();
        JButton menuButton = new JButton("Back to Menu");

        turnLabel = new JLabel("");
        crossPoints = new JLabel("0");
        circlePoints = new JLabel("0");

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(200, 500));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 2, 30, 0);
        add(new JLabel("Turn: "), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(turnLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(new JLabel("Scoreboard"), gbc);
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        add(new JLabel("X:"), gbc);
        gbc.gridy = 3;
        add(new JLabel("O:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.WEST;
        add(crossPoints, gbc);
        gbc.gridy = 3;
        add(circlePoints, gbc);

        gbc.gridx = 0;
        gbc.gridy = 42;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(80, 2, 0, 2);
        add(menuButton, gbc);

        for (Component component : getComponents()) {
            component.setFont(new Font("Arial", Font.BOLD, 20));
        }
    }

    public void updateGameTurn(String turn) {
        turnLabel.setText(turn);
        repaint();
        revalidate();
    }

    public void updateScoreBoard(String winner) {
        int score = winner == "X" ? Integer.parseInt(crossPoints.getText())
                : Integer.parseInt(circlePoints.getText());

        score++;
        if (winner == "X") {
            crossPoints.setText(Integer.toString(score));
        } else {
            circlePoints.setText(Integer.toString(score));
        }

        repaint();
        revalidate();
    }

}
