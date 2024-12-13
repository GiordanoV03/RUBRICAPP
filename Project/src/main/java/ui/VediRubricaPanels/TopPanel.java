package ui.VediRubricaPanels;

import controller.RubricaController;
import ui.Finestra;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TopPanel extends JPanel {
    
    public TopPanel(RubricaController controller) {
        setVisible(true);
        setBackground(new Color(0x5271FF));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(20, Finestra.getLarghezza() * 13 / 192,20,Finestra.getLarghezza() * 5 / 48);
        add(new Titolo(), gbc);

        gbc.gridx ++;
        gbc.insets = new Insets(20, 0,20,Finestra.getLarghezza() * 25 / 96);
        add(new BarraRicerca(controller), gbc);

        gbc.gridx ++;
        gbc.insets = new Insets(20, 0,20,Finestra.getLarghezza() * 5 / 96);
        add(new BottoneAggiungi(controller), gbc);
    }
    
    public static class Titolo extends JLabel {
        private Titolo(){
            setText("RUBRICAPP");
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Colette", Font.BOLD, 56));
            setForeground(Color.white);
            setBackground(new Color(0x5271FF));
            setPreferredSize(new Dimension(340, 50));
        } 
    }
    
    public static class BarraRicerca extends JPanel {
        private BarraRicerca(RubricaController controller){
            setBackground(Color.WHITE);
            setLayout(new GridBagLayout());
            
            CampoRicerca campoRicerca = new CampoRicerca();
            BottoneRicerca bottoneRicerca = new BottoneRicerca();

            bottoneRicerca.addActionListener(e -> controller.cerca(campoRicerca.getText()));

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0; gbc.gridy = 0;
            gbc.insets = new Insets(0, 10,0,0);
            add(campoRicerca, gbc);
            gbc.gridx ++;
            gbc.insets = new Insets(0, 0,0,0);
            add(bottoneRicerca, gbc);

            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    
    private static class CampoRicerca extends JTextField {
        public CampoRicerca(){
            setForeground(Color.black);
            setFont(new Font("Arial", Font.PLAIN, 20));
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 25 / 96, 50));
            setBorder(BorderFactory.createLineBorder(Color.black, 0));
        }
    }
    
    private static class BottoneRicerca extends JButton {
        public BottoneRicerca(){
            setPreferredSize(new Dimension(50, 50));
            setBackground(Color.WHITE);
            setBorderPainted(false);
            setFocusPainted(false);
            setIcon(icona("/cercaButton.png"));
        }

        private ImageIcon icona(String path) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(TopPanel.class.getResource(path)));
            Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
    }
    
    private static class BottoneAggiungi extends JButton {

        public BottoneAggiungi(RubricaController controller) {
            setText("+");
            setFont(new Font("Courier", Font.BOLD, 48));
            setBorderPainted(false);
            setFocusPainted(false);
            setBackground(Color.WHITE);
            addActionListener(e -> controller.aggiungiContatto());
            setBorder(BorderFactory.createLineBorder(Color.RED));
            setPreferredSize(new Dimension(50, 50));
        }
    }
}