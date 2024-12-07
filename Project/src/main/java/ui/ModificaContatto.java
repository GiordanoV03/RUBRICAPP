/// @file ModificaContatto.java
/// @brief Definisce la classe ModificaContatto per gestire l'interfaccia di modifica dei contatti.
///
/// La classe ModificaContatto rappresenta l'interfaccia utente per la modifica dei contatti.
/// Fornisce i metodi per gestire gli eventi generati dall'interfaccia, come il clic di un pulsante.

package ui;

import model.*;

import javax.swing.*;
import java.awt.*;

/// @class ModificaContatto
/// @brief Classe per la gestione dell'interfaccia di modifica dei contatti.
///
/// Questa classe è responsabile della visualizzazione e gestione della schermata di modifica
/// di un contatto. Consente di interagire con l'interfaccia utente e gestisce i comandi per
/// modificare un contatto selezionato.
public class ModificaContatto {

    private JPanel schermata; ///< Pannello che contiene la schermata dell'interfaccia utente per la modifica dei contatti.

    /// @brief Costruttore che crea una schermata per modificare un contatto.
    /// @param c Il contatto da modificare.
    ///
    /// Questo costruttore inizializza l'interfaccia utente per la modifica dei dati
    /// di un contatto specifico.
    public ModificaContatto(Contatto c) {
        schermata = new JPanel(new BorderLayout());
        schermata.setBackground(Color.GREEN);
    }

    /// @brief Restituisce il pannello della schermata di modifica.
    /// @return Un oggetto JPanel che rappresenta la schermata di modifica del contatto.
    ///
    /// Questo metodo restituisce il pannello grafico che contiene tutti i componenti
    /// dell'interfaccia utente necessari per modificare un contatto.
    public JPanel getSchermata() {
        return schermata;
    }

    /// @brief Gestisce l'evento di clic su un pulsante.
    /// @param pulsante Il pulsante cliccato dall'utente.
    ///
    /// Questo metodo viene chiamato quando un pulsante viene cliccato
    /// all'interno dell'interfaccia utente, permettendo di gestire l'azione associata.
    public void pulsanteCliccato(JButton pulsante) {
        throw new UnsupportedOperationException("ModificaContatto.pulsanteCliccato is not supported yet.");
    }

}