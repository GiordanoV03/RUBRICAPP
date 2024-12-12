package ui.vediContattoPanels.CenterPanels;

import controller.ContattoController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class LeftPanel extends JPanel {
    private static final Insets insetTitolo = new Insets(0, 0, 0, 0);
    private static final Insets insetTesto = new Insets(0, 0, 40, 0);
    private static final Insets insetPulsante = new Insets(0, 0, 0, 0);

    public LeftPanel(ContattoController controller) {
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = insetTitolo;
        add(new Titolo("NOME"), gbc);

        gbc.gridy++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.NOME), gbc);

        gbc.gridy++;
        gbc.insets = insetTitolo;
        add(new Titolo("COGNOME"), gbc);

        gbc.gridy++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.COGNOME), gbc);

        gbc.gridy++;
        gbc.insets = insetTitolo;
        add(new Titolo("TAG"), gbc);

        gbc.gridy++;
        gbc.insets = insetTesto;
        add(new Testo(controller, Testo.TAG), gbc);

        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.insets = insetPulsante;
        add(new Pulsante(controller, Pulsante.MODIFICA), gbc);

        gbc.gridx++;
        gbc.insets = insetPulsante;
        add(new Pulsante(controller, Pulsante.ELIMINA), gbc);
    }

    private static class Titolo extends JLabel {

        public Titolo(String testo) {
            super(testo);
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Capriola", Font.BOLD, 20));
            setForeground(Color.WHITE);
            setBackground(new Color(0, 0, 0, 25));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }

    }

    private static class Testo extends JLabel {
        public static final int NOME = 1;
        public static final int COGNOME = 2;
        public static final int TAG = 3;

        public Testo(ContattoController controller, int dato) {
            if (dato == NOME) setText(controller.getContatto().getNome());
            if (dato == COGNOME) setText(controller.getContatto().getCognome());
            if (dato == TAG) setText(controller.getContatto().getTag());
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Capriola", Font.PLAIN, 30));
            setForeground(Color.BLACK);
            setBackground(new Color(211, 211, 211));
            setBorder(new LineBorder(Color.BLACK, 2));
            setOpaque(true);
            setPreferredSize(new Dimension(320, 40));
        }

    }

    private static class Pulsante extends JButton {
        public static final int MODIFICA = 1;
        public static final int ELIMINA = 2;
        private final ContattoController controller;

        public Pulsante(ContattoController controller, int dato) {
            this.controller = controller;
            if (dato == MODIFICA) setModifica();
            if (dato == ELIMINA) setElimina();

            setBackground(new Color(0xFFFFFF));
            setBorderPainted(false);
            setFocusPainted(false);
            setPreferredSize(new Dimension(140, 140));
        }

        private void setModifica() {
            setIcon(icona("/modificaButton.png", 120));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(icona("/modificaButton_hover.png", 120));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(icona("/modificaButton.png", 120));
                }
            });
            addActionListener(e -> controller.modifica());
        }

        private void setElimina() {
            setIcon(icona("/eliminaButton.png", 100));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(icona("/eliminaButton_hover.png", 100));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(icona("/eliminaButton.png", 100));
                }
            });
            addActionListener(e -> controller.elimina());
        }

        private ImageIcon icona(String path, int dimensione) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(LeftPanel.class.getResource(path)));
            Image img = icon.getImage().getScaledInstance(dimensione, dimensione, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
    }

}
