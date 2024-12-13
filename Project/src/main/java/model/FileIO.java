/// @file FileIO.java
/// @brief Gestione delle operazioni di input/output su file per i contatti.
///
/// La classe FileIO fornisce metodi statici per aprire e salvare i contatti da/verso un file.
/// Questi metodi permettono la gestione di una rubrica di contatti, consentendo operazioni
/// di apertura, salvataggio e impostazione del nome del file.
///

package model;

import java.io.*;
import java.util.*;

/// @class FileIO
/// @brief Classe per la gestione delle operazioni di input/output su file.
///
/// La classe FileIO gestisce operazioni di input/output per salvare e caricare
/// un insieme di oggetti Contatto da o verso un file. Permette inoltre di specificare
/// il nome del file su cui lavorare.
public class FileIO {
    private static String nomePercorso; ///< Il percorso del file gestito.

    /// @brief Apre un file contenente una rubrica di contatti.
    /// @param nomefile nome del file da aprire.
    /// @return Un insieme di oggetti Contatto letti dal file.
    /// @throw IOExcption se ci sono errori con il BufferedReader o il FileReader
    /// @throw ContattoNonValidoException se nome o cognome sono vuoti o nulli
    /// @throw EmailNonValidaException se uno degli indirizzi email nel testo è malformato o non validi
    /// Questo metodo apre un file precedentemente salvato contenente una lista di contatti,
    /// e restituisce un insieme di oggetti Contatto ricostruiti dai dati presenti nel file.
    public static List<Contatto> apri(String nomefile) throws IOException,FileNonValidoException{

        // Verifica che il formato del file sia valido
        if (!isFileValido(nomefile)) {
            throw new FileNonValidoException("Il file non è valido.");
        }
        setNomefile(nomePercorso);

        List<Contatto> contatti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomefile))) {
            while ((reader.ready())) {
                StringBuilder contattoData = new StringBuilder();

                for (int i = 0; i < 10; i++) {
                    String linea = reader.readLine();
                    contattoData.append(linea).append("\n");
                }
                try {
                    contatti.add(new Contatto(contattoData.toString()));
                }catch(Exception e) {
                    throw new FileNonValidoException("ERRORE: Il file non valido.");
                }
            }
        }
        return contatti;
    }


    ///@brief Controlla che il file importato sia formattato nel modo giusto
    ///@param nomePercorso nome del file da esaminare
    ///Questo metodo effettua vari controlli, prima verifica l'esistenza del file, successivamente
    private static boolean isFileValido(String nomePercorso) {
        // Se il file non esiste, il file non è valido
        if (!(new File(nomePercorso).exists()))
            return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomePercorso))) {

            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null)
                lines.add(line);

            // Se le righe non sono multiplo di 10, il file non è valido
            if (lines.size() % 10 != 0)
                return false;

            // Se ogni decima riga non c'è "*", il file non è valido
            for (int i = 9; i < lines.size(); i += 10) {
                if (!lines.get(i).equals("***"))
                    return false;
            }

            // Se non è presente almeno uno tra nome o cognome, il file non è valido
            for(int i = 0; i < lines.size(); i++){
                if(i%10 == 0){
                    if(lines.get(i).isEmpty() && lines.get(i+1).isEmpty()){
                        return false;
                    }
                }
            }

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /// @brief Imposta il nome del file da utilizzare per il salvataggio.
    /// @param nomefile Il nuovo nome del file da associare alla variabile nomePercorso.
    ///
    /// Questo metodo permette di cambiare il nome del file in cui verranno salvati o da cui verranno
    /// caricati i contatti. Modifica il percorso del file su cui le operazioni di salvataggio/apertura
    /// saranno eseguite in futuro.
    private static void setNomefile(String nomefile) {
        nomePercorso = nomefile;
    }

    /// @brief Salva un insieme di contatti in un file con un nome specifico.
    /// @param nomefile Il nome del file in cui salvare i contatti.
    /// @throw IOExecption se ci sono errori nel PrintWriter o nel FileWriter
    /// Questo metodo permette di salvare una rubrica di contatti su un file il cui nome viene specificato
    /// come parametro. I contatti vengono salvati nel file in un formato predefinito.
    public static void salvaConNome(String nomefile) throws IOException {
        setNomefile(nomefile);
        salva();
    }

    /// @brief Salva un insieme di contatti nel file attualmente associato.
    /// @throw IOExecption se ci sono errori nel PrintWriter o nel FileWriter
    /// @throw FileNonValidoException il nome del file non è impostato
    /// Questo metodo salva la rubrica di contatti nel file associato alla variabile nomePercorso.
    /// Se il nome del file non è stato modificato, i contatti saranno salvati nel file di default.
    public static void salva() throws IOException,FileNonValidoException {
        if (nomePercorso == null || nomePercorso.isEmpty()) {
            throw new FileNonValidoException("Nome file non impostato. Utilizzare salvaConNome().");
        }
        String testo = preparaTesto();
        try (PrintWriter scrivi = new PrintWriter(new FileWriter(nomePercorso))) {
            scrivi.print(testo);
        }
    }

    /// @brief crea un formato testuale dei dati del contatto
    /// @return Una stringa contenente i dati esportati di tutti i contatti presenti
    ///         nella rubrica.
    /// Questo metodo restituisce una rappresentazione testuale dei contatti della rubrica,
    /// utile per l'esportazione dei dati su un file di testo.
    private static String preparaTesto(){
        List<Contatto> contatti = Rubrica.getContatti();
        StringBuilder sb = new StringBuilder();
        Iterator<Contatto> it= contatti.iterator();

        if (!it.hasNext()) {
            return "";
        }

        while(it.hasNext()){
            sb.append(it.next().esporta());
            if(it.hasNext()){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}