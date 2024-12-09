/// @file Finestra.java
/// @brief Definisce l'interfaccia grafica principale dell'applicazione.
///
/// La classe Finestra estende JFrame e rappresenta la finestra principale
/// dell'applicazione. Gestisce il cambio di schermate e la visualizzazione
/// di dialoghi per la conferma o la selezione di percorsi.

package ui;

import java.util.List;
import model.*;
import javax.swing.*;

/// @class Finestra
/// @brief Classe che rappresenta la finestra principale dell'interfaccia grafica.
///
/// La classe Finestra gestisce la visualizzazione delle schermate principali
/// e dei dialoghi di conferma o selezione del percorso. Ogni schermata è un JPanel
/// fornito dalle classi corrispondenti nel package "ui".
public class Finestra {
    private final static JFrame finestra = new JFrame(); ///< Il frame che mostra la finestra
    private static JPanel schermata = new JPanel(); ///< Il pannello attualmente visualizzato nella finestra.

    /// @brief Costruttore della finestra principale.
    ///
    /// Inizializza la finestra principale dell'applicazione e configura le impostazioni
    /// di base per la GUI, come dimensioni e layout. La schermata iniziale viene impostata
    /// automaticamente.
    public static void start() {
        finestra.setTitle("RUBRICAPP");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mostraVediRubrica(Rubrica.getContatti());
        finestra.setVisible(true);
    }

    /// @brief Mostra la schermata "VediRubrica".
    public static void mostraVediRubrica(List<Contatto> contatti) {
        schermata = new VediRubrica(contatti).getSchermata();
        finestra.setContentPane(schermata);
    }

    /// @brief Mostra la schermata "VediContatto".
    /// @param contatto Contatto da visualizzare.
    ///
    /// Cambia la schermata visualizzata con una schermata che mostra i dettagli
    /// completi del contatto specificato.
    public static void mostraContatto(Contatto contatto) {
        schermata = new VediContatto(contatto).getSchermata();
        finestra.setContentPane(schermata);
    }

    /// @brief Mostra la schermata "ModificaContatto".
    /// @param contatto Contatto da modificare.
    ///
    /// Cambia la schermata attualmente visualizzata con una schermata che consente
    /// di modificare i dettagli del contatto specificato.
    public static void mostraModificaContatto(Contatto contatto) {
        schermata = new ModificaContatto(contatto).getSchermata();
        finestra.setContentPane(schermata);
    }

    /// @brief Mostra una finestra di dialogo per confermare un'azione.
    /// @param messaggio Il messaggio da visualizzare nella finestra di dialogo.
    /// @return true se l'utente clicca su "Conferma", false se clicca su "Annulla".
    ///
    /// Questo metodo utilizza un JOptionPane per mostrare una finestra di dialogo
    /// modale con un messaggio personalizzato e due opzioni: "Conferma" e "Annulla".
    /// La finestra di dialogo blocca l'interazione con il resto dell'applicazione
    /// finché non viene chiusa.
    public static boolean chiediConferma(String messaggio) {
        String[] opzioni = {"Conferma", "Annulla"};

        int scelta = JOptionPane.showOptionDialog(
                finestra,                       // Finestra chiamante
                messaggio,                      // Messaggio da mostrare
                "Conferma",                     // Titolo della finestra
                JOptionPane.YES_NO_OPTION,      // Opzioni disponibili
                JOptionPane.QUESTION_MESSAGE,   // Icona da visualizzare
                null,                           // Icona personalizzata
                opzioni,                        // Testi dei pulsanti
                opzioni[1]                      // Scelta predefinita
        );

        return scelta == JOptionPane.YES_OPTION;
    }

    /// @brief Mostra una finestra di dialogo per selezionare un file da importare.
    /// @return Il percorso del file selezionato, oppure null se l'utente annulla la selezione.
    ///
    /// Questo metodo utilizza un JFileChooser configurato per selezionare solo file.
    public static String chiediPercorsoImport() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleziona un file da importare");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int scelta = fileChooser.showOpenDialog(finestra);

        if (scelta == JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile().getAbsolutePath();

        return null;
    }

    /// @brief Mostra una finestra di dialogo per selezionare un percorso per esportare/salvare un file.
    /// @return Il percorso selezionato, oppure null se l'utente annulla la selezione.
    ///
    /// Questo metodo utilizza un JFileChooser configurato per consentire la selezione
    /// o la specifica di un file per operazioni di salvataggio.
    public static String chiediPercorsoExport() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleziona un percorso per salvare la rubrica");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int scelta = fileChooser.showSaveDialog(finestra);

        if (scelta == JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile().getAbsolutePath();

        return null;
    }

    /// @brief Mostra una finestra di dialogo per notificare un errore.
    /// @param errore Il messaggio di errore da visualizzare.
    ///
    /// Questo metodo utilizza un JOptionPane per mostrare una finestra
    /// di errore con un messaggio e un'icona.
    public static void mostraErrore(String errore) {
        // Mostra una finestra di dialogo con il messaggio di errore
        JOptionPane.showMessageDialog(
                finestra,                   // Finestra chiamante
                errore,                     // Messaggio da mostrare
                "Errore",                   // Titolo della finestra
                JOptionPane.ERROR_MESSAGE   // Tipo di messaggio
        );
    }

}