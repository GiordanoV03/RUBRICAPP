package ui.VediRubricaPanels;

import javax.swing.*;
import java.awt.*;
import model.Contatto;
import model.Rubrica;

public class CenterPanel extends JPanel {
    public CenterPanel(){
        setVisible(true);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        setBackground(new Color(0,0,0,0));

        // Creazione della lista contatti
        DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
        for(Contatto c : Rubrica.getContatti()){
            contattiModel.addElement(c);
        }
        
        JList<Contatto> listaContatti = new JList<>(contattiModel);

        // Aggiungere la lista dentro uno JScrollPane
        JScrollPane scrollPane = new JScrollPane(listaContatti);
        scrollPane.setBackground(new Color(0,0,0,0));
        scrollPane.setForeground(Color.black);
        add(scrollPane, BorderLayout.CENTER);
    }   
}
