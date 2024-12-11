package ui.VediRubricaPanels;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    public TopPanel() {
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setBackground(new Color(0,0,0,0));

        // Etichetta del titolo RUBRICAPP
        JLabel titolo = new JLabel("RUBRICAPP", JLabel.CENTER);
        titolo.setFont(new Font("Colette", Font.BOLD, 28));
        titolo.setForeground(Color.white);
        titolo.setBackground(new Color(0x5271FF));
        add(titolo, BorderLayout.WEST);

        // Barra di ricerca
        JPanel barraRicerca = new JPanel(new BorderLayout());
        barraRicerca.setPreferredSize(new Dimension(600, 40));

        // Campo dove inserire caratteri per la ricerca
        JTextField campoRicerca = new JTextField();
        campoRicerca.setForeground(Color.black);
        barraRicerca.add(campoRicerca, BorderLayout.CENTER);

        // Pulsante della ricerca
        JButton bottoneRicerca = new JButton("🔍");
        barraRicerca.add(bottoneRicerca, BorderLayout.EAST);
        add(barraRicerca, BorderLayout.CENTER);

        // Pulsante "+"
        JButton bottoneAggiungi = new JButton("+");
        add(bottoneAggiungi, BorderLayout.WEST);
    }   
}
