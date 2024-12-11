/// @file ModificaContattoController.java
/// @brief Definisce la classe ModificaContattoController per la gestione delle operazioni di modifica e creazione di un contatto.
///
/// La classe `ModificaContattoController` fornisce metodi per aggiungere, modificare e annullare operazioni
/// sui contatti nella rubrica. Gestisce le modifiche ai dati di un contatto e la possibilità di annullare
/// operazioni in corso.

package controller;

import model.*;
import ui.*;

/// @class ModificaContattoController
/// @brief Controller per la classe `ModificaContatto` del package `ui`.
///
/// La classe ModificaContattoController fornisce metodi per interagire con la rubrica dei contatti,
/// consentendo di aggiungere un nuovo contatto, modificare i dati di un contatto esistente, e annullare
/// le operazioni in corso.
public class ModificaContattoController {
    private ModificaContatto parent; ///< La schermata chiamante.
    private Contatto vecchio; ///< Il contatto originale da modificare, o `null` se si sta creando un nuovo contatto.
    private final Contatto nuovo = new Contatto("NOME", "COGNOME"); ///< Il contatto che verrà salvato nella rubrica.

    /// @brief Costruttore del controller.
    /// @param vecchio Il contatto da modificare (null se si sta creando un nuovo contatto).
    ///
    /// Inizializza il controller.
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
    /// Questo metodo aggiunge il contatto appena creato alla rubrica,
    /// poi passa alla schermata di visualizzazione del contatto
    /// appena aggiunto.
    public void aggiungi() {
        Rubrica.aggiungi(nuovo);
        Finestra.mostraContatto(nuovo);
    }

    /// @brief Modifica un contatto esistente nella rubrica.
    ///
    /// Questo metodo aggiorna un contatto già esistente nella rubrica,
    /// sostituendo il contatto originale con quello modificato,
    /// poi passa alla schermata di visualizzazione del contatto
    /// appena modificato.
    public void modifica() {
        Rubrica.modifica(vecchio, nuovo);
        Finestra.mostraContatto(nuovo);
    }

    /// @brief Annulla l'operazione in corso.
    ///
    /// Questo metodo verifica se si sta creando un contatto o
    /// modificando uno esistente, quindi sceglie il metodo
    /// corretto per passare alla giusta schermata.
    public void annulla() {
        if (vecchio == null)
            annullaCreazione();
        else
            annullaModifica();
    }

    /// @brief Annulla la modifica di un contatto esistente.
    ///
    /// Questo metodo annulla la modifica in corso,
    /// ripristinando lo stato precedente della rubrica,
    /// senza apportare modifiche al contatto.
    private void annullaModifica() {
        Finestra.mostraContatto(vecchio);
    }

    /// @brief Annulla la creazione di un nuovo contatto.
    ///
    /// Questo metodo annulla la creazione in corso,
    /// ripristinando lo stato precedente della rubrica,
    /// senza apportare modifiche a essa.
    private void annullaCreazione() {
        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

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

            if (vecchio == null)
                aggiungi();
            else
                modifica();

        } catch (ContattoNonValidoException | EmailNonValidaException e) {
            Finestra.mostraErrore(e.getMessage());
        }
    }

}