/// @file ModificaContattoController.java
/// @brief Definisce la classe ModificaContattoController per la gestione delle operazioni di modifica e creazione di un contatto.
///
/// La classe `ModificaContattoController` fornisce metodi per aggiungere, modificare, salvare e annullare operazioni
/// sui contatti nella rubrica. Gestisce le modifiche ai dati di un contatto e consente di creare nuovi contatti.

package controller;

import model.*;
import ui.*;

/// @class ModificaContattoController
/// @brief Controller per la classe `ModificaContatto` del package `ui`.
///
/// La classe ModificaContattoController fornisce metodi per interagire con la rubrica dei contatti,
/// consentendo di aggiungere un nuovo contatto, modificare i dati di un contatto esistente, salvare
/// le modifiche apportate e annullare le operazioni in corso.
public class ModificaContattoController {
    private final ModificaContatto parent; ///< La schermata chiamante.
    private final Contatto vecchio; ///< Il contatto originale da modificare, o `null` se si sta creando un nuovo contatto.
    private final Contatto nuovo = new Contatto("NOME", "COGNOME"); ///< Il contatto che verrà salvato nella rubrica.

    /// @brief Costruttore del controller.
    /// @param parent La schermata chiamante.
    /// @param vecchio Il contatto da modificare (null se si sta creando un nuovo contatto).
    ///
    /// Inizializza il controller con il contatto da modificare o con un nuovo contatto.
    public ModificaContattoController(ModificaContatto parent, Contatto vecchio) {
        this.parent = parent;
        this.vecchio = vecchio;
    }

    /// @brief Restituisce il contatto attualmente in modifica.
    /// @return Il contatto originale da modificare, o `null` se si sta creando un nuovo contatto.
    public Contatto getContatto() {
        return vecchio;
    }

    /// @brief Aggiunge un nuovo contatto alla rubrica.
    ///
    /// Questo metodo aggiunge il contatto appena creato alla rubrica
    /// e passa alla schermata di visualizzazione del contatto aggiunto.
    public void aggiungi() {
        Rubrica.aggiungi(nuovo);
        Finestra.mostraContatto(nuovo);
    }

    /// @brief Modifica un contatto esistente nella rubrica.
    ///
    /// Questo metodo aggiorna un contatto già esistente nella rubrica,
    /// sostituendo il contatto originale con quello modificato e
    /// passando alla schermata di visualizzazione del contatto aggiornato.
    public void modifica() {
        Rubrica.modifica(vecchio, nuovo);
        Finestra.mostraContatto(nuovo);
    }

    /// @brief Annulla l'operazione in corso.
    ///
    /// Se si sta creando un nuovo contatto, annulla la creazione.
    /// Se si sta modificando un contatto esistente, annulla la modifica.
    public void annulla() {
        if (vecchio == null)
            annullaCreazione();
        else
            annullaModifica();
    }

    /// @brief Annulla la modifica di un contatto esistente.
    ///
    /// Ripristina lo stato precedente della rubrica senza apportare modifiche.
    private void annullaModifica() {
        Finestra.mostraContatto(vecchio);
    }

    /// @brief Annulla la creazione di un nuovo contatto.
    ///
    /// Ripristina lo stato precedente della rubrica senza apportare modifiche.
    private void annullaCreazione() {
        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

    /// @brief Salva le modifiche apportate al contatto.
    ///
    /// Questo metodo aggiorna il contatto con i dati forniti dalla schermata chiamante.
    /// Se il contatto è nuovo, lo aggiunge alla rubrica. Se il contatto è esistente, lo modifica.
    /// In caso di errore, mostra un messaggio di errore.
    public void salvaModifiche() {
        try {
            nuovo.setNome(parent.getNome());
            nuovo.setCognome(parent.getCognome());
            nuovo.setTag(parent.getTag());
            nuovo.setTelefono(0, parent.getTelefono(0));
            nuovo.setTelefono(1, parent.getTelefono(1));
            nuovo.setTelefono(2, parent.getTelefono(2));
            nuovo.setEmail(0, parent.getEmail(0));
            nuovo.setEmail(1, parent.getEmail(1));
            nuovo.setEmail(2, parent.getEmail(2));

            if (vecchio == null) {
                if (Rubrica.getContatti().contains(nuovo)) {
                    Finestra.mostraErrore("Il contatto è già contenuto in rubrica.");
                    return;
                }
                aggiungi();
            } else {
                if (Rubrica.getContatti().contains(nuovo) && !vecchio.equals(nuovo)) {
                    Finestra.mostraErrore("Il contatto è già contenuto in rubrica.");
                    return;
                }
                modifica();
            }

        } catch (ContattoNonValidoException | EmailNonValidaException e) {
            Finestra.mostraErrore(e.getMessage());
        }
    }
}