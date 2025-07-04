package src.Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class DrawXorO extends JLabel implements MouseListener {

    private boolean playerX = false;
    private boolean playerO = false;

    DrawXorO() {
        setFont(new Font("Arial", Font.BOLD, 80));
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        addMouseListener(this);
    }

    public void DrawBorders(int cell) {
        int LineWeight = 3;
        int drawBottomBorder = cell < 6 ? LineWeight : 0;
        int drawRightBorder = (cell + 1) % 3 == 0 ? 0 : LineWeight;
        setBorder(BorderFactory.createMatteBorder(0, 0, drawBottomBorder, drawRightBorder, Color.BLACK));
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        setText(playerX ? "X" : "O");
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            setForeground(Color.RED);
        } else {
            setForeground(Color.RED);
        }
    }
}
