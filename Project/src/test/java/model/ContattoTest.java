package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContattoTest {

    @Test
    public void testCostruttoreValido() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        assertEquals("Mario", contatto.getNome());
        assertEquals("Rossi", contatto.getCognome());
        assertEquals("", contatto.getTag());
    }

    @Test
    public void testCostruttoreConEccezione() {
        assertThrows(ContattoNonValidoException.class, () -> new Contatto("", ""));
        assertThrows(ContattoNonValidoException.class, () -> new Contatto(null, null));
        assertThrows(ContattoNonValidoException.class, () -> new Contatto(null, ""));
        assertThrows(ContattoNonValidoException.class, () -> new Contatto("", null));
    }

    @Test
    public void testCostruttoreDaTestoValido() {
        String input = "Mario\nRossi\nAMICO\n123456789\n987654321\n456123789\nemail1@example.com\nemail2@example.com\nemail3@example.com\n***";
        Contatto contatto = new Contatto(input);

        assertEquals("Mario", contatto.getNome());
        assertEquals("Rossi", contatto.getCognome());
        assertEquals("AMICO", contatto.getTag());
        assertEquals("123456789", contatto.getTelefono(0));
        assertEquals("email1@example.com", contatto.getEmail(0));
    }

    @Test
    public void testCostruttoreDaTestoInvalido() {
        String inputInvalido = "Mario\nRossi";
        assertThrows(ContattoNonValidoException.class, () -> new Contatto(inputInvalido));

        String inputEmailInvalida = "Mario\nRossi\nAMICO\n123456789\n\n\ninvalid_email\n\n\n***";
        assertThrows(EmailNonValidaException.class, () -> new Contatto(inputEmailInvalida));
    }

    @Test
    public void testEsportaImporta() throws ContattoNonValidoException, EmailNonValidaException {
        // 1. Creazione di un contatto originale
        Contatto contattoOriginale = new Contatto("Luca", "Bianchi");
        contattoOriginale.setTag("Amico");
        contattoOriginale.setTelefono(0, "1234567890");
        contattoOriginale.setTelefono(1, "0987654321");
        contattoOriginale.setTelefono(2, "1122334455");
        contattoOriginale.setEmail(0, "luca.bianchi@example.com");
        contattoOriginale.setEmail(1, "luca@example.com");
        contattoOriginale.setEmail(2, "contact.luca@example.org");

        // 2. Esportazione del contatto in una stringa
        String datiEsportati = contattoOriginale.esporta();

        // 3. Creazione di un nuovo contatto utilizzando i dati esportati
        Contatto contattoImportato = new Contatto(datiEsportati);

        // 4. Confronto dei due contatti
        assertEquals(contattoOriginale.getNome(), contattoImportato.getNome(), "I nomi devono essere uguali");
        assertEquals(contattoOriginale.getCognome(), contattoImportato.getCognome(), "I cognomi devono essere uguali");
        assertEquals(contattoOriginale.getTag(), contattoImportato.getTag(), "I tag devono essere uguali");

        // Verifica dei numeri di telefono
        for (int i = 0; i < 3; i++) {
            assertEquals(contattoOriginale.getTelefono(i), contattoImportato.getTelefono(i), "I numeri di telefono devono essere uguali");
        }

        // Verifica degli indirizzi email
        for (int i = 0; i < 3; i++) {
            assertEquals(contattoOriginale.getEmail(i), contattoImportato.getEmail(i), "Gli indirizzi email devono essere uguali");
        }
    }

    @Test
    public void testSetNome() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setNome("Luigi");
        assertEquals("Luigi", contatto.getNome());

        contatto.setNome(null);
        assertEquals("", contatto.getNome());

        assertThrows(ContattoNonValidoException.class, () -> {
            contatto.setNome("");
            contatto.setCognome("");
        });
    }

    @Test
    public void testSetCognome() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setCognome("Verdi");
        assertEquals("Verdi", contatto.getCognome());

        contatto.setCognome(null);
        assertEquals("", contatto.getCognome());

        assertThrows(ContattoNonValidoException.class, () -> {
            contatto.setNome("");
            contatto.setCognome("");
        });
    }

    @Test
    public void testSetTag() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTag("Amico");
        assertEquals("AMICO", contatto.getTag());

        contatto.setTag(null);
        assertEquals("", contatto.getTag());
    }

    @Test
    public void testSetTelefono() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTelefono(0, "123456789");
        assertEquals("123456789", contatto.getTelefono(0));

        contatto.setTelefono(1, null);
        assertEquals("", contatto.getTelefono(1));
    }

    @Test
    public void testSetEmail() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setEmail(0, "test@example.com");
        assertEquals("test@example.com", contatto.getEmail(0));

        contatto.setEmail(1, null);
        assertEquals("", contatto.getEmail(1));

        assertThrows(EmailNonValidaException.class, () -> contatto.setEmail(0, "invalid_email"));
    }

    @Test
    public void testEsporta() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTag("Amico");
        contatto.setTelefono(0, "123456789");
        contatto.setEmail(0, "test@example.com");

        String expectedOutput = "Mario\nRossi\nAMICO\n123456789\n\n\ntest@example.com\n\n\n***";
        assertEquals(expectedOutput, contatto.esporta());
    }

    @Test
    public void testCompareTo() {
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Luigi", "Bianchi");
        Contatto contatto3 = new Contatto("Mario", "Verdi");
        Contatto contatto4 = new Contatto("Mario", "Rossi");

        assertTrue(contatto1.compareTo(contatto2) > 0); // "Mario" > "Luigi"
        assertTrue(contatto1.compareTo(contatto3) < 0); // "Rossi" < "Verdi"
        assertEquals(1, contatto1.compareTo(contatto4)); // Identici
    }

    @Test
    public void testContieneStringaPresente() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTag("Amico");

        assertTrue(contatto.contiene("Mario"), "Il contatto dovrebbe contenere 'Mario'");
        assertTrue(contatto.contiene("Rossi"), "Il contatto dovrebbe contenere 'Rossi'");
        assertTrue(contatto.contiene("Amico"), "Il contatto dovrebbe contenere 'Amico'");

        assertTrue(contatto.contiene("Mario Rossi"), "Il contatto dovrebbe contenere 'Mario Rossi'");
        assertTrue(contatto.contiene("Rossi Mario"), "Il contatto dovrebbe contenere 'Rossi Mario'");
    }

    @Test
    public void testContieneStringaAssente() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTag("Amico");

        assertFalse(contatto.contiene("Luigi"), "Il contatto non dovrebbe contenere 'Luigi'");
        assertFalse(contatto.contiene("Verdi"), "Il contatto non dovrebbe contenere 'Verdi'");
        assertFalse(contatto.contiene("Nemico"), "Il contatto non dovrebbe contenere 'Nemico'");
    }

    @Test
    public void testContieneStringaVuotaONulla() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTag("Amico");

        assertFalse(contatto.contiene(""), "Il contatto non dovrebbe contenere una stringa vuota");
        assertFalse(contatto.contiene(null), "Il contatto non dovrebbe contenere una stringa null");
    }

}
