/// @file ContattoNonValidoException.java
/// @brief Definisce un'eccezione per errori relativi ai dati di un contatto.
///
/// La classe ContattoNonValidoException viene utilizzata per segnalare che
/// un'operazione sui dati di un contatto non è valida, ad esempio quando
/// si tenta di creare un contatto senza nome né cognome o di modificare un
/// contatto esistente rimuovendo il nome e il cognome.

package model;

/// @class ContattoNonValidoException
/// @brief Eccezione lanciata quando i dati di un contatto non sono validi.
///
/// Questa eccezione viene utilizzata per segnalare che un'operazione sui dati di un
/// contatto non è valida. Viene lanciata, ad esempio, quando si tenta di creare un
/// contatto senza nome e cognome, o quando si cerca di modificare un contatto esistente
/// per rimuovere nome e cognome.
public class ContattoNonValidoException extends RuntimeException {

    /// @brief Costruttore dell'eccezione ContattoNonValidoException.
    /// @param message Il messaggio di errore che descrive il motivo dell'eccezione.
    public ContattoNonValidoException(String message) {
        super(message);
    }

}