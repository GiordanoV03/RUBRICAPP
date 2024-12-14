/// @file FileIO.java
/// @brief Gestione delle operazioni di input/output su file per i contatti.
///
/// La classe FileIO fornisce metodi statici per aprire e salvare i contatti da/verso un file.
/// Questi metodi permettono la gestione di una rubrica di contatti, consentendo operazioni
/// di apertura, salvataggio e impostazione del nome del file.
///

package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/// @class FileIO
/// @brief Classe per la gestione delle operazioni di input/output su file.
///
/// La classe FileIO gestisce operazioni di input/output per salvare e caricare
/// un insieme di oggetti Contatto da o verso un file. Permette inoltre di specificare
/// il nome del file su cui lavorare.
public class FileIO {

    /// @brief Apre un file contenente una rubrica di contatti.
    /// @param nomeFile nome del file da aprire.
    /// @return Un insieme di oggetti Contatto letti dal file.
    /// @throw IOException se ci sono errori con il BufferedReader o il FileReader
    /// @throw EmailNonValidaException se uno degli indirizzi email nel testo è malformato o non validi
    ///
    /// Questo metodo apre un file precedentemente salvato contenente una lista di contatti,
    /// e restituisce un insieme di oggetti Contatto ricostruiti dai dati presenti nel file.
    public static List<Contatto> apri(String nomeFile) throws IOException, FileNonValidoException {
        if (!isFileValido(nomeFile))
            throw new FileNonValidoException("Il file non è valido.");

        List<Contatto> contatti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            while (reader.ready()) {
                StringBuilder testo = new StringBuilder();

                for (int i = 0; i < 10; i++)
                    testo.append(reader.readLine()).append("\n");

                try {
                    contatti.add(new Contatto(testo.toString()));
                } catch(Exception e) {
                    throw new FileNonValidoException("ERRORE: Il file non valido.");
                }
            }
        }

        return contatti;
    }


    ///@brief Controlla che il file importato sia formattato nel modo giusto
    ///@param nomeFile nome del file da esaminare
    ///Questo metodo effettua vari controlli, prima verifica l'esistenza del file, successivamente
    private static boolean isFileValido(String nomeFile) {
        if (!(new File(nomeFile).exists())) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {

            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null)
                lines.add(line);

            // Se le righe non sono multiplo di 10, il file non è valido
            if (lines.size() % 10 != 0) return false;

            // Se ogni decima riga non c'è "***", il file non è valido
            for (int i = 9; i < lines.size(); i += 10)
                if (!lines.get(i).equals("***")) return false;

            // Se non è presente almeno uno tra nome o cognome, il file non è valido
            for (int i = 0; i < lines.size(); i++)
                if (i % 10 == 0 && lines.get(i).isEmpty() && lines.get(i+1).isEmpty())
                    return false;
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /// @brief Salva un insieme di contatti su un file.
    /// @param nomeFile Il percorso del file.
    /// @throw IOException se ci sono errori nel PrintWriter o nel FileWriter.
    /// @throw FileNonValidoException il nome del file non è impostato.
    /// Questo metodo salva la rubrica di contatti nel file passato come variabile.
    public static void salva(String nomeFile) throws IOException, FileNonValidoException {
        if (nomeFile == null || nomeFile.isEmpty())
            throw new FileNonValidoException("Nome file non valido.");
        try (PrintWriter scrivi = new PrintWriter(new FileWriter(nomeFile))) {
            scrivi.print(preparaTesto());
        }
    }

    /// @brief crea un formato testuale dei dati del contatto
    /// @return Una stringa contenente i dati esportati di tutti i contatti presenti
    ///         nella rubrica.
    /// Questo metodo restituisce una rappresentazione testuale dei contatti della rubrica,
    /// utile per l'esportazione dei dati su un file di testo.
    private static String preparaTesto() {
        List<Contatto> contatti = Rubrica.getContatti();
        StringBuilder sb = new StringBuilder();
        Iterator<Contatto> it= contatti.iterator();

        if (!it.hasNext()) return "";

        while (it.hasNext()) {
            sb.append(it.next().esporta());
            if (it.hasNext())
                sb.append("\n");
        }

        return sb.toString();
    }

}