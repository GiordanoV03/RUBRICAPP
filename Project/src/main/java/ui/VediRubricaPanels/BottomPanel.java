package ui.VediRubricaPanels;

import controller.RubricaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import model.Contatto;

import model.Ordinamento;
import model.Rubrica;
import ui.Finestra;

public class BottomPanel extends JPanel {
    public BottomPanel(RubricaController controller) {
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(new Color(0,0,0,0));
        
        add(new OrdinaPer(controller));
        add(new OrdinamentoPanel(controller));
        add(Box.createRigidArea(new Dimension(Finestra.getLarghezza() * 500 / 1920, 0)));
        add(new Importa(controller));
        add(new Esporta(controller));
        add(new EliminaTutti(controller));
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
            setBackground(Color.WHITE);
            setFocusPainted(false);
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
            setLayout(new BorderLayout());
            setBackground(Color.WHITE);
            setFocusPainted(false);
            setText("Esporta");
            setFont(new Font("Colette", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setPreferredSize(new Dimension(Finestra.getLarghezza() * 200 / 1920, Finestra.getAltezza() * 40 / 1080));
            addActionListener(e -> controller.esporta());
        }
    }
    
    public static class OrdinamentoPanel extends JPanel {
        private final RubricaController controller;

        public OrdinamentoPanel(RubricaController controller) {
            this.controller = controller;
            setLayout(new GridBagLayout());
            setBackground(new Color(0,0,0,0));

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0; gbc.gridy = 0;
            add(label("Nome  "));

            gbc.gridx ++;
            add(button());

            gbc.gridx ++;
            add(label("  Cognome"));
        }

        private JLabel label(String testo){
            JLabel label = new JLabel(testo);
            label.setFont(new Font("Colette", Font.BOLD, 16));
            return label;
        }

        private JButton button(){
            JButton button = new JButton();
            button.setBackground(new Color(0xC9CAFF));
            if (Ordinamento.isOrdinamentoPerNome())
                button.setIcon(icona("/radioButton.png"));
            else
                button.setIcon(icona("/radioButton_hover.png"));
            button.setPreferredSize(new Dimension(60, 40));
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.addActionListener(e -> {
                controller.cambiaOrdinamento(!Ordinamento.isOrdinamentoPerNome());
            });
            return button;
        }

        private ImageIcon icona(String path) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
            Image img = icon.getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
    }
    
    public static class EliminaTutti extends JButton {
        
        public EliminaTutti(RubricaController controller){
            setBackground(Color.WHITE);
            setFocusPainted(false);
            setIcon(icona("/eliminaButton.png", 40));
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(icona("/eliminaButton_hover.png", 40));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(icona("/eliminaButton.png", 40));
                }
            });
            
            addActionListener(e -> {
                List<Contatto> selezionati = new ArrayList<Contatto>();
                
                for (Contatto c : controller.getContatti())
                    if (c.isSelezionato())
                        selezionati.add(c);
                
                if (selezionati.size() == 0) {
                    Finestra.mostraErrore("Non c'è nessun contatto selezionato.");
                    return;
                }
                
                if (!Finestra.chiediConferma("Vuoi eliminare i contatti selezionati?"))
                    return;
                
                for (Contatto c : selezionati)
                    Rubrica.rimuovi(c);
                
                Finestra.mostraVediRubrica(Rubrica.getContatti());
            });
        }
        
        private ImageIcon icona(String path, int dimensione) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(BottomPanel.class.getResource(path)));
            Image img = icon.getImage().getScaledInstance(dimensione, dimensione, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        
    }
    
}