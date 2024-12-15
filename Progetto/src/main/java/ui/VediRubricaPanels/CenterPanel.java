package ui.VediRubricaPanels;

import controller.RubricaController;
import model.Contatto;
import ui.Finestra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CenterPanel extends JPanel {
    private final RubricaController controller;
    private final JPanel containerPanel = new JPanel();

    public CenterPanel(RubricaController controller){
        this.controller = controller;
        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(new Color(0,0,0,0));

        inizializzaContainerPanel();
        add(scrollPane(), BorderLayout.CENTER);

        validate();
        repaint();
    }

    private void inizializzaContainerPanel() {
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBackground(new Color(0, 0, 0, 0));

        for (Contatto c : controller.getContatti()) {
            containerPanel.add(new ContattoPanel(controller, c));
        }
        containerPanel.add(Box.createVerticalGlue()); // Per evitare compressione dei componenti
    }

    private JScrollPane scrollPane(){
        JScrollPane sp = new JScrollPane(containerPanel);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.getViewport().setBackground(new Color(0,0,0,0));
        sp.setOpaque(false);
        sp.setBorder(null);
        return sp;
    }

    private static class ContattoPanel extends JPanel {
        private final RubricaController controller;
        private final Contatto contatto;
        private Color bg1 = new Color(0x8C52FF);
        private Color bg2 = new Color(0x1BDAFF);

        public ContattoPanel(RubricaController controller, Contatto contatto){
            this.controller = controller;
            this.contatto = contatto;
            setLayout(new GridBagLayout());
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 9 / 10, 60));
            setMaximumSize(new Dimension(Finestra.getLarghezza(), 60));
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0; gbc.gridy = 0;
            add(label(contatto), gbc);

            if (!contatto.getTag().isEmpty()) {
                gbc.insets = new Insets(0, 30, 0, 0);
                gbc.gridx ++;
                add(tag(contatto), gbc);
            }

            addMouseListener(new MouseAdapter() {
                private long ultimoClick = 0;

                @Override
                public void mouseClicked(MouseEvent e) {
                    int DOUBLE_CLICK_DELAY = 300;
                    long oraAttuale = System.currentTimeMillis();
                    if (oraAttuale - ultimoClick < DOUBLE_CLICK_DELAY) {
                        contatto.setSelezionato(!contatto.isSelezionato());
                        Finestra.mostraVediContatto(contatto);
                    } else {
                        contatto.setSelezionato(!contatto.isSelezionato());
                        setColoriSfondo();
                    }
                    ultimoClick = oraAttuale;
                }
            });

            setColoriSfondo();
        }

        private void setColoriSfondo(){
            if (!contatto.isSelezionato()) {
                bg1 = new Color(0x8C52FF);
                bg2 = new Color(0x1BDAFF);
            } else {
                bg1 = new Color(0x8C52FF).darker();
                bg2 = new Color(0x1BDAFF).darker();
            }

            validate();
            repaint();
        }

        private JLabel label(Contatto contatto) {
            String testo;
            if (contatto.getNome().isEmpty())
                testo = contatto.getCognome();
            else if (contatto.getCognome().isEmpty())
                testo = contatto.getNome();
            else
                testo = contatto.getNome() + " " + contatto.getCognome();

            JLabel label = new JLabel(testo);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setForeground(Color.WHITE);
            label.setFont(label.getFont().deriveFont(Font.BOLD, 24));
            return label;
        }

        private JButton tag(Contatto contatto) {
            JButton button = new JButton(contatto.getTag());
            button.setHorizontalAlignment(JButton.CENTER);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(contatto.getTag().hashCode()).darker());
            button.setFocusPainted(false);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(e -> controller.cerca(contatto.getTag()));
            return button;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradient = new GradientPaint(
                    0, getHeight()/2, bg1,
                    getWidth(), getHeight()/2, bg2
            );
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
    
}