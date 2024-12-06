/// @file Rubrica.java
/// @brief Definisce la classe Rubrica per la gestione di una raccolta di contatti.
///
/// La classe Rubrica rappresenta un'entità che memorizza e gestisce un insieme
/// di contatti. Supporta operazioni di aggiunta, rimozione, modifica, ricerca e
/// esportazione dei contatti.

package model;

import java.util.Set;

/// @class Rubrica
/// @brief Classe per la gestione di una rubrica di contatti.
///
/// Questa classe consente di memorizzare e gestire una raccolta di oggetti
/// Contatto. Supporta operazioni comuni come l'aggiunta, la rimozione, la modifica,
/// l'esportazione e la ricerca di contatti. I contatti possono essere ordinati
/// secondo criteri definiti dalla classe Ordinamento.
public class Rubrica {

    private Set<Contatto> contatti; ///< Insieme di contatti nella rubrica.

    /// @brief Costruttore che crea una rubrica vuota con un ordinamento specifico.
    /// @param o Il criterio di ordinamento da utilizzare.
    public Rubrica(Ordinamento o) {
        throw new UnsupportedOperationException("Rubrica constructor (Ordinamento o) is not supported yet.");
    }

    /// @brief Costruttore che inizializza una rubrica con un insieme di contatti e un ordinamento.
    /// @param contatti Insieme iniziale di contatti.
    /// @param o Il criterio di ordinamento da utilizzare.
    public Rubrica(Set<Contatto> contatti, Ordinamento o) {
        throw new UnsupportedOperationException("Rubrica constructor (Set<Contatto> contatti, Ordinamento o) is not supported yet.");
    }

    /// @brief Restituisce l'insieme di contatti presenti nella rubrica.
    /// @return Un set di oggetti Contatto.
    public Set<Contatto> getContatti() {
        throw new UnsupportedOperationException("Rubrica.getContatti is not supported yet.");
    }

    /// @brief Aggiunge un nuovo contatto alla rubrica.
    /// @param c Il contatto da aggiungere.
    public void aggiungi(Contatto c) {
        throw new UnsupportedOperationException("Rubrica.aggiungi is not supported yet.");
    }

    /// @brief Rimuove un contatto dalla rubrica.
    /// @param c Il contatto da rimuovere.
    public void rimuovi(Contatto c) {
        throw new UnsupportedOperationException("Rubrica.rimuovi is not supported yet.");
    }

    /// @brief Modifica un contatto esistente nella rubrica.
    /// @param vecchio Il contatto da modificare.
    /// @param nuovo Il nuovo contatto con cui sostituire quello esistente.
    public void modifica(Contatto vecchio, Contatto nuovo) {
        throw new UnsupportedOperationException("Rubrica.modifica is not supported yet.");
    }

    /// @brief Esporta i dati dei contatti in formato testuale.
    /// @return Stringa contenente i dati esportati dei contatti.
    ///
    /// Questo metodo consente di ottenere una rappresentazione testuale
    /// di tutti i contatti presenti nella rubrica, utile per l'esportazione 
    /// su un file di testo.
    public String esporta() {
        throw new UnsupportedOperationException("Rubrica.esporta is not supported yet.");
    }

    /// @brief Cerca contatti che contengono una specifica stringa nei loro nome e cognome o tag.
    /// @param stringa La stringa da cercare nei contatti.
    /// @return Un set di contatti che corrispondono alla ricerca.
    ///
    /// La ricerca viene effettuata sui campi rilevanti (ad esempio, nome, cognome
    /// o tag) e restituisce i contatti che contengono
    /// la stringa specificata.
    public Set<Contatto> cerca(String stringa) {
        throw new UnsupportedOperationException("Rubrica.cerca is not supported yet.");
    }
}
