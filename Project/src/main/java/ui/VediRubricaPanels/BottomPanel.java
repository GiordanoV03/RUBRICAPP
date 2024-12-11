package ui.VediRubricaPanels;

import controller.RubricaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import ui.Finestra;

public class BottomPanel extends JPanel {
    public BottomPanel(RubricaController controller) {
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(new Color(0,0,0,0));
        
        add(new OrdinaPer(controller));
        add(new Nome(controller));
        add(new Cognome(controller));
        add(Box.createRigidArea(new Dimension(Finestra.getLarghezza() * 600 / 1920, 0)));
        add(new Importa(controller));
        add(new Esporta(controller));
    }
    
    public static class OrdinaPer extends JLabel {
        public OrdinaPer(RubricaController controller){
            setLayout(new BorderLayout());
            setText("Ordina per:");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setBackground(new Color(0, 0, 0, 0));
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 100 / 1920, Finestra.getAltezza() * 40 / 1080));
        }
    }
    
    public static class Nome extends JRadioButton {
        public Nome(RubricaController controller){
            setLayout(new BorderLayout());
            setText("NOME");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 100 / 1920, Finestra.getAltezza() * 40 / 1080));
        }
    }
    
    public static class Cognome extends JRadioButton {
        public Cognome(RubricaController controller){
            setLayout(new BorderLayout());
            setText("COGNOME");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 100 / 1920, Finestra.getAltezza() * 40 / 1080));
        }
    }
    
    public static class Importa extends JButton {
        public Importa(RubricaController controller){
            setLayout(new BorderLayout());
            setText("Importa");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 320 / 1920, Finestra.getAltezza() * 40 / 1080));
        }
    }
    
    public static class Esporta extends JButton {
        public Esporta(RubricaController controller){
            setLayout(new BorderLayout());
            setText("Esporta");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 320 / 1920, Finestra.getAltezza() * 40 / 1080));
        }
    }
}