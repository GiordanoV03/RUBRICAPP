package ui.vediContattoPanels;

import controller.ContattoController;
import model.Contatto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class CenterPanel extends JPanel {

    public CenterPanel(ContattoController controller, Contatto contatto) {
        setVisible(true);
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0)); // Sfondo trasparente

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(new Titolo1(controller), gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(new BoxField1(controller, contatto), gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(new Titolo2(controller), gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(new BoxField2(controller, contatto), gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(new Titolo3(controller), gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(new BoxField3(controller, contatto), gbc);

        gbc.gridy = 6;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(new Modifica(controller), gbc);
    }


    private static class Titolo1 extends JLabel {
        public Titolo1(ContattoController controller) {
            setText("NOME");
            setHorizontalAlignment(JLabel.CENTER); // Allineamento a sinistra del testo
            setFont(new Font("Colette", Font.BOLD, 20));
            setForeground(Color.WHITE);
            setBackground(new Color(0, 0, 0, 25));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }
    }

    private static class Titolo2 extends JLabel {
        public Titolo2(ContattoController controller) {
            setText("COGNOME");
            setHorizontalAlignment(JLabel.CENTER); // Allineamento a sinistra del testo
            setFont(new Font("Colette", Font.BOLD, 20));
            setForeground(Color.WHITE);
            setBackground(new Color(0, 0, 0, 25));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }
    }

    private static class Titolo3 extends JLabel {
        public Titolo3(ContattoController controller) {
            setText("TAG");
            setHorizontalAlignment(JLabel.CENTER); // Allineamento a sinistra del testo
            setFont(new Font("Colette", Font.BOLD, 20));
            setForeground(Color.WHITE);
            setBackground(new Color(0, 0, 0, 25));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }
    }

    private static class BoxField1 extends JLabel {
        public BoxField1(ContattoController controller, Contatto contatto) {
            setText(contatto.getNome());
            setHorizontalAlignment(JLabel.LEFT); // Allineamento a sinistra del testo
            setFont(new Font("Colette", Font.BOLD, 30));
            setForeground(Color.BLACK);
            setBackground(Color.WHITE);
            setBorder(new LineBorder(Color.BLACK, 2));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }
    }

    private static class BoxField2 extends JLabel {
        public BoxField2(ContattoController controller, Contatto contatto) {
            setText(contatto.getCognome());
            setHorizontalAlignment(JLabel.LEFT); // Allineamento a sinistra del testo
            setFont(new Font("Colette", Font.BOLD, 30));
            setForeground(Color.BLACK);
            setBackground(Color.WHITE);
            setBorder(new LineBorder(Color.BLACK, 2));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }
    }

    private static class BoxField3 extends JLabel {
        public BoxField3(ContattoController controller, Contatto contatto) {
            setText(contatto.getTag());
            setHorizontalAlignment(JLabel.LEFT); // Allineamento a sinistra del testo
            setFont(new Font("Colette", Font.BOLD, 30));
            setForeground(Color.BLACK);
            setBackground(Color.WHITE);
            setBorder(new LineBorder(Color.BLACK, 2));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }
    }

    private static class Modifica extends JButton {
        private Modifica(ContattoController controller) {
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setIcon(icona("/modifcaVediContatto.png"));
            setPreferredSize(new Dimension(140, 140));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(icona("/modifcaVediContatto-shadow.png"));
                    SwingUtilities.getWindowAncestor(CenterPanel.Modifica.this).repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(icona("/modifcaVediContatto.png"));
                    SwingUtilities.getWindowAncestor(CenterPanel.Modifica.this).repaint();
                }
            });
            addActionListener(e -> controller.modifica());
        }
    }

    private static ImageIcon icona(String path) {
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(CenterPanel.class.getResource(path)));
        Image img = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
