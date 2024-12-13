/// @file RubricaController.java
/// @brief Definisce la classe RubricaController per la gestione delle operazioni sulla rubrica.
///
/// La classe RubricaController fornisce metodi per visualizzare, cercare, aggiungere, modificare,
/// eliminare e ordinare i contatti all'interno della rubrica. Supporta anche l'importazione ed esportazione
/// della rubrica da e verso un file.

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.*;
import ui.Finestra;

/// @class RubricaController
/// @brief Classe che gestisce le operazioni relative alla rubrica dei contatti.
///
/// La classe RubricaController fornisce metodi per visualizzare la rubrica, cercare contatti,
/// aggiungere, modificare e selezionare contatti, nonché esportare e importare la rubrica da file.
public class RubricaController {
    private final List<Contatto> contatti;    ///< La lista di contatti sulla quale effettuare le operazioni.
    
    /// @brief Costruttore del controller.
    /// @param contatti La lista di contatti.
    ///
    /// Inizializza il controller.
    public RubricaController(List<Contatto> contatti){
        this.contatti = contatti;
    }

    /// @brief Restituisce la lista dei contatti.
    /// @return La lista dei contatti usata nel costruttore.
    public List<Contatto> getContatti() {
        return contatti;
    }

    /// @brief Visualizza tutti i contatti della rubrica.
    ///
    /// Questo metodo permette di visualizzare l'intero
    /// gruppo di contatti salvati nella rubrica,
    /// mostrando le informazioni disponibili
    /// per ciascun contatto.
    public void visualizza() {
        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

    /// @brief Cambia l'ordinamento dei contatti.
    ///
    /// Questo metodo consente di cambiare l'ordinamento
    /// della rubrica: si può alternare tra ordinamento
    /// per nome e per cognome.
    public void cambiaOrdinamento(boolean ordinamentoPerNome) {
        Ordinamento.setOrdinamento(ordinamentoPerNome);
        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

    /// @brief Aggiunge un contatto alla rubrica.
    ///
    /// Questo metodo passa alla schermata
    /// per aggiungere un nuovo contatto
    /// alla rubrica.
    public void aggiungiContatto() {
        Finestra.mostraModificaContatto(null);
    }

    /// @brief Cerca un contatto nella rubrica.
    /// @param stringa La sottostringa da cercare nel nome, cognome o tag del contatto.
    ///
    /// Questo metodo permette di cercare contatti all'interno
    /// della rubrica tramite una sottostringa che viene
    /// confrontata con i campi nome, cognome o tag
    /// di ciascun contatto.
    public void cerca(String stringa) {
        if(stringa.isEmpty()){
            Finestra.mostraVediRubrica(Rubrica.getContatti());
        }else{
            Finestra.mostraVediRubrica(Rubrica.cerca(stringa));
        }
    }

    /// @brief Elimina uno o più contatti dalla rubrica.
    ///
    /// Questo metodo consente di eliminare uno o più
    /// contatti selezionati dalla rubrica.
    public void eliminaContatti() {
        List<Contatto> contatti = Rubrica.getContatti();
        List<Contatto> contattiSelezionati = new ArrayList<>();

        for (Contatto c : contatti)
            if (c.isSelezionato()) contattiSelezionati.add(c);

        for (Contatto c : contattiSelezionati)
            Rubrica.rimuovi(c);

        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

    /// @brief Importa la rubrica da un file.
    ///
    /// Questo metodo permette di importare l'intera
    /// rubrica da un file precedentemente salvato.
    public void importa() {
        String nomeFile = Finestra.chiediPercorsoImport();

        if(nomeFile == null) 
            return;
        
        List<Contatto> contatti = null;

        try {
            contatti = FileIO.apri(nomeFile);
        } catch (IOException | FileNonValidoException e) {
            Finestra.mostraErrore("Non è stato possibile importare la rubrica.");
            return;
        }

        Rubrica.svuota();
        for (Contatto c : contatti)
            Rubrica.aggiungi(c);

        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

    /// @brief Esporta la rubrica su un file con un nome personalizzato.
    ///
    /// Questo metodo consente di salvare la rubrica su un file
    /// specificando un nome.
    public void esporta() {
        
        String nomeFile = Finestra.chiediPercorsoExport();
        if(nomeFile == null)
            return;
        try {
            FileIO.salva(nomeFile);
        } catch (IOException e) {
            Finestra.mostraErrore("Non è stato possibile salvare la rubrica.");
        }
    }

}