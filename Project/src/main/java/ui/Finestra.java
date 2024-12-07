/// @file Finestra.java
/// @brief Definisce l'interfaccia grafica principale dell'applicazione.
///
/// La classe Finestra estende JFrame e rappresenta la finestra principale
/// dell'applicazione. Gestisce il cambio di schermate e la visualizzazione
/// di dialoghi per la conferma o la selezione di percorsi.

package ui;

import model.*;
import javax.swing.*;

/// @class Finestra
/// @brief Classe che rappresenta la finestra principale dell'interfaccia grafica.
///
/// La classe Finestra gestisce la visualizzazione delle schermate principali
/// e dei dialoghi di conferma o selezione del percorso. Ogni schermata è un JPanel
/// fornito dalle classi corrispondenti nel package "Ui".
public class Finestra extends JFrame {

    private JPanel schermata = new JPanel(); ///< Il pannello attualmente visualizzato nella finestra.

    /// @brief Costruttore della finestra principale.
    ///
    /// Inizializza la finestra principale dell'applicazione e configura le impostazioni
    /// di base per la GUI, come dimensioni e layout. La schermata iniziale viene impostata
    /// automaticamente.
    public Finestra() {
        setTitle("RUBRICAPP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        mostraVediRubrica();
        setVisible(true);
    }

    /// @brief Mostra la schermata "VediRubrica".
    public void mostraVediRubrica() {
        VediRubrica v = new VediRubrica();
        schermata = v.getSchermata();
        setContentPane(schermata);
    }

    /// @brief Mostra la schermata "VediContatto".
    /// @param c Contatto da visualizzare.
    ///
    /// Cambia la schermata visualizzata con una schermata che mostra i dettagli
    /// completi del contatto specificato.
    public void mostraContatto(Contatto c) {
        VediContatto v = new VediContatto(c);
        schermata = v.getSchermata();
        setContentPane(schermata);
    }

    /// @brief Mostra la schermata "ModificaContatto".
    /// @param c Contatto da modificare.
    ///
    /// Cambia la schermata attualmente visualizzata con una schermata che consente
    /// di modificare i dettagli del contatto specificato.
    public void mostraModificaContatto(Contatto c) {
        ModificaContatto v = new ModificaContatto(c);
        schermata = v.getSchermata();
        setContentPane(schermata);
    }

    /// @brief Mostra una finestra di dialogo per confermare un'azione.
    ///
    /// Questo metodo mostra un messaggio di dialogo che richiede conferma
    /// per un'operazione (ad esempio, eliminazione o salvataggio). L'implementazione
    /// prevede l'uso di una finestra di dialogo predefinita di Swing.
    public void chiediConferma() {
        throw new UnsupportedOperationException("Finestra.chiediConferma is not supported yet.");
    }

    /// @brief Mostra una finestra di dialogo per selezionare un percorso o un file.
    ///
    /// Questo metodo apre una finestra di dialogo che consente di selezionare
    /// un percorso o un file da utilizzare per operazioni come il caricamento
    /// o il salvataggio dei dati. L'implementazione prevede l'uso di una
    /// finestra JFileChooser.
    public void chiediPercorso() {
        throw new UnsupportedOperationException("Finestra.chiediPercorso is not supported yet.");
    }

}