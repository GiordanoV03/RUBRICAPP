/// @file VediContatto.java
/// @brief Definisce la classe VediContatto per visualizzare le informazioni di un contatto.
///
/// La classe VediContatto fornisce un'interfaccia utente per visualizzare i dettagli
/// di un contatto specifico. Gestisce eventi come la pressione di pulsanti e restituisce
/// la schermata corrispondente.

package ui;

import controller.ContattoController;
import model.*;

import javax.swing.*;

/// @class VediContatto
/// @brief Classe che rappresenta la schermata per visualizzare un contatto.
///
/// Questa classe gestisce l'interfaccia utente per visualizzare le informazioni di un contatto.
/// Permette di interagire con i dati del contatto tramite eventi generati dall'utente.
public class VediContatto {

    private ContattoController controller; ///< Controller associato alla gestione della logica di visualizzazione di un contatto.
    private JPanel schermata; ///< Pannello della schermata per visualizzare il contatto.

    /// @brief Costruttore della classe VediContatto.
    /// @param c Il contatto da visualizzare.
    ///
    /// Inizializza l'interfaccia utente per visualizzare le informazioni del contatto specificato.
    public VediContatto(Contatto c) {
        throw new UnsupportedOperationException("VediContatto constructor is not supported yet.");
    }

    /// @brief Restituisce il pannello della schermata di modifica.
    /// @return Un oggetto JPanel che rappresenta la schermata di modifica del contatto.
    ///
    /// Restituisce il pannello grafico che contiene tutti i componenti
    /// dell'interfaccia utente necessari per visualizzare un contatto.
    public JPanel getSchermata() {
        return schermata;
    }

    /// @brief Gestisce l'evento di clic su un pulsante.
    /// @param pulsante Il pulsante cliccato dall'utente.
    ///
    /// Questo metodo viene chiamato quando un pulsante viene cliccato
    /// all'interno dell'interfaccia utente, permettendo di gestire l'azione associata.
    public void pulsanteCliccato(JButton pulsante) {
        throw new UnsupportedOperationException("VediContatto.pulsanteCliccato is not supported yet.");
    }
}
