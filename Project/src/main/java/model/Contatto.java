/// @file Contatto.java
/// @brief Definisce la classe Contatto per la gestione delle informazioni di un contatto.
///
/// La classe Contatto rappresenta un'entità che memorizza informazioni personali
/// come nome, cognome, numeri di telefono, email e un tag opzionale. Supporta
/// operazioni per ottenere e modificare i dati del contatto, nonché per esportare
/// i dati su file e caricarli da file.

package model;

/// @class Contatto
/// @brief Classe che rappresenta un contatto personale.
///
/// Questa classe permette di memorizzare e gestire i dati di un contatto,
/// tra cui nome, cognome, tag, numeri di telefono ed email. Inoltre, supporta
/// l'esportazione dei dati su file e il caricamento dei dati da una stringa di testo.
/// Implementa anche un metodo per confrontare i contatti.
public class Contatto implements Comparable<Contatto> {

    private String nome;     ///< Nome del contatto.
    private String cognome;  ///< Cognome del contatto.
    private String tag;      ///< Tag associato al contatto.
    private String[] telefoni; ///< Array di numeri di telefono.
    private String[] emails;   ///< Array di indirizzi email.

    /// @brief Costruttore con nome e cognome.
    /// @param nome Il nome del contatto.
    /// @param cognome Il cognome del contatto.
    /// @throw ContattoNonValidoException Se nome e cognome sono vuoti o null.
    public Contatto(String nome, String cognome) throws ContattoNonValidoException {
        throw new UnsupportedOperationException("Contatto constructor (String nome, String cognome) is not supported yet.");
    }

    /// @brief Costruttore che inizializza un contatto da una stringa di testo.
    /// @param testo Stringa contenente i dati del contatto.
    ///
    /// Questo costruttore prende una stringa di testo contenente i dati del contatto
    /// e li utilizza per inizializzare i campi del contatto.
    /// Viene utilizzato per caricare i dati da un file.
    /// @throw ContattoNonValidoException Se i dati nel testo non sono validi
    ///        (ad esempio, nome o cognome mancanti).
    /// @throw EmailNonValidaException Se uno degli indirizzi email nel testo è
    ///        malformato o non valido.
    public Contatto(String testo) throws ContattoNonValidoException, EmailNonValidaException {
        throw new UnsupportedOperationException("Contatto constructor (String testo) is not supported yet.");
    }


    /// @brief Restituisce il nome del contatto.
    /// @return Il nome del contatto.
    public String getNome() {
        throw new UnsupportedOperationException("Contatto.getNome is not supported yet.");
    }

    /// @brief Restituisce il cognome del contatto.
    /// @return Il cognome del contatto.
    public String getCognome() {
        throw new UnsupportedOperationException("Contatto.getCognome is not supported yet.");
    }

    /// @brief Restituisce il tag associato al contatto.
    /// @return Il tag del contatto.
    public String getTag() {
        throw new UnsupportedOperationException("Contatto.getTag is not supported yet.");
    }

    /// @brief Restituisce un numero di telefono specifico.
    /// @param i Indice del numero di telefono.
    /// @return Il numero di telefono.
    public String getTelefono(int i) {
        throw new UnsupportedOperationException("Contatto.getTelefono is not supported yet.");
    }

    /// @brief Restituisce un indirizzo email specifico.
    /// @param i Indice dell'indirizzo email.
    /// @return L'indirizzo email.
    public String getEmail(int i) {
        throw new UnsupportedOperationException("Contatto.getEmail is not supported yet.");
    }

    /// @brief Imposta il nome del contatto.
    /// @param nome Il nuovo nome del contatto.
    /// @throw ContattoNonValidoException Se il nome e il cognome sono vuoti o null.
    public void setNome(String nome) throws ContattoNonValidoException {
        throw new UnsupportedOperationException("Contatto.setNome is not supported yet.");
    }

    /// @brief Imposta il cognome del contatto.
    /// @param cognome Il nuovo cognome del contatto.
    /// @throw ContattoNonValidoException Se il nome e il cognome sono vuoti o null.
    public void setCognome(String cognome) throws ContattoNonValidoException {
        throw new UnsupportedOperationException("Contatto.setCognome is not supported yet.");
    }

    /// @brief Imposta il tag del contatto.
    /// @param tag Il nuovo tag del contatto.
    public void setTag(String tag) {
        throw new UnsupportedOperationException("Contatto.setTag is not supported yet.");
    }

    /// @brief Imposta un numero di telefono specifico.
    /// @param i Indice del numero di telefono.
    /// @param telefono Il nuovo numero di telefono.
    public void setTelefono(int i, String telefono) {
        throw new UnsupportedOperationException("Contatto.setTelefono is not supported yet.");
    }

    /// @brief Imposta un indirizzo email specifico.
    /// @param i Indice dell'indirizzo email.
    /// @param email Il nuovo indirizzo email.
    public void setEmail(int i, String email) {
        throw new UnsupportedOperationException("Contatto.setEmail is not supported yet.");
    }

    /// @brief Esporta i dati del contatto in formato testuale.
    /// @return Stringa contenente i dati esportati.
    ///
    /// Questo metodo esporta i dati del contatto in una stringa di testo, utile per
    /// l'input/output su file.
    public String esporta() {
        throw new UnsupportedOperationException("Contatto.esporta is not supported yet.");
    }

    /// @brief Confronta il contatto corrente con un altro contatto.
    /// @param o Il contatto da confrontare.
    /// @return Valore negativo o positivo se il contatto corrente è minore, uguale o maggiore del contatto passato.
    ///
    /// Il confronto viene effettuato in base ai nomi dei due contatti in ordine alfabetico.
    @Override
    public int compareTo(Contatto o) {
        throw new UnsupportedOperationException("Contatto.compareTo is not supported yet.");
    }
}