package ui.modificaContattoPanels.CenterPanels;

import controller.ModificaContattoController;

import javax.swing.*;
import java.awt.*;

public class NomeCognomeTagPanel extends JPanel {
    private final ModificaContattoController controller;
    private final CampoDiTesto nome;
    private final CampoDiTesto cognome;
    private final CampoDiTesto tag;

    public NomeCognomeTagPanel(ModificaContattoController controller) {
        this.controller = controller;
        if (controller.getContatto() == null) {
            nome = new CampoDiTesto("");
            cognome = new CampoDiTesto("");
            tag = new CampoDiTesto("");
        } else {
            nome = new CampoDiTesto(controller.getContatto().getNome());
            cognome = new CampoDiTesto(controller.getContatto().getCognome());
            tag = new CampoDiTesto(controller.getContatto().getTag());
        }

        setLayout(new GridBagLayout());
        setBackground(new Color(0,0,0,0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,45,0,45);

        gbc.gridx = 0; gbc.gridy = 0;
        add(new Label("  NOME  "), gbc);

        gbc.gridy++;
        add(nome, gbc);

        gbc.gridx++; gbc.gridy = 0;
        add(new Label("  COGNOME  "), gbc);

        gbc.gridy++;
        add(cognome, gbc);

        gbc.gridx++; gbc.gridy = 0;
        add(new Label("  TAG  "), gbc);

        gbc.gridy++;
        add(tag, gbc);
    }

    public String getNome() {
        return nome.getText();
    }

    public String getCognome() {
        return cognome.getText();
    }

    public String getTag() {
        return tag.getText();
    }

    private static class CampoDiTesto extends JTextField {

        public CampoDiTesto(String placeholder) {
            super(placeholder);
            setPreferredSize(new Dimension(375, 60));
            setFont(new Font("Capriola", Font.PLAIN, 19));
            setHorizontalAlignment(SwingConstants.CENTER);
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }

    }

    private static class Label extends JLabel {

        public Label(String testo) {
            super(testo);
            setFont(new Font("Capriola", Font.PLAIN, 35));
            setForeground(Color.WHITE);
            setOpaque(true);
            setBackground(new Color(0,0,0,25));
        }

    }

}
