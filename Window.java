import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

public class Window extends javax.swing.JFrame {
    Window() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {
        Window frame = new Window();
    }

    JPanel Box() {
        JPanel box = new JPanel(new java.awt.GridLayout(3, 3));

        return box;
    }

}