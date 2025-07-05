package src.Views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

public class Window extends javax.swing.JFrame {

    private boolean localGame = false;
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
        ArrayList<DrawXorO> draw = new ArrayList<DrawXorO>();
        String playerStart = (Math.random() * 100) % 2 == 0 ? "cross" : "circle";
        JPanel box = new JPanel(new java.awt.GridLayout(3, 3));
        box.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        for (int pos = 0; pos < 9; pos++) {
            draw.add(new DrawXorO());
        }

        draw.forEach(label -> {
            label.setPlayer(playerStart);
            label.DrawBorders(draw.indexOf(label));
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
            localGame = true;
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