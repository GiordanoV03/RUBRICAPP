/// @file ModificaContatto.java
/// @brief Definisce la classe ModificaContatto per gestire l'interfaccia.
///
/// La classe ModificaContatto rappresenta l'interfaccia utente per modificare
/// i contatti. Fornisce metodi per gestire gli eventi generati dall'interfaccia,
/// come il clic di un pulsante.

package ui;

import controller.ModificaContattoController;
import model.*;
import ui.modificaContattoPanels.*;

import javax.swing.*;
import java.awt.*;

/// @class ModificaContatto
/// @brief Classe per gestire l'interfaccia di modifica dei contatti.
///
/// Questa classe visualizza e gestisce la schermata per la modifica di un
/// contatto selezionato. Consente di interagire con l'interfaccia utente e
/// inviare comandi per apportare modifiche.
public class ModificaContatto {

    private final JPanel schermata; ///< Pannello principale della schermata.
    private final ModificaContattoController controller; ///< Controller logico.
    private final TopPanel topPanel; ///< Pannello superiore della schermata.
    private final CenterPanel centerPanel; ///< Pannello centrale della schermata.
    private final BottomPanel bottomPanel; ///< Pannello inferiore della schermata.

    /// @brief Costruttore per creare una schermata di modifica del contatto.
    /// @param c Il contatto da modificare.
    ///
    /// Inizializza l'interfaccia per la modifica dei dati di un contatto
    /// specifico, creando i pannelli necessari e impostando il layout.
    public ModificaContatto(Contatto c) {
        controller = new ModificaContattoController(this, c);
        schermata = new JPanel(new BorderLayout()) {
            private final Color bg1 = new Color(0x8C52FF);
            private final Color bg2 = new Color(0x5CE1E6);

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
        topPanel = new TopPanel(controller);
        centerPanel = new CenterPanel(controller);
        bottomPanel = new BottomPanel(controller);

        schermata.add(topPanel, BorderLayout.NORTH);
        schermata.add(centerPanel, BorderLayout.CENTER);
        schermata.add(bottomPanel, BorderLayout.SOUTH);
    }

    /// @brief Restituisce il pannello della schermata di modifica.
    /// @return Un JPanel che rappresenta la schermata di modifica.
    ///
    /// Fornisce il pannello grafico contenente i componenti dell'interfaccia
    /// per modificare un contatto.
    public JPanel getSchermata() {
        return schermata;
    }

    /// @brief Restituisce il nome inserito dall'utente.
    /// @return Una stringa contenente il nome.
    public String getNome() {
        return centerPanel.getNome();
    }

    /// @brief Restituisce il cognome inserito dall'utente.
    /// @return Una stringa contenente il cognome.
    public String getCognome() {
        return centerPanel.getCognome();
    }

    /// @brief Restituisce il tag associato al contatto.
    /// @return Una stringa contenente il tag.
    public String getTag() {
        return centerPanel.getTag();
    }

    /// @brief Restituisce il telefono all'indice specificato.
    /// @param i Indice del numero di telefono.
    /// @return Una stringa contenente il numero di telefono.
    public String getTelefono(int i) {
        return centerPanel.getTelefono(i);
    }

    /// @brief Restituisce l'email all'indice specificato.
    /// @param i Indice dell'email.
    /// @return Una stringa contenente l'email.
    public String getEmail(int i) {
        return centerPanel.getEmail(i);
    }

}