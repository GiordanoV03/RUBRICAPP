package controller;

import model.*;

/// @file RubricaController.java
/// @brief Definisce la classe RubricaController per la gestione delle operazioni sulla rubrica.
/// 
/// La classe `RubricaController` fornisce metodi per visualizzare, cercare, aggiungere, modificare,
/// eliminare e ordinare i contatti all'interno della rubrica. Supporta anche l'importazione ed esportazione
/// della rubrica da e verso un file.

/// @class RubricaController
/// @brief Classe che gestisce le operazioni relative alla rubrica dei contatti.
/// 
/// La classe `RubricaController` fornisce metodi per visualizzare la rubrica, cercare contatti, 
/// aggiungere, modificare e selezionare contatti, nonché esportare e importare la rubrica da file.
public class RubricaController {

    /// @brief Visualizza tutti i contatti della rubrica.
    /// 
    /// Questo metodo permette di visualizzare l'intero gruppo di contatti salvati nella rubrica,
    /// mostrando le informazioni disponibili per ciascun contatto.
    public void visualizza() {
        throw new UnsupportedOperationException("RubricaController.visualizza is not supported yet.");
    }

    /// @brief Cambia l'ordinamento dei contatti.
    /// 
    /// Questo metodo consente di cambiare l'ordinamento della rubrica: si può alternare tra ordinamento per nome
    /// e ordinamento per cognome.
    public void cambiaOrdinamento() {
        throw new UnsupportedOperationException("RubricaController.cambiaOrdinamento is not supported yet.");
    }

    /// @brief Aggiunge un contatto alla rubrica.
    /// 
    /// Questo metodo permette di aggiungere un nuovo contatto alla rubrica. Il contatto verrà inserito nella posizione
    /// corretta in base all'ordinamento scelto (per nome o cognome).
    public void aggiungiContatto() {
        throw new UnsupportedOperationException("RubricaController.aggiungiContatto is not supported yet.");
    }

    /// @brief Visualizza le informazioni di un singolo contatto.
    /// @param c Il contatto di cui visualizzare le informazioni.
    /// 
    /// Questo metodo permette di vedere in dettaglio le informazioni di un singolo contatto, come nome, cognome,
    /// numeri di telefono ed email.
    public void vediContatto(Contatto c) {
        throw new UnsupportedOperationException("RubricaController.vediContatto is not supported yet.");
    }

    /// @brief Cerca un contatto nella rubrica.
    /// @param stringa La sottostringa da cercare nel nome, cognome o tag del contatto.
    /// 
    /// Questo metodo permette di cercare contatti all'interno della rubrica tramite una sottostringa che viene
    /// confrontata con i campi nome, cognome o tag di ciascun contatto.
    public void cerca(String stringa) {
        throw new UnsupportedOperationException("RubricaController.cerca is not supported yet.");
    }

    /// @brief Seleziona un contatto dalla ricerca.
    /// @param c Il contatto da selezionare.
    /// 
    /// Questo metodo consente di selezionare un contatto trovato tramite la ricerca, permettendo di visualizzare
    /// i suoi dettagli.
    public void selezionaContatto(Contatto c) {
        throw new UnsupportedOperationException("RubricaController.selezionaContatto is not supported yet.");
    }

    /// @brief Elimina uno o più contatti dalla rubrica.
    /// 
    /// Questo metodo consente di eliminare uno o più contatti selezionati dalla rubrica.
    public void eliminaContatti() {
        throw new UnsupportedOperationException("RubricaController.eliminaContatti is not supported yet.");
    }

    /// @brief Importa la rubrica da un file.
    /// 
    /// Questo metodo permette di importare l'intera rubrica da un file precedentemente salvato.
    public void importa() {
        throw new UnsupportedOperationException("RubricaController.importa is not supported yet.");
    }

    /// @brief Esporta la rubrica su un file.
    /// 
    /// Questo metodo consente di salvare l'intera rubrica su un file, esportando i dati in un formato specifico.
    public void salva() {
        throw new UnsupportedOperationException("RubricaController.salva is not supported yet.");
    }

    /// @brief Esporta la rubrica su un file con un nome personalizzato.
    /// 
    /// Questo metodo consente di salvare la rubrica su un file specificando un nome, permettendo di rinominare
    /// il file durante l'esportazione.
    public void salvaConNome() {
        throw new UnsupportedOperationException("RubricaController.salvaConNome is not supported yet.");
    }

}
