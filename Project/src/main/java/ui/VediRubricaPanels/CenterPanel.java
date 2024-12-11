
package ui.VediRubricaPanels;

import controller.RubricaController;
import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    public CenterPanel(RubricaController controller) {
        setVisible(true);
        setLayout(new GridBagLayout());
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setBackground(new Color(0,0,0,0));
    }
    
}
