/// @file VediRubrica.java
/// @brief Definisce la classe VediRubrica per la visualizzazione e interazione con una rubrica.
///
/// La classe VediRubrica gestisce l'interfaccia utente per la visualizzazione di una rubrica.
/// Si interfaccia con il controller della rubrica per gestire le operazioni dell'utente
/// come la selezione di pulsanti o l'inserimento di dati.

package ui;

import javax.swing.*;
import java.awt.*;

/// @class VediRubrica
/// @brief Classe per la gestione della schermata di visualizzazione della rubrica.
///
/// Questa classe è responsabile della creazione e gestione dell'interfaccia grafica per
/// visualizzare e interagire con una rubrica. Utilizza il controller della rubrica per
/// invocare le operazioni necessarie in risposta alle azioni dell'utente.
public class VediRubrica {

    private JPanel schermata; ///< Pannello che contiene la schermata dell'interfaccia utente per la visualizzazione della rubrica.

    /// @brief Costruttore che inizializza la schermata di visualizzazione della rubrica.
    public VediRubrica() {
        schermata = new JPanel(new BorderLayout());
        schermata.setBackground(Color.RED);
    }

    /// @brief Restituisce il pannello della schermata di visualizzazione della rubrica.
    /// @return Un oggetto JPanel che rappresenta la schermata di modifica del contatto.
    ///
    /// Questo metodo restituisce il pannello grafico che contiene tutti i componenti
    /// dell'interfaccia utente necessari per visualizzare la rubrica.
    public JPanel getSchermata() {
        return schermata;
    }

    /// @brief Gestisce l'evento di clic su un pulsante.
    /// @param pulsante Il pulsante cliccato dall'utente.
    ///
    /// Questo metodo viene chiamato quando un pulsante viene cliccato
    /// all'interno dell'interfaccia utente, permettendo di gestire l'azione associata.
    public void pulsanteCliccato(JButton pulsante) {
        throw new UnsupportedOperationException("VediRubrica.pulsanteCliccato is not supported yet.");
    }

    /// @brief Gestisce i dati inseriti dall'utente.
    /// @param testo I dati inseriti dall'utente.
    ///
    /// Questo metodo viene invocato quando l'utente inserisce del testo,
    /// ad esempio in un campo di input, ed esegue l'operazione appropriata
    /// utilizzando il controller della rubrica.
    public void datiInseriti(String testo) {
        throw new UnsupportedOperationException("VediRubrica.datiInseriti is not supported yet.");
    }
}
