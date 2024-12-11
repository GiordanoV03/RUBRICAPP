/// @file ContattoController.java
/// @brief Definisce la classe ContattoController per la gestione delle operazioni sui contatti.
///
/// Questa classe fornisce metodi per visualizzare, modificare, eliminare un contatto, gestire
/// le email associate ai contatti e navigare nel flusso dell'applicazione.

package controller;

import model.*;
import ui.Finestra;

/// @class ContattoController
/// @brief Classe che gestisce le operazioni sui contatti.
///
/// La classe ContattoController fornisce metodi per l'interazione con i contatti, inclusa
/// la visualizzazione, modifica ed eliminazione dei dati, oltre alla gestione di operazioni
/// come l'apertura di email e il ritorno a una schermata precedente.
public class ContattoController {
    private Contatto contatto;

    /// @brief Costruttore del controller.
    /// @param contatto Il contatto di cui visualizzare i dettagli.
    ///
    /// Questo metodo è responsabile della visualizzazione delle informazioni complete
    /// di un contatto specifico, incluse email e numeri di telefono.
    public ContattoController(Contatto contatto) {
        this.contatto = contatto;
    }

    /// @brief Modifica il contatto visualizzato con nuovi dati.
    /// Questo metodo permette di aggiornare le informazioni del contatto
    /// visualizzato, passando alla schermata ModificaContatto.
    public void modifica() {
        Finestra.mostraModificaContatto(contatto);
    }

    /// @brief Elimina un contatto.
    /// Questo metodo consente di rimuovere un contatto specificato dal sistema.
    public void elimina() {
        Rubrica.rimuovi(contatto);
        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

    /// @brief Apre il client email per inviare un'email.
    /// @param email L'indirizzo email da utilizzare per aprire il client.
    /// Questo metodo lancia un'operazione per aprire il client email predefinito
    /// del sistema utilizzando l'indirizzo email fornito.
    public void apriEmail(String email) {
        try {
            Email.apriEmail(email);
        } catch (EmailNonValidaException e) {
            Finestra.mostraErrore("L'email del contatto non è valida.");
        }
    }

    /// @brief Torna alla schermata precedente.
    /// Questo metodo gestisce il ritorno alla schermata precedente nel flusso dell'applicazione.
    public void indietro() {
        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

}