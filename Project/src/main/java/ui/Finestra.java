/// @file Finestra.java
/// @brief Gestisce l'interfaccia grafica principale dell'applicazione.
///
/// La classe Finestra rappresenta la finestra principale dell'applicazione,
/// gestendo la visualizzazione delle schermate principali, dei dialoghi di conferma,
/// e della selezione dei percorsi per importazione/esportazione file.

package ui;

import model.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;

/// @class Finestra
/// @brief Classe che rappresenta e gestisce la finestra principale dell'applicazione.
///
/// La classe Finestra utilizza JFrame per creare e configurare la finestra principale.
/// Fornisce metodi statici per cambiare schermata, visualizzare dialoghi di conferma,
/// e interagire con il filesystem tramite selezione di percorsi. Ogni schermata è
/// rappresentata da un JPanel e viene gestita dinamicamente.
public class Finestra {
    private final static JFrame finestra = new JFrame(); ///< Il Frame principale dell'applicazione.
    private static JPanel schermata = new JPanel(); ///< La schermata attualmente visualizzata.
    private static int larghezza; ///< Larghezza della finestra.
    private static int altezza; ///< Altezza della finestra.

    /// @brief Avvia la finestra principale dell'applicazione.
    ///
    /// Configura le impostazioni di base della GUI, come dimensioni e layout,
    ///  e visualizza la schermata iniziale "VediRubrica" con i contatti correnti.
    public static void start() {
        finestra.setTitle("RUBRICAPP");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();
        larghezza = schermo.width;
        altezza = schermo.height;

        mostraVediRubrica(Rubrica.getContatti());
        finestra.setVisible(true);
    }

    /// @brief Restituisce la larghezza della finestra principale.
    /// @return Larghezza della finestra principale in pixel.
    public static int getLarghezza() {
        return larghezza;
    }

    /// @brief Restituisce l'altezza della finestra principale.
    /// @return Altezza della finestra principale in pixel.
    public static int getAltezza() {
        return altezza;
    }

    /// @brief Mostra il pannello attuale nella finestra principale.
    private static void mostraSchermata() {
        finestra.setContentPane(schermata);
        finestra.revalidate();
        finestra.repaint();
    }

    /// @brief Mostra la schermata "VediRubrica".
    /// @param contatti Lista di contatti da visualizzare nella rubrica.
    public static void mostraVediRubrica(List<Contatto> contatti) {
        schermata = new VediRubrica(contatti).getSchermata();
        mostraSchermata();
    }

    /// @brief Mostra la schermata "VediContatto".
    /// @param contatto Contatto i cui dettagli devono essere visualizzati.
    public static void mostraContatto(Contatto contatto) {
        schermata = new VediContatto(contatto).getSchermata();
        mostraSchermata();
    }

    /// @brief Mostra la schermata "ModificaContatto".
    /// @param contatto Contatto da modificare.
    public static void mostraModificaContatto(Contatto contatto) {
        schermata = new ModificaContatto(contatto).getSchermata();
        mostraSchermata();
    }

    /// @brief Mostra un dialogo per confermare un'azione specifica.
    /// @param messaggio Messaggio da visualizzare nella finestra di dialogo.
    /// @return true se l'utente conferma l'azione, false altrimenti.
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

    /// @brief Mostra un dialogo per selezionare un file da importare.
    /// @return Percorso del file selezionato, oppure null se l'utente annulla.
    public static String chiediPercorsoImport() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleziona un file da importare");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int scelta = fileChooser.showOpenDialog(finestra);

        if (scelta == JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile().getAbsolutePath();

        return null;
    }

    /// @brief Mostra un dialogo per selezionare un percorso per salvare un file.
    /// @return Percorso selezionato, oppure null se l'utente annulla.
    public static String chiediPercorsoExport() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleziona un percorso per salvare la rubrica");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int scelta = fileChooser.showSaveDialog(finestra);

        if (scelta == JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile().getAbsolutePath();

        return null;
    }

    /// @brief Mostra un dialogo per notificare un errore.
    /// @param messaggio Messaggio di errore da visualizzare.
    public static void mostraErrore(String messaggio) {
        JOptionPane.showMessageDialog(
                finestra,                   // Finestra chiamante
                messaggio,                  // Messaggio da mostrare
                "Errore",                   // Titolo della finestra
                JOptionPane.ERROR_MESSAGE   // Tipo di messaggio
        );
    }
}