/// @file VediContatto.java
/// @brief Definisce la classe VediContatto per visualizzare le informazioni di un contatto.
///
/// La classe VediContatto fornisce un'interfaccia utente per visualizzare i dettagli
/// di un contatto specifico. Gestisce eventi come la pressione di pulsanti e restituisce
/// la schermata corrispondente.

package ui;

import model.*;
import ui.VediContattoPanels.*;

import javax.swing.*;
import java.awt.*;

/// @class VediContatto
/// @brief Classe che rappresenta la schermata per visualizzare un contatto.
///
/// Questa classe gestisce l'interfaccia utente per visualizzare le informazioni di un contatto.
/// Permette di interagire con i dati del contatto tramite eventi generati dall'utente.
public class VediContatto {

    private JPanel schermata; ///< Pannello della schermata per visualizzare il contatto.

    /// @brief Costruttore della classe VediContatto.
    /// @param c Il contatto da visualizzare.
    ///
    /// Inizializza l'interfaccia utente per visualizzare le informazioni del contatto specificato.
    public VediContatto(Contatto c) {
        schermata = new JPanel(new BorderLayout()) {
            private final Color bg1 = new Color(0x8C52FF);
            private final Color bg2 = new Color(0x5CE1E6);
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, getHeight()/2, bg1,
                        getWidth(), getHeight()/2, bg2
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        schermata.add(new TopPanel(), BorderLayout.NORTH);
        schermata.add(new CenterPanel(), BorderLayout.CENTER);
    }

    /// @brief Restituisce il pannello della schermata di modifica.
    /// @return Un oggetto JPanel che rappresenta la schermata di modifica del contatto.
    ///
    /// Restituisce il pannello grafico che contiene tutti i componenti
    /// dell'interfaccia utente necessari per visualizzare un contatto.
    public JPanel getSchermata() {
        return schermata;
    }

    public static void main(String[] args) {
        Finestra.start();
        Contatto contatto = new Contatto("Giuseppe", "Pastore");
        contatto.setTag("Demone");
        Finestra.mostraContatto(contatto);
    }
}
