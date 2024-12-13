/// @file EmailNonValidaException.java
/// @brief Definisce un'eccezione per errori relativi a indirizzi email non validi.
///
/// La classe EmailNonValidaException viene utilizzata per segnalare che
/// un'operazione su un indirizzo email non è valida, ad esempio quando si
/// tenta di impostare un indirizzo email non valido su un contatto.

package model;

/// @class EmailNonValidaException
/// @brief Eccezione lanciata quando un indirizzo email non è valido.
///
/// Questa eccezione viene utilizzata per segnalare che un'operazione su un
/// indirizzo email non è valida. Viene lanciata, ad esempio, quando si tenta
/// di impostare un indirizzo email che non soddisfa i criteri di validità
/// su un contatto.
public class EmailNonValidaException extends RuntimeException {

    /// @brief Costruttore dell'eccezione EmailNonValidaException.
    /// @param message Il messaggio di errore che descrive il motivo dell'eccezione.
    public EmailNonValidaException(String message) {
        super(message);
    }

}