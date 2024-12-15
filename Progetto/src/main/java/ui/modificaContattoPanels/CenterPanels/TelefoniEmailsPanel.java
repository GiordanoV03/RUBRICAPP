package ui.modificaContattoPanels.CenterPanels;

import controller.ModificaContattoController;
import ui.Finestra;

import javax.swing.*;
import java.awt.*;

public class TelefoniEmailsPanel extends JPanel {
    private final CampoDiTesto tel1;
    private final CampoDiTesto tel2;
    private final CampoDiTesto tel3;
    private final CampoDiTesto email1;
    private final CampoDiTesto email2;
    private final CampoDiTesto email3;

    private final int larghezza = Finestra.getLarghezza();
    private final int altezza = Finestra.getAltezza();

    private final Insets telLabelInsets = new Insets(altezza*6/515,0,altezza*6/515,0);
    private final Insets telCampoInsets = new Insets(altezza*6/515, 0, altezza*6/515, larghezza/48);
    private final Insets emailLabelInsets = new Insets(altezza*6/515, larghezza/48, altezza*6/515, 0);
    private final Insets emailCampoInsets = new Insets(altezza*6/515, 0, altezza*6/515, 0);

    public TelefoniEmailsPanel(ModificaContattoController controller) {
        if (controller.getContatto() == null) {
            tel1 = new CampoDiTesto("");
            tel2 = new CampoDiTesto("");
            tel3 = new CampoDiTesto("");
            email1 = new CampoDiTesto("");
            email2 = new CampoDiTesto("");
            email3 = new CampoDiTesto("");
        } else {
            tel1 = new CampoDiTesto(controller.getContatto().getTelefono(0));
            tel2 = new CampoDiTesto(controller.getContatto().getTelefono(1));
            tel3 = new CampoDiTesto(controller.getContatto().getTelefono(2));
            email1 = new CampoDiTesto(controller.getContatto().getEmail(0));
            email2 = new CampoDiTesto(controller.getContatto().getEmail(1));
            email3 = new CampoDiTesto(controller.getContatto().getEmail(2));
        }

        setLayout(new GridBagLayout());
        setBackground(new Color(0,0,0,0));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = telLabelInsets;
        add(new Label("  TELEFONO 1  "), gbc);

        gbc.gridx++;
        gbc.insets = telCampoInsets;
        add(tel1, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.insets = telLabelInsets;
        add(new Label("  TELEFONO 2  "), gbc);

        gbc.gridx++;
        gbc.insets = telCampoInsets;
        add(tel2, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.insets = telLabelInsets;
        add(new Label("  TELEFONO 3  "), gbc);

        gbc.gridx++;
        gbc.insets = telCampoInsets;
        add(tel3, gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        gbc.insets = emailLabelInsets;
        add(new Label("  EMAIL 1  "), gbc);

        gbc.gridx++;
        gbc.insets = emailCampoInsets;
        add(email1, gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        gbc.insets = emailLabelInsets;
        add(new Label("  EMAIL 2  "), gbc);

        gbc.gridx++;
        gbc.insets = emailCampoInsets;
        add(email2, gbc);

        gbc.gridx = 2; gbc.gridy = 2;
        gbc.insets = emailLabelInsets;
        add(new Label("  EMAIL 3  "), gbc);

        gbc.gridx++;
        gbc.insets = emailCampoInsets;
        add(email3, gbc);
    }

    public String getTelefono(int i) {
        if (i == 0) return tel1.getText();
        if (i == 1) return tel2.getText();
        if (i == 2) return tel3.getText();
        throw new IllegalArgumentException("Numero invalido.");
    }

    public String getEmail(int i) {
        if (i == 0) return email1.getText();
        if (i == 1) return email2.getText();
        if (i == 2) return email3.getText();
        throw new IllegalArgumentException("Numero invalido.");
    }

    private static class CampoDiTesto extends JTextField {
        private final int larghezza = Finestra.getLarghezza();
        private final int altezza = Finestra.getAltezza();

        public CampoDiTesto(String placeholder) {
            super(placeholder);
            setPreferredSize(new Dimension(larghezza*25/128, altezza*6/103));
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
