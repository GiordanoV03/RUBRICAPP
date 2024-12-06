/// @file Email.java
/// @brief Definisce la classe Email per la gestione di indirizzi email.
///
/// La classe Email fornisce metodi statici per verificare la validità di un
/// indirizzo email e per aprire una pagina web per inviare un'email al contatto 
/// selezionato.

package model;

import java.awt.*;
import java.net.URI;

/// @class Email
/// @brief Classe utility per la gestione di indirizzi email.
///
/// Questa classe contiene metodi statici per eseguire operazioni comuni sugli
/// indirizzi email, come la verifica della loro validità e l'apertura di una 
/// pagina web per inviare un'email al contatto selezionato.
public class Email {

    /// @brief Verifica se una stringa è un indirizzo email valido.
    /// @param email La stringa da verificare.
    /// @return True se la stringa rappresenta un indirizzo email valido o una stringa vuota, false altrimenti.
    ///
    /// Questo metodo analizza la stringa fornita per determinare se rispetta il formato
    /// di un indirizzo email valido. La validazione include controlli di base sul formato.
    public static boolean isEmail(String email) {
        if (email == null) return false;
        if (email.isEmpty()) return true;
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }

    /// @brief Apre una pagina web per inviare un'email al contatto selezionato.
    /// @param email L'indirizzo email del destinatario.
    ///
    /// Questo metodo utilizza il protocollo `mailto:` per aprire un'applicazione 
    /// web per la composizione di un'email all'indirizzo fornito.
    /// In caso di errore durante l'apertura, viene sollevata un'eccezione.
    /// @throw EmailNonValidaException Se l'indirizzo email è nullo o vuoto.
    /// @throw RuntimeException Se non è possibile aprire il client o la pagina web.
    public static void apriEmail(String email) throws EmailNonValidaException {
        if (email == null || email.trim().isEmpty())
            throw new EmailNonValidaException("L'indirizzo email è nullo o vuoto.");
        if (!isEmail(email))
            throw new EmailNonValidaException("Email non valido.");
        try {
            URI uri = new URI("mailto:" + email);
            Desktop.getDesktop().mail(uri);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'apertura del client di posta.");
        }
    }

}
