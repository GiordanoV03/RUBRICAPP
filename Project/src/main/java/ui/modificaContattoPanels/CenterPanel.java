package ui.modificaContattoPanels;

import controller.ModificaContattoController;
import ui.modificaContattoPanels.CenterPanels.*;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private final NomeCognomeTagPanel nomeCognomeTagPanel;
    private final TelefoniEmailsPanel telefoniEmailsPanel;

    public CenterPanel(ModificaContattoController controller) {
        nomeCognomeTagPanel = new NomeCognomeTagPanel(controller);
        telefoniEmailsPanel = new TelefoniEmailsPanel(controller);

        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(new Color(0,0,0,0));

        add(nomeCognomeTagPanel, BorderLayout.CENTER);
        add(telefoniEmailsPanel, BorderLayout.SOUTH);
    }

    public String getNome() {
        return nomeCognomeTagPanel.getNome();
    }

    public String getCognome() {
        return nomeCognomeTagPanel.getCognome();
    }

    public String getTag() {
        return nomeCognomeTagPanel.getTag();
    }

    public String getTelefono(int i) {
        return telefoniEmailsPanel.getTelefono(i);
    }

    public String getEmail(int i) {
        return telefoniEmailsPanel.getEmail(i);
    }

}
