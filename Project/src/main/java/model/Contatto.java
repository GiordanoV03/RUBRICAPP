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
    private final String[] telefoni; ///< Array di numeri di telefono.
    private final String[] emails;   ///< Array di indirizzi email.

    /// @brief Costruttore con nome e cognome.
    /// @param nome Il nome del contatto.
    /// @param cognome Il cognome del contatto.
    /// @throw ContattoNonValidoException Se nome e cognome sono vuoti o null.
    public Contatto(String nome, String cognome) throws ContattoNonValidoException {
        if (nome == null) nome = "";
        if (cognome == null) cognome = "";

        if (nome.isEmpty() && cognome.isEmpty())
            throw new ContattoNonValidoException("Mancano nome e cognome.");

        this.nome = nome;
        this.cognome = cognome;
        setTag("");

        telefoni = new String[3];
        emails = new String[3];

        for (int i = 0; i < 3; i++) {
            setTelefono(i, "");
            setEmail(i, "");
        }
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
        if (testo == null) testo = "";
        if (testo.isEmpty())
            throw new ContattoNonValidoException("Input nullo");

        String[] dati = testo.split("\n");
        if (dati.length != 10)
            throw new ContattoNonValidoException("Formato non valido");

        this.nome = dati[0];
        this.cognome = dati[1];
        setTag(dati[2]);

        telefoni = new String[3];
        emails = new String[3];

        for (int i = 0; i < 3; i++) {
            setTelefono(i, dati[i+3]);
            try {
                setEmail(i, dati[i+6]);
            } catch (EmailNonValidaException e) {
                throw new EmailNonValidaException(e.getMessage());
            }
        }
    }


    /// @brief Restituisce il nome del contatto.
    /// @return Il nome del contatto.
    public String getNome() {
        return nome;
    }

    /// @brief Restituisce il cognome del contatto.
    /// @return Il cognome del contatto.
    public String getCognome() {
        return cognome;
    }

    /// @brief Restituisce il tag associato al contatto.
    /// @return Il tag del contatto.
    public String getTag() {
        return tag;
    }

    /// @brief Restituisce un numero di telefono specifico.
    /// @param i Indice del numero di telefono.
    /// @return Il numero di telefono.
    public String getTelefono(int i) {
        return telefoni[i];
    }

    /// @brief Restituisce un indirizzo email specifico.
    /// @param i Indice dell'indirizzo email.
    /// @return L'indirizzo email.
    public String getEmail(int i) {
        return emails[i];
    }

    /// @brief Imposta il nome del contatto.
    /// @param nome Il nuovo nome del contatto.
    /// @throw ContattoNonValidoException Se il nome e il cognome sono vuoti o null.
    public void setNome(String nome) throws ContattoNonValidoException {
        if (nome == null) nome = "";
        if (nome.isEmpty() && cognome.isEmpty()) {
            throw new ContattoNonValidoException("Tentativo di eliminare il nome a un contatto senza cognome.");
        }
        this.nome = nome;
    }

    /// @brief Imposta il cognome del contatto.
    /// @param cognome Il nuovo cognome del contatto.
    /// @throw ContattoNonValidoException Se il nome e il cognome sono vuoti o null.
    public void setCognome(String cognome) throws ContattoNonValidoException {
        if (cognome == null) cognome = "";
        if (cognome.isEmpty() && nome.isEmpty()) {
            throw new ContattoNonValidoException("Tentativo di eliminare il cognome a un contatto senza nome.");
        }
        this.cognome = cognome;
    }

    /// @brief Imposta il tag del contatto.
    /// @param tag Il nuovo tag del contatto.
    public void setTag(String tag) {
        if (tag == null) tag = "";
        this.tag = tag.toUpperCase();
    }

    /// @brief Imposta un numero di telefono specifico.
    /// @param i Indice del numero di telefono.
    /// @param telefono Il nuovo numero di telefono.
    public void setTelefono(int i, String telefono) {
        if (telefono == null) telefono = "";
        telefoni[i] = telefono;
    }

    /// @brief Imposta un indirizzo email specifico.
    /// @param i Indice dell'indirizzo email.
    /// @param email Il nuovo indirizzo email.
    /// @throw EmailNonValidaException Se l'indirizzo email non è valido.
    public void setEmail(int i, String email) throws EmailNonValidaException {
        if (email == null) email = "";
        if (!Email.isEmail(email))
            throw new EmailNonValidaException("Indirizzo email non valido.");
        emails[i] = email;
    }

    /// @brief Esporta i dati del contatto in formato testuale.
    /// @return Stringa contenente i dati esportati.
    ///
    /// Questo metodo esporta i dati del contatto in una stringa
    /// di testo, utile per l'output su file.
    public String esporta() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append("\n");
        sb.append(cognome).append("\n");
        sb.append(tag).append("\n");
        for (int i = 0; i < 3; i++)
            sb.append(telefoni[i]).append("\n");
        for (int i = 0; i < 3; i++)
            sb.append(emails[i]).append("\n");
        sb.append("***");
        return sb.toString();
    }

    /// @brief Confronta il contatto corrente con un altro contatto.
    /// @param o Il contatto da confrontare.
    /// @return Valore negativo o positivo se il contatto corrente è minore, uguale o maggiore del contatto passato.
    ///
    /// Il confronto viene effettuato in base ai nomi dei due contatti in ordine alfabetico.
    @Override
    public int compareTo(Contatto o) {
        if (nome.compareToIgnoreCase(o.getNome()) != 0)
            return nome.compareTo(o.getNome());
        if (cognome.compareToIgnoreCase(o.getCognome()) != 0)
            return cognome.compareTo(o.getCognome());
        return 1;
    }
}