/// @file VediRubrica.java
/// @brief Definisce la classe VediRubrica per la visualizzazione e interazione con una rubrica.
///
/// La classe VediRubrica gestisce l'interfaccia utente per la visualizzazione di una rubrica.
/// Si interfaccia con il controller della rubrica per gestire le operazioni dell'utente
/// come la selezione di pulsanti o l'inserimento di dati.

package ui;
import model.*;

import controller.RubricaController;
import javax.swing.*;
import java.awt.*;
import model.Contatto;

import java.util.List;

import ui.VediRubricaPanels.*;

/// @class VediRubrica
/// @brief Classe per la gestione della schermata di visualizzazione della rubrica.
///
/// Questa classe è responsabile della creazione e gestione dell'interfaccia grafica per
/// visualizzare e interagire con una rubrica. Utilizza il controller della rubrica per
/// invocare le operazioni necessarie in risposta alle azioni dell'utente.
public class VediRubrica {

    private JPanel schermata; ///< Pannello che contiene la schermata dell'interfaccia utente per la visualizzazione della rubrica.
    private RubricaController controller;   ///< Controller che gestisce la logica della schermata.

    /// @brief Costruttore che inizializza la schermata di visualizzazione della rubrica.
    public VediRubrica(List<Contatto> contatti) {
        controller = new RubricaController(contatti);
        schermata = new JPanel(new BorderLayout()) {
            private final Color bg1 = new Color(0xCFB7FF);
            private final Color bg2 = new Color(0xBCFDFF);
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, getHeight()/2, bg1,
                        getWidth(), getHeight()/2, bg2
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        schermata.add(new TopPanel(controller), BorderLayout.NORTH);
        schermata.add(new CenterPanel(controller), BorderLayout.CENTER);
        schermata.add(new BottomPanel(controller), BorderLayout.SOUTH);
        schermata.add(panelVuoto(), BorderLayout.LINE_START);
        schermata.add(panelVuoto(), BorderLayout.LINE_END);
    }

    /// @brief Crea e restituisce un pannello vuoto utilizzato come spazio separatore.
    /// @return Un oggetto JPanel di dimensioni 100x0, vuoto e trasparente.
    ///
    /// Questo metodo genera un oggetto JPanel trasparente e di dimensioni
    /// prefissate (100x0), utilizzato per creare uno spazio visivo tra
    /// altri pannelli, dando l'impressione che siano più distanti tra loro.
    private JPanel panelVuoto() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,0,0,0));
        panel.setPreferredSize(new Dimension(100, 0));
        return panel;
    }

    /// @brief Restituisce il pannello della schermata di visualizzazione della rubrica.
    /// @return Un oggetto JPanel che rappresenta la schermata di modifica del contatto.
    ///
    /// Questo metodo restituisce il pannello grafico che contiene tutti i componenti
    /// dell'interfaccia utente necessari per visualizzare la rubrica.
    public JPanel getSchermata() {
        return schermata;
    }

}