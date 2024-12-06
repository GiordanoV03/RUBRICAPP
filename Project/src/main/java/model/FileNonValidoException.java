/// @file FileNonValidoException.java
/// @brief Definisce un'eccezione per errori relativi a file non validi.
///
/// La classe FileNonValidoException viene utilizzata per segnalare che
/// un'operazione su un file non è valida, ad esempio quando il file ha
/// un'estensione non supportata, non è stato generato dal programma, o
/// non è leggibile.

package model;

/// @class FileNonValidoException
/// @brief Eccezione lanciata quando un file non è valido.
///
/// Questa eccezione viene utilizzata per segnalare che un'operazione su un
/// file non è valida. Viene lanciata, ad esempio, quando il file ha un'estensione
/// non supportata, non è stato generato dal programma o non è leggibile.
public class FileNonValidoException extends RuntimeException {

    /// @brief Costruttore dell'eccezione FileNonValidoException.
    /// @param message Il messaggio di errore che descrive il motivo dell'eccezione.
    public FileNonValidoException(String message) {
        super(message);
    }

}