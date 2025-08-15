package src.Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SettingsPane extends JPanel {
    private int gamePort = 4123;
    private String symbol;

    SettingsPane() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Game Settings"));
        symbol = ((int) (Math.random() * 100) % 2 == 0) ? "cross" : "circle";

        GridBagConstraints gbc = new GridBagConstraints();
        JRadioButton randomRadioButton = new JRadioButton("Random Start");
        JRadioButton customRadioButton = new JRadioButton("Custom Start:");
        JTextField portTextField = new JTextField(String.valueOf(gamePort));
        ButtonGroup group = new ButtonGroup();
        JComboBox<String> selector = new JComboBox<String>(new String[] { "X", "O" });

        portTextField.setPreferredSize(new Dimension(80, 30));
        portTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char character = e.getKeyChar();
                if (!Character.isDigit(character) || portTextField.getText().length() > 4)
                    e.consume();

                gamePort = !portTextField.getText().isEmpty() ? Integer.parseInt(portTextField.getText()) : 0;
            }
        });

        selector.setEditable(false);
        selector.setBackground(Color.white);

        group.add(randomRadioButton);
        group.add(customRadioButton);

        randomRadioButton.setPreferredSize(new Dimension(110, 30));
        randomRadioButton.setSelected(true);
        randomRadioButton.addActionListener(e -> {
            
            if (getComponentCount() > 4)
                remove(getComponentCount() - 1);

            symbol = ((int) (Math.random() * 100) % 2 == 0) ? "cross" : "circle";
            
            repaint();
            revalidate();
        });

        customRadioButton.setPreferredSize(new Dimension(110, 30));
        customRadioButton.addActionListener(e -> {

            symbol = selector.getSelectedItem().toString() == "X" ? "cross" : "circle";

            gbc.gridx = 1;
            gbc.gridy = 1;
            add(selector, gbc);

            repaint();
            revalidate();
        });

        selector.addActionListener(e -> {
            symbol = selector.getSelectedItem().toString() == "X" ? "cross" : "circle";
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        add(randomRadioButton, gbc);

        gbc.gridy = 1;
        add(customRadioButton, gbc);

        gbc.gridy = 2;
        add(new JLabel("Port:"), gbc);

        gbc.gridx = 1;
        add(portTextField, gbc);
    }

    public int getGamePort() {
        return gamePort;
    }

    public String getSymbol() {
        return symbol;
    }
}