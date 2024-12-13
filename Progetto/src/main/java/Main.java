/// @file Main.java
/// @brief Punto di ingresso dell'applicazione.
///
/// Questa classe contiene il metodo "main", che avvia l'applicazione
/// creando una nuova finestra principale.

import ui.Finestra;

/// @class Main
/// @brief Classe principale per l'avvio dell'applicazione.
///
/// La classe Main serve come punto di ingresso per l'applicazione. 
/// Il metodo "main" istanzia una finestra principale utilizzando la classe `Finestra`.
public class Main {

    /// @brief Metodo principale dell'applicazione.
    /// @param args Argomenti della riga di comando (non utilizzati).
    ///
    /// Questo metodo avvia l'applicazione istanziando un oggetto "Finestra",
    /// che rappresenta l'interfaccia grafica principale.
    public static void main(String[] args) {
        Finestra.start();
    }

}