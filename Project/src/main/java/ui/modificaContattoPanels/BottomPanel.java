package ui.modificaContattoPanels;

import controller.ModificaContattoController;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    public BottomPanel(ModificaContattoController controller) {setVisible(true);
        setLayout(new GridBagLayout());
        setBackground(new Color(0,0,0,0));

        setBorder(BorderFactory.createLineBorder(Color.RED, 2));
    }
}
