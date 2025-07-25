package src.Views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private boolean multiplayerGame = false;

    public Window() {

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        add(Menu());
        setVisible(true);
    }

    private JPanel Box() {
        ArrayList<DrawXorO> draw = new ArrayList<DrawXorO>(9);
        JPanel box = new JPanel(new java.awt.GridLayout(3, 3));
        box.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        while (draw.size() < 9) {
            DrawXorO label = new DrawXorO((byte) draw.size(), localGame);
            draw.add(label);
        }

        draw.forEach(label -> {
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println(localGame.getPlayerTurn());
                    if (localGame.isEnabled() && label.isEnabled()) {

                        localGame.updateGame((byte) draw.indexOf(label), label.getText());

                        if (localGame.isThereAWinner() && !localGame.isFull())
                            for (Component component : box.getComponents())
                                component.setEnabled(false);

                        localGame.changePlayerTurn();
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
        JButton localButton = new JButton("Play Local");
        JButton onlineButton = new JButton("Play Online");
        GridBagConstraints gbc = new GridBagConstraints();

        localButton.setPreferredSize(new Dimension(200, 50));
        onlineButton.setPreferredSize(new Dimension(200, 50));

        localButton.addActionListener(e -> {
            localGame = new LocalGame(((int) (Math.random() * 100) % 2 == 0) ? "cross" : "circle");
            localGame.setEnabled(true);
            remove(menu);
            add(Box());
            repaint();
            revalidate();
        });

        onlineButton.addActionListener(e -> {
            multiplayerGame = true;
            remove(menu);
            add(Box());
            repaint();
            revalidate();
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0);
        menu.add(localButton, gbc);
        gbc.gridy = 1;
        menu.add(onlineButton, gbc);
        return menu;
    }
}