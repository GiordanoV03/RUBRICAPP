package ui.modificaContattoPanels;

import controller.ModificaContattoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class BottomPanel extends JPanel {
    private final ModificaContattoController controller;

    public BottomPanel(ModificaContattoController controller) {
        this.controller = controller;
        setVisible(true);
        setLayout(new GridBagLayout());
        setBackground(new Color(0,0,0,0));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(125,10,85,10);
        add(new Button(controller), gbc);
    }

    private static class Button extends JButton {

        public Button(ModificaContattoController controller) {
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            if (controller.getContatto() != null)
                setIcon(icona("/salvaButton.png"));
            else
                setIcon(icona("/aggiungiButton.png"));
            setPreferredSize(new Dimension(700,100));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    SwingUtilities.getWindowAncestor(Button.this).repaint();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    SwingUtilities.getWindowAncestor(Button.this).repaint();
                }
            });
            addActionListener(e -> controller.salvaModifiche());
        }

        private ImageIcon icona(String path) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
            Image img = icon.getImage().getScaledInstance(700, 100, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }

    }

}