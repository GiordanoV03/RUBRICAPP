package ui.vediContattoPanels;

import controller.ContattoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


public class TopPanel extends JPanel {

    public TopPanel(ContattoController controller) {
        setVisible(true);
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 30, 30, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(new Titolo(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 0, 30, 0);
        gbc.anchor = GridBagConstraints.WEST;
        add(new ui.vediContattoPanels.TopPanel.Indietro(controller), gbc);

    }

    private static class Titolo extends JLabel {
        private Titolo() {
            setText("VEDI IL CONTATTO");
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Colette", Font.BOLD, 60));
            setForeground(Color.WHITE);
            setBackground(new Color(0, 0, 0, 25));
            setOpaque(true);
            setPreferredSize(new Dimension(1320, 140));
        }
    }

    private static class Indietro extends JButton {
        private Indietro(ContattoController controller) {
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setIcon(icona("/indietro-.png"));
            setPreferredSize(new Dimension(140, 140));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(icona("/indietro-shadow.png"));
                    SwingUtilities.getWindowAncestor(ui.vediContattoPanels.TopPanel.Indietro.this).repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(icona("/indietro-.png"));
                    SwingUtilities.getWindowAncestor(ui.vediContattoPanels.TopPanel.Indietro.this).repaint();
                }
            });
            addActionListener(e -> controller.indietro());
        }
    }

    private static ImageIcon icona(String path) {
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(TopPanel.class.getResource(path)));
        Image img = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}