package ui.vediContattoPanels.CenterPanels;

import controller.ContattoController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class RightPanel extends JPanel {
    private static final Insets insetTitolo = new Insets(20, 0, 20, 0);
    private static final Insets insetTesto = new Insets(20, 0, 20, 0);
    private static final Insets insetPulsante = new Insets(20, 20, 20, 0);

    public RightPanel(ContattoController controller) {
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = insetTitolo;
        add(new Titolo("TELEFONO 1"), gbc);

        gbc.gridx++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.TELEFONO, 0), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.insets = insetTitolo;
        add(new Titolo("TELEFONO 2"), gbc);

        gbc.gridx++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.TELEFONO, 1), gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.insets = insetTitolo;
        add(new Titolo("TELEFONO 3"), gbc);

        gbc.gridx++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.TELEFONO, 2), gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.insets = insetTitolo;
        add(new Titolo("EMAIL 1"), gbc);

        gbc.gridx++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.EMAIL, 0), gbc);

        gbc.gridx++;
        gbc.insets = insetPulsante;
        add(new Pulsante(controller, 0), gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.insets = insetTitolo;
        add(new Titolo("EMAIL 2"), gbc);

        gbc.gridx++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.EMAIL, 1), gbc);

        gbc.gridx++;
        gbc.insets = insetPulsante;
        add(new Pulsante(controller, 1), gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.insets = insetTitolo;
        add(new Titolo("EMAIL 3"), gbc);

        gbc.gridx++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.EMAIL, 2), gbc);

        gbc.gridx++;
        gbc.insets = insetPulsante;
        add(new Pulsante(controller, 2), gbc);

    }

    private static class Titolo extends JLabel {

        public Titolo(String testo) {
            super(testo);
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Colette", Font.BOLD, 20));
            setForeground(Color.WHITE);
            setBackground(new Color(0, 0, 0, 25));
            setOpaque(true);
            setPreferredSize(new Dimension(280, 40));
        }

    }

    private static class Testo extends JLabel {
        public static final int TELEFONO = 1;
        public static final int EMAIL = 2;

        public Testo(ContattoController controller, int dato, int i) {
            if (dato == TELEFONO) setText(controller.getContatto().getTelefono(i));
            if (dato == EMAIL) setText(controller.getContatto().getEmail(i));
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Colette", Font.BOLD, 24));
            setForeground(Color.BLACK);
            setBackground(new Color(211, 211, 211));
            setBorder(new LineBorder(Color.BLACK, 2));
            setOpaque(true);
            setPreferredSize(new Dimension(350, 40));
        }

    }

    private static class Pulsante extends JButton {
        private final String email;

        public Pulsante(ContattoController controller, int i) {
            email = controller.getContatto().getEmail(i);
            setBackground(Color.WHITE);
            setIcon(icona("/emailButton.png"));
            setPreferredSize(new Dimension(50, 50));
            setFocusPainted(false);
            setBorderPainted(false);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(icona("/emailButton_hover.png"));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(icona("/emailButton.png"));
                }
            });
            addActionListener(e -> controller.apriEmail(email));
        }

        private ImageIcon icona(String path) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(RightPanel.class.getResource(path)));
            Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }

    }

}
