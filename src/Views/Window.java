package src.Views;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class Window extends javax.swing.JFrame {

    public Window() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        add(Box());
        setVisible(true);
    }

    private JPanel Box() {
        DrawXorO[] draw = new DrawXorO[10];
        JPanel box = new JPanel(new java.awt.GridLayout(3, 3));
        box.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        for (int pos = 0; pos < 9; pos++) {
            draw[pos] = new DrawXorO();
            draw[pos].DrawBorders(pos);
            box.add(draw[pos]);

        }

        return box;
    }
}