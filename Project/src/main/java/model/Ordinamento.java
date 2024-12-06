/// @file Ordinamento.java
/// @brief Classe per la configurazione del criterio di ordinamento dei contatti.
///
/// La classe Ordinamento permette di gestire il criterio di ordinamento utilizzato per i contatti,
/// consentendo di scegliere tra l'ordinamento per nome e quello per cognome. Include metodi per
/// verificare, configurare e invertire il criterio di ordinamento.

package model;

/// @class Ordinamento
/// @brief Classe per la gestione dinamica del criterio di ordinamento dei contatti.
///
/// La classe `Ordinamento` definisce un criterio globale per il confronto e l'ordinamento
/// dei contatti. Permette di scegliere tra l'ordinamento per nome e quello per cognome.
/// Questa configurazione viene utilizzata da altre classi, come `Contatto`, per determinare
/// l'ordine in cui i contatti vengono ordinati o confrontati.
public class Ordinamento {

    private static boolean ordinamentoPerNome = true; ///< Criterio attuale: true per ordinamento per nome, false per cognome.

    /// @brief Restituisce il criterio di ordinamento corrente.
    /// @return true se l'ordinamento è basato sul nome, false se è basato sul cognome.
    public static boolean isOrdinamentoPerNome() {
        return ordinamentoPerNome;
    }

    /// @brief Imposta un nuovo criterio di ordinamento.
    /// @param ordinamentoPerNome true per ordinare i contatti in base al nome, false per ordinare in base al cognome.
    public static void setOrdinamento(boolean ordinamentoPerNome) {
        Ordinamento.ordinamentoPerNome = ordinamentoPerNome;
        Rubrica.riordina();
    }

    /// @brief Inverte il criterio di ordinamento corrente.
    ///
    /// Se l'ordinamento corrente è per nome, lo cambia in per cognome e viceversa.
    public static void cambiaOrdinamento() {
        ordinamentoPerNome = !ordinamentoPerNome;
        Rubrica.riordina();
    }

}