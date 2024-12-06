package controller;

import model.*;

/// @file ContattoController.java
/// @brief Definisce la classe ContattoController per la gestione delle operazioni sui contatti.
///
/// Questa classe fornisce metodi per visualizzare, modificare, eliminare un contatto, gestire
/// le email associate ai contatti e navigare nel flusso dell'applicazione.

/// @class ContattoController
/// @brief Classe che gestisce le operazioni sui contatti.
///
/// La classe ContattoController fornisce metodi per l'interazione con i contatti, inclusa
/// la visualizzazione, modifica ed eliminazione dei dati, oltre alla gestione di operazioni
/// come l'apertura di email e il ritorno a una schermata precedente.
public class ContattoController {

    /// @brief Visualizza i dettagli di un contatto.
    /// @param c Il contatto di cui visualizzare i dettagli.
    ///
    /// Questo metodo è responsabile della visualizzazione delle informazioni complete
    /// di un contatto specifico, incluse email e numeri di telefono.
    public void visualizza(Contatto c) {
        throw new UnsupportedOperationException("ContattoController.visualizza is not supported yet.");
    }

    /// @brief Modifica un contatto esistente con nuovi dati.
    /// @param nuovo Oggetto Contatto contenente i dati aggiornati.
    /// Questo metodo permette di aggiornare le informazioni di un contatto già esistente,
    /// sovrascrivendo i dati con quelli forniti nel parametro "nuovo".
    public void modifica(Contatto nuovo) {
        throw new UnsupportedOperationException("ContattoController.modifica is not supported yet.");
    }

    /// @brief Elimina un contatto.
    /// @param c Il contatto da eliminare.
    /// Questo metodo consente di rimuovere un contatto specificato dal sistema.
    public void elimina(Contatto c) {
        throw new UnsupportedOperationException("ContattoController.elimina is not supported yet.");
    }

    /// @brief Apre il client email per inviare un'email.
    /// @param email L'indirizzo email da utilizzare per aprire il client.
    /// Questo metodo lancia un'operazione per aprire il client email predefinito
    /// del sistema utilizzando l'indirizzo email fornito.
    public void apriEmail(String email) {
        throw new UnsupportedOperationException("ContattoController.apriEmail is not supported yet.");
    }

    /// @brief Torna alla schermata precedente.
    /// @throw UnsupportedOperationException Se l'operazione non è supportata.
    /// Questo metodo gestisce il ritorno alla schermata precedente nel flusso dell'applicazione.
    public void indietro() {
        throw new UnsupportedOperationException("ContattoController.indietro is not supported yet.");
    }

}
