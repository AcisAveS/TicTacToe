package src.Views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import src.Controllers.LocalGame;

public class Window extends javax.swing.JFrame {

    private LocalGame localGame;
    private LateralPane lateralPane;

    public Window() {

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new BorderLayout());
        setResizable(false);
        pack();
        add(Menu(), BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel Box() {
        ArrayList<DrawXorO> draw = new ArrayList<DrawXorO>(9);
        JPanel box = new JPanel(new java.awt.GridLayout(3, 3));
        box.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        box.setPreferredSize(new Dimension(500, 500));

        while (draw.size() < 9) {
            DrawXorO label = new DrawXorO((byte) draw.size(), localGame);
            draw.add(label);
        }

        draw.forEach(label -> {
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int confirm = 23;

                    if (localGame.isEnabled() && label.isEnabled()) {

                        localGame.updateGame((byte) draw.indexOf(label), label.getText());

                        if (localGame.isThereAWinner() && !localGame.isFull()) {
                            lateralPane.updateScoreBoard(localGame.getPlayerTurn());
                            for (Component component : box.getComponents())
                                component.setEnabled(false);
                            confirm = JOptionPane.showConfirmDialog(null,
                                    "The Winner is " + localGame.getPlayerTurn() + "." + "\nDo you wanna play again?",
                                    "Play again",
                                    JOptionPane.YES_NO_OPTION);

                        } else if (localGame.isFull()) {
                            confirm = JOptionPane.showConfirmDialog(null,
                                    "There are no more options to play.",
                                    "Play again",
                                    JOptionPane.YES_NO_OPTION);
                        }

                        if (confirm == JOptionPane.YES_OPTION) {
                            localGame.restartGame();
                            remove(box);
                            add(Box());
                            repaint();
                            revalidate();
                        }
                        localGame.changePlayerTurn();
                        lateralPane.updateGameTurn(localGame.getPlayerTurn());
                        label.setEnabled(false);
                    }
                }

            });
            box.add(label);
        });

        return box;
    }

    private JPanel Menu() {
        JPanel menu = new JPanel(new GridBagLayout());
        lateralPane = new LateralPane();
        JButton localButton = new JButton("Play Local");
        JButton onlineButton = new JButton("Host a game");
        JButton connectButton = new JButton("Connect to game");
        GridBagConstraints gbc = new GridBagConstraints();
        SettingsPane settings = new SettingsPane();

        menu.setPreferredSize(new Dimension(500, 500));

        localButton.setPreferredSize(new Dimension(200, 50));
        onlineButton.setPreferredSize(new Dimension(200, 50));
        connectButton.setPreferredSize(new Dimension(200, 50));

        setPreferredSize(new Dimension(700, 500));

        localButton.addActionListener(e -> {
            localGame = new LocalGame(settings.getSymbol());
            localGame.setEnabled(true);
            lateralPane.updateGameTurn(localGame.getPlayerTurn());
            remove(menu);
            add(Box(), BorderLayout.CENTER);
            add(lateralPane, BorderLayout.EAST);
            pack();
            repaint();
            revalidate();
        });

        onlineButton.addActionListener(e -> {
            remove(menu);
            add(Box(), BorderLayout.CENTER);
            add(lateralPane, BorderLayout.EAST);
            pack();
            repaint();
            revalidate();
        });

        connectButton.addActionListener(e -> {
            JOptionPane.showInputDialog(null, "Game IP connection:");
            pack();
            repaint();
            revalidate();
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0);
        menu.add(settings, gbc);
        gbc.gridy = 1;
        menu.add(localButton, gbc);
        gbc.gridy = 2;
        menu.add(onlineButton, gbc);
        gbc.gridy = 3;
        menu.add(connectButton, gbc);
        return menu;
    }
}