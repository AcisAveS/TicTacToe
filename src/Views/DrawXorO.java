package src.Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.UIManager;
import src.Controllers.LocalGame;

public class DrawXorO extends JLabel implements MouseListener {
    private LocalGame localGame;

    DrawXorO(byte cellNumber) {
        int LineWeight = 3;
        int drawBottomBorder = cellNumber < 6 ? LineWeight : 0;
        int drawRightBorder = (cellNumber + 1) % 3 == 0 ? 0 : LineWeight;

        setFont(new Font("Arial", Font.BOLD, 80));
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createMatteBorder(0, 0, drawBottomBorder, drawRightBorder, Color.BLACK));
        addMouseListener(this);
    }

    public DrawXorO(byte cellNumber, LocalGame localGame) {
        this(cellNumber);
        this.localGame = localGame;
    }

    private void mouseLocalClickedEvent(MouseEvent e) {
        setText(localGame.getPlayerTurn());
        UIManager.put("Label.disabledForeground",
                (this.getText().equals("X") ? java.awt.Color.RED : java.awt.Color.BLUE));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isEnabled() && localGame.isEnabled())
            mouseLocalClickedEvent(e);
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

}
