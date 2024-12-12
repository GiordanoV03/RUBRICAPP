package ui.VediRubricaPanels;

import controller.RubricaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TopPanel extends JPanel {
    
    public TopPanel(RubricaController controller) {
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        
        add(new Titolo(), BorderLayout.WEST);
        add(new BarraRicerca(controller), BorderLayout.CENTER);
        add(new BottoneAggiungi(controller), BorderLayout.EAST);
    }
    
    public static class Titolo extends JLabel {
        private Titolo(){
            setText("RUBRICAPP");
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("Colette", Font.BOLD, 28));
            setForeground(Color.white);
            setBackground(new Color(0x5271FF));
        } 
    }
    
    public static class BarraRicerca extends JPanel {
        private BarraRicerca(RubricaController controller){
            setPreferredSize(new Dimension(600, 40));
            setBackground(new Color(0,0,0,0));
            
            CampoRicerca campoRicerca = new CampoRicerca(controller);
            BottoneRicerca bottoneRicerca = new BottoneRicerca(controller);
            
            bottoneRicerca.addActionListener(e -> controller.cerca(campoRicerca.getText()));
            
            add(campoRicerca, BorderLayout.CENTER);
            add(bottoneRicerca, BorderLayout.EAST);
        }
    }
    
    public static class CampoRicerca extends JTextField {
        private CampoRicerca(RubricaController controller){
            setForeground(Color.black);
            setPreferredSize(new Dimension(500, 40));
        }
    }
    
    public static class BottoneRicerca extends JButton {
        private BottoneRicerca(RubricaController controller){
            setText("🔍");
        }
    }
    
    public static class BottoneAggiungi extends JButton {
        private BottoneAggiungi(RubricaController controller){
            setText("+");
            addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount() == 1){
                        controller.aggiungiContatto();
                    }
                }
            });
        }
    }
}