package controller;

import model.*;

/// @file ModificaContattoController.java
/// @brief Definisce la classe ModificaContattoController per la gestione delle operazioni di modifica dei contatti.
/// 
/// La classe `ModificaContattoController` fornisce metodi per aggiungere, modificare e annullare operazioni
/// sui contatti nella rubrica. Gestisce le modifiche ai dati di un contatto e la possibilità di annullare
/// operazioni in corso.

/// @class ModificaContattoController
/// @brief Classe che gestisce le operazioni di modifica di un contatto nella rubrica.
/// 
/// La classe `ModificaContattoController` fornisce metodi per interagire con la rubrica dei contatti,
/// consentendo di aggiungere un nuovo contatto, modificare i dati di un contatto esistente, e annullare
/// le operazioni in corso.
public class ModificaContattoController {

    /// @brief Aggiunge un nuovo contatto alla rubrica.
    /// @param c Il contatto da aggiungere alla rubrica.
    /// 
    /// Questo metodo consente di aggiungere un nuovo contatto all'interno della rubrica,
    /// inserendo tutti i dettagli forniti nell'oggetto `Contatto` passato come parametro.
    public void aggiungi(Contatto c) {
        throw new UnsupportedOperationException("ModificaContattoController.aggiungi is not supported yet.");
    }

    /// @brief Modifica un contatto esistente nella rubrica.
    /// @param vecchio Il contatto da modificare.
    /// @param nuovo Il contatto con i nuovi dati da applicare.
    /// 
    /// Questo metodo permette di aggiornare un contatto già esistente nella rubrica.
    /// I dati del contatto esistente, specificato come `vecchio`, vengono sostituiti
    /// con quelli contenuti nell'oggetto `nuovo`.
    public void modifica(Contatto vecchio, Contatto nuovo) {
        throw new UnsupportedOperationException("ModificaContattoController.modifica is not supported yet.");
    }

    /// @brief Annulla l'operazione corrente.
    /// 
    /// Questo metodo permette di annullare l'operazione in corso, ripristinando lo stato
    /// precedente della rubrica, senza apportare modifiche ai contatti.
    public void annulla() {
        throw new UnsupportedOperationException("ModificaContattoController.annulla is not supported yet.");
    }

}
