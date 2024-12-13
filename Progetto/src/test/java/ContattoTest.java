import model.Contatto;
import model.ContattoNonValidoException;
import model.EmailNonValidaException;
import model.Ordinamento;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContattoTest {

    @Test
    public void testCostruttoreNomeCognomeValido() {
        assertDoesNotThrow(() -> {
            Contatto contatto = new Contatto("Mario", "Rossi");
            assertEquals("Mario", contatto.getNome());
            assertEquals("Rossi", contatto.getCognome());
            assertEquals("", contatto.getTag());
        });
    }

    @Test
    public void testCostruttoreNomeCognomeNonValido() {
        assertThrows(ContattoNonValidoException.class, () -> {
            new Contatto("", "");
        });
    }

    @Test
    public void testCostruttoreDaTestoValido() {
        assertDoesNotThrow(() -> {
            String testo = "Mario\nRossi\nFRIEND\n12345\n\n\nemail1@example.com\n\n\n***";
            Contatto contatto = new Contatto(testo);
            assertEquals("Mario", contatto.getNome());
            assertEquals("Rossi", contatto.getCognome());
            assertEquals("FRIEND", contatto.getTag());
            assertEquals("12345", contatto.getTelefono(0));
            assertEquals("email1@example.com", contatto.getEmail(0));
        });
    }

    @Test
    public void testCostruttoreDaTestoNonValido() {
        assertThrows(ContattoNonValidoException.class, () -> {
            String testo = "Mario\nRossi\nFRIEND";
            new Contatto(testo);
        });
    }

    @Test
    public void testSetNomeValido() throws ContattoNonValidoException {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setNome("Luigi");
        assertEquals("Luigi", contatto.getNome());
    }

    @Test
    public void testSetNomeNonValido() {
        assertThrows(ContattoNonValidoException.class, () -> {
            Contatto contatto = new Contatto("Mario", "Rossi");
            contatto.setNome("");
            contatto.setCognome("");
        });
    }

    @Test
    public void testSetEmailValida() throws EmailNonValidaException {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setEmail(0, "email@example.com");
        assertEquals("email@example.com", contatto.getEmail(0));
    }

    @Test
    public void testSetEmailNonValida() {
        assertThrows(EmailNonValidaException.class, () -> {
            Contatto contatto = new Contatto("Mario", "Rossi");
            contatto.setEmail(0, "invalid-email");
        });
    }

    @Test
    public void testEsporta() throws ContattoNonValidoException, EmailNonValidaException {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTag("Friend");
        contatto.setTelefono(0, "12345");
        contatto.setEmail(0, "email@example.com");

        String expected = "Mario\nRossi\nFRIEND\n12345\n\n\nemail@example.com\n\n\n***";
        assertEquals(expected, contatto.esporta());
    }

    @Test
    public void testCompareTo() throws ContattoNonValidoException {
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Luigi", "Verdi");

        Ordinamento.setOrdinamento(true);
        assertTrue(contatto1.compareTo(contatto2) > 0);

        Ordinamento.setOrdinamento(false);
        assertTrue(contatto1.compareTo(contatto2) < 0);
    }

    @Test
    public void testContiene() throws ContattoNonValidoException {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.setTag("Friend");

        assertTrue(contatto.contiene("Mario"));
        assertTrue(contatto.contiene("Rossi"));
        assertTrue(contatto.contiene("FRIEND"));
        assertFalse(contatto.contiene("NonEsistente"));
    }
}
