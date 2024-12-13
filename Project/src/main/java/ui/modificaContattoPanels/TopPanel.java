package ui.modificaContattoPanels;

import controller.ModificaContattoController;
import ui.Finestra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class TopPanel extends JPanel {

    public TopPanel(ModificaContattoController controller) {
        setVisible(true);
        setLayout(new GridBagLayout());
        setBackground(new Color(0,0,0,0));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(30, 60, 30, 170);
        gbc.anchor = GridBagConstraints.WEST;
        add(new Annulla(controller), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.insets = new Insets(30, 0, 30, 230);
        gbc.anchor = GridBagConstraints.CENTER;
        add(new Titolo(controller), gbc);
    }

    private static class Titolo extends JLabel {
        private Titolo(ModificaContattoController controller) {
            if (controller.getContatto() == null)
                setText(" CREA UN NUOVO CONTATTO ");
            else
                setText(" MODIFICA IL CONTATTO ");
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Colette", Font.BOLD, 60));
            setForeground(Color.WHITE);
            setBackground(new Color(0,0,0,25));
            setOpaque(true);
            setPreferredSize(new Dimension(1320, 140));
        }
    }

    private static class Annulla extends JButton {
        private Annulla(ModificaContattoController controller) {
            setFocusPainted(false);
            setBorderPainted(false);
            setBackground(Color.WHITE);
            setIcon(icona("/annulla.png"));
            setPreferredSize(new Dimension(140, 140));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(icona("/annulla_hover.png"));
                    SwingUtilities.getWindowAncestor(Annulla.this).repaint();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(icona("/annulla.png"));
                    SwingUtilities.getWindowAncestor(Annulla.this).repaint();
                }
            });
            addActionListener(e -> {
                if (Finestra.chiediConferma("Vuoi annullare le modifiche?"))
                    controller.annulla();
            });
        }

        private ImageIcon icona(String path) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
            Image img = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
    }

}