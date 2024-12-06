/// @file FileIO.java
/// @brief Gestione delle operazioni di input/output su file per i contatti.
///
/// La classe `FileIO` fornisce metodi statici per aprire e salvare i contatti da/verso un file.
/// Questi metodi permettono la gestione di una rubrica di contatti, consentendo operazioni
/// di apertura, salvataggio e impostazione del nome del file.
///

package model;

import java.util.Set;

/// @class FileIO
/// @brief Classe per la gestione delle operazioni di input/output su file.
///
/// La classe `FileIO` gestisce operazioni di input/output per salvare e caricare
/// un insieme di oggetti `Contatto` da o verso un file. Permette inoltre di specificare
/// il nome del file su cui lavorare.
public class FileIO {
    private static String nomePercorso; ///< Il percorso del file gestito.

    /// @brief Apre un file contenente una rubrica di contatti.
    /// @param nomefile Il nome del file da aprire.
    /// @return Un insieme di oggetti `Contatto` letti dal file.
    /// 
    /// Questo metodo apre un file precedentemente salvato contenente una lista di contatti,
    /// e restituisce un insieme di oggetti `Contatto` ricostruiti dai dati presenti nel file.
    public static Set<Contatto> apri(String nomefile) {
        throw new UnsupportedOperationException("FileIO.apri is not supported yet.");
    }

    /// @brief Imposta il nome del file da utilizzare per il salvataggio.
    /// @param nomefile Il nuovo nome del file da associare alla variabile `nomePercorso`.
    ///
    /// Questo metodo permette di cambiare il nome del file in cui verranno salvati o da cui verranno
    /// caricati i contatti. Modifica il percorso del file su cui le operazioni di salvataggio/apertura
    /// saranno eseguite in futuro.
    private static void setNomefile(String nomefile) {
        throw new UnsupportedOperationException("FileIO.setNomefile is not supported yet.");
    }

    /// @brief Salva un insieme di contatti in un file con un nome specifico.
    /// @param contatti L'insieme dei contatti da salvare.
    /// @param nomefile Il nome del file in cui salvare i contatti.
    ///
    /// Questo metodo permette di salvare una rubrica di contatti su un file il cui nome viene specificato
    /// come parametro. I contatti vengono salvati nel file in un formato predefinito.
    public static void salvaConNome(Set<Contatto> contatti, String nomefile) {
        throw new UnsupportedOperationException("FileIO.salvaConNome is not supported yet.");
    }

    /// @brief Salva un insieme di contatti nel file attualmente associato.
    /// @param contatti L'insieme dei contatti da salvare.
    ///
    /// Questo metodo salva la rubrica di contatti nel file associato alla variabile `nomePercorso`.
    /// Se il nome del file non è stato modificato, i contatti saranno salvati nel file di default.
    public static void salva(Set<Contatto> contatti) {
        throw new UnsupportedOperationException("FileIO.salva is not supported yet.");
    }
}
