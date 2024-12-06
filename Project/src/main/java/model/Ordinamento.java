package model;

import java.util.Comparator;

/// @file Ordinamento.java
/// @brief Definisce la classe Ordinamento per il confronto e l'ordinamento dei contatti.
///
/// Questa classe implementa un comparatore per ordinare i contatti in base al nome o al cognome.
/// Fornisce metodi per configurare il criterio di ordinamento e per invertirlo.

/// @class Ordinamento
/// @brief Classe che implementa un comparatore per i contatti.
///
/// La classe Ordinamento consente di confrontare due contatti e ordinarli in base al criterio
/// configurato. Supporta il confronto per nome o per cognome e permette di cambiare dinamicamente
/// il criterio di ordinamento.
public class Ordinamento implements Comparator<Contatto> {
    private boolean ordinamentoPerNome; ///< Indica se l'ordinamento avviene per nome (true) o per cognome (false).

    /// @brief Costruttore predefinito della classe Ordinamento.
    ///
    /// Inizializza un oggetto Ordinamento con il criterio di ordinamento predefinito.
    public Ordinamento() {
        throw new UnsupportedOperationException("Ordinamento constructor is not supported yet.");
    }

    /// @brief Verifica il criterio di ordinamento attuale.
    /// @return true se l'ordinamento è per nome, false se è per cognome.
    public boolean isOrdinamentoPerNome() {
        throw new UnsupportedOperationException("Ordinamento.isOrdinamentoPerNome is not supported yet.");
    }

    /// @brief Imposta il criterio di ordinamento.
    /// @param ordinamentoPerNome true per ordinare per nome, false per ordinare per cognome.
    public void setOrdinamento(boolean ordinamentoPerNome) {
        throw new UnsupportedOperationException("Ordinamento.setOrdinamento is not supported yet.");
    }

    /// @brief Inverte il criterio di ordinamento corrente.
    ///
    /// Questo metodo cambia il criterio di ordinamento tra nome e cognome.
    public void cambiaOrdinamento() {
        throw new UnsupportedOperationException("Ordinamento.cambiaOrdinamento is not supported yet.");
    }

    /// @brief Confronta due contatti in base al criterio di ordinamento attuale.
    /// @param o1 Il primo contatto da confrontare.
    /// @param o2 Il secondo contatto da confrontare.
    /// @return Un valore negativo, zero o positivo in base al risultato del confronto:
    /// - Negativo se o1 è "minore" di o2,
    /// - Positivo se o1 è "maggiore" di o2,
    /// - o1.compareTo(o2) se o1 è uguale a o2.
    @Override
    public int compare(Contatto o1, Contatto o2) {
        throw new UnsupportedOperationException("Ordinamento.compare is not supported yet.");
    }

}