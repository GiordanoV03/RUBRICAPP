/// @file ModificaContatto.java
/// @brief Definisce la classe ModificaContatto per gestire l'interfaccia di modifica dei contatti.
///
/// La classe ModificaContatto rappresenta l'interfaccia utente per la modifica dei contatti.
/// Fornisce i metodi per gestire gli eventi generati dall'interfaccia, come il clic di un pulsante.

package ui;

import controller.ModificaContattoController;
import model.*;
import ui.modificaContattoPanels.*;

import javax.swing.*;
import java.awt.*;

/// @class ModificaContatto
/// @brief Classe per la gestione dell'interfaccia di modifica dei contatti.
///
/// Questa classe è responsabile della visualizzazione e gestione della schermata di modifica
/// di un contatto. Consente di interagire con l'interfaccia utente e gestisce i comandi per
/// modificare un contatto selezionato.
public class ModificaContatto {

    private final JPanel schermata; ///< Pannello che contiene la schermata dell'interfaccia utente per la modifica dei contatti.
    private final ModificaContattoController controller; ///< Controller che gestisce la logica della schermata.
    private final TopPanel topPanel;
    private final CenterPanel centerPanel;
    private final BottomPanel bottomPanel;

    /// @brief Costruttore che crea una schermata per modificare un contatto.
    /// @param c Il contatto da modificare.
    ///
    /// Questo costruttore inizializza l'interfaccia utente per la modifica dei dati
    /// di un contatto specifico.
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
    /// @return Un oggetto JPanel che rappresenta la schermata di modifica del contatto.
    ///
    /// Questo metodo restituisce il pannello grafico che contiene tutti i componenti
    /// dell'interfaccia utente necessari per modificare un contatto.
    public JPanel getSchermata() {
        return schermata;
    }

    public String getNome() {
        return centerPanel.getNome();
    }

    public String getCognome() {
        return centerPanel.getCognome();
    }

    public String getTag() {
        return centerPanel.getTag();
    }

    public String getTelefono(int i) {
        return centerPanel.getTelefono(i);
    }

    public String getEmail(int i) {
        return centerPanel.getEmail(i);
    }

    public static void main(String[] args) {
        Finestra.start();
        Finestra.mostraModificaContatto(null);
        // Finestra.mostraModificaContatto(new Contatto("Giuseppe", "Pastore"));
    }

}