package ui.VediRubricaPanels;

import controller.RubricaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import ui.Finestra;
import ui.vediContattoPanels.TopPanel;

public class BottomPanel extends JPanel {
    public BottomPanel(RubricaController controller) {
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(new Color(0,0,0,0));
        
        add(new OrdinaPer(controller));
        add(new OrdinamentoPanel(controller));
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
    
    public static class Importa extends JButton {
        public Importa(RubricaController controller){
            setLayout(new BorderLayout());
            setText("Importa");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 200 / 1920, Finestra.getAltezza() * 40 / 1080));
            addActionListener(e -> controller.importa());
        }
    }
    
    public static class Esporta extends JButton {
        public Esporta(RubricaController controller){
            setLayout(new BorderLayout());
            setText("Esporta");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 200 / 1920, Finestra.getAltezza() * 40 / 1080));
            addActionListener(e -> controller.salvaConNome());
        }
    }
    
    public static class OrdinamentoPanel extends JPanel {
        public OrdinamentoPanel(RubricaController controller) {
            JRadioButton ordinaPerNome = new JRadioButton("NOME");
            ordinaPerNome.setFont(new Font("Colette", Font.BOLD, 14));
            ordinaPerNome.setForeground(Color.BLACK);
            ordinaPerNome.setPreferredSize(new Dimension(Finestra.getLarghezza() * 100 / 1920, Finestra.getAltezza() * 40 / 1080));
            
            JRadioButton ordinaPerCognome = new JRadioButton("COGNOME");
            ordinaPerCognome.setFont(new Font("Colette", Font.BOLD, 14));
            ordinaPerCognome.setForeground(Color.BLACK);
            ordinaPerCognome.setPreferredSize(new Dimension(Finestra.getLarghezza() * 100 / 1920, Finestra.getAltezza() * 40 / 1080));

            ButtonGroup group = new ButtonGroup();
            group.add(ordinaPerNome);
            group.add(ordinaPerCognome);

            setLayout(new FlowLayout());
            add(ordinaPerNome);
            add(ordinaPerCognome);
            
            setBackground(Color.WHITE);
            
            ordinaPerNome.addActionListener(e -> controller.cambiaOrdinamento(true));
            ordinaPerCognome.addActionListener(e -> controller.cambiaOrdinamento(false));
        }
    }
}