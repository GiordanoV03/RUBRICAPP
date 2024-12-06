/// @file Rubrica.java
/// @brief Definisce la classe Rubrica per la gestione di una raccolta di contatti.
///
/// La classe `Rubrica` rappresenta una rubrica che memorizza e gestisce un insieme
/// di contatti. Permette di eseguire operazioni comuni come l'aggiunta, la rimozione,
/// la modifica, la ricerca e l'esportazione dei contatti. I contatti sono ordinati
/// secondo il criterio definito nella classe `Ordinamento`.

package model;

import java.util.Set;
import java.util.TreeSet;

/// @class Rubrica
/// @brief Classe per la gestione di una rubrica di contatti.
///
/// La classe `Rubrica` fornisce un contenitore per gestire un insieme di oggetti
/// `Contatto`. Supporta l'aggiunta, la rimozione, la modifica, la ricerca di contatti,
/// nonché l'esportazione dei dati in formato testuale. I contatti all'interno della rubrica
/// sono mantenuti in ordine, rispettando il criterio di ordinamento configurato nella
/// classe `Ordinamento`.
public class Rubrica {
    private static Set<Contatto> contatti = new TreeSet<>(); ///< Insieme di contatti nella rubrica.

    /// @brief Riordina i contatti nella rubrica.
    ///
    /// Questo metodo riordina l'insieme di contatti secondo il criterio di ordinamento
    /// attualmente configurato nella classe `Ordinamento`.
    public static void riordina() {
        Set<Contatto> nuovo = new TreeSet<>();
        nuovo.addAll(contatti);
        contatti = nuovo;
    }

    /// @brief Restituisce l'insieme di contatti presenti nella rubrica.
    /// @return Un set di oggetti `Contatto` che rappresentano tutti i contatti presenti
    ///         nella rubrica.
    public static Set<Contatto> getContatti() {
        return contatti;
    }

    /// @brief Aggiunge un nuovo contatto alla rubrica.
    /// @param c Il contatto da aggiungere alla rubrica.
    public static void aggiungi(Contatto c) {
        contatti.add(c);
    }

    /// @brief Rimuove un contatto dalla rubrica.
    /// @param c Il contatto da rimuovere dalla rubrica.
    public static void rimuovi(Contatto c) {
        contatti.remove(c);
    }

    /// @brief Modifica un contatto esistente nella rubrica.
    /// @param vecchio Il contatto da modificare.
    /// @param nuovo Il nuovo contatto con cui sostituire il contatto esistente.
    public static void modifica(Contatto vecchio, Contatto nuovo) {
        contatti.remove(vecchio);
        contatti.add(nuovo);
    }

    /// @brief Esporta i dati dei contatti in formato testuale.
    /// @return Una stringa contenente i dati esportati di tutti i contatti presenti
    ///         nella rubrica.
    ///
    /// Questo metodo restituisce una rappresentazione testuale dei contatti della rubrica,
    /// utile per l'esportazione dei dati su un file di testo.
    public static String esporta() {
        StringBuilder sb = new StringBuilder();
        for (Contatto c : contatti) {
            sb.append(c.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /// @brief Cerca contatti che contengono una specifica stringa nei loro nome, cognome o tag.
    /// @param stringa La stringa da cercare nei contatti.
    /// @return Un set di contatti che contengono la stringa specificata nei loro campi
    ///         di nome, cognome o tag.
    ///
    /// La ricerca avviene sui campi rilevanti dei contatti e restituisce un insieme di
    /// contatti che contengono la stringa specificata.
    public static Set<Contatto> cerca(String stringa) {
        Set<Contatto> trovati = new TreeSet<>();

        for(Contatto c : contatti){
            if(c.contiene(stringa.toUpperCase()))
                trovati.add(c);
        }

        return trovati;
    }
}