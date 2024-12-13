package ui.vediContattoPanels;

import controller.ContattoController;
import ui.vediContattoPanels.CenterPanels.*;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    public CenterPanel(ContattoController controller) {
        setVisible(true);
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0)); // Sfondo trasparente

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,50, 0, 50);

        gbc.gridx = 0; gbc.gridy = 0;
        add(new LeftPanel(controller), gbc);

        gbc.gridx = 1;
        add(new RightPanel(controller), gbc);
    }

}