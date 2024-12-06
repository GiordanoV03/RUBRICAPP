package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrdinamentoTest {

    private Ordinamento ordinamento;
    private Contatto contatto1;
    private Contatto contatto2;
    private Contatto contatto3;

    @BeforeEach
    public void setup() throws ContattoNonValidoException {
        ordinamento = new Ordinamento();

        contatto1 = new Contatto("Luca", "Bianchi");
        contatto2 = new Contatto("Marco", "Verdi");
        contatto3 = new Contatto("Luca", "Rossi");
    }

    @Test
    public void testOrdinamentoPerNome() {
        assertTrue(ordinamento.isOrdinamentoPerNome());
        assertTrue(ordinamento.compare(contatto1, contatto2) < 0); // "Luca" < "Marco"
        assertTrue(ordinamento.compare(contatto2, contatto3) > 0); // "Marco" > "Luca"
    }

    @Test
    public void testOrdinamentoPerCognome() {
        ordinamento.setOrdinamento(false);
        assertFalse(ordinamento.isOrdinamentoPerNome());
        assertTrue(ordinamento.compare(contatto1, contatto2) < 0); // "Bianchi" < "Verdi"
        assertTrue(ordinamento.compare(contatto2, contatto3) > 0); // "Verdi" > "Rossi"
    }

    @Test
    public void testOrdinamentoConCognomeUguale() {
        ordinamento.setOrdinamento(false); // Ordinamento per cognome
        Contatto contatto4 = new Contatto("Luca", "Bianchi");
        assertEquals(1, ordinamento.compare(contatto1, contatto4)); // "Luca Bianchi" == "Luca Bianchi"
    }

    @Test
    public void testOrdinamentoConNomeUguale() {
        ordinamento.setOrdinamento(true); // Ordinamento per nome
        Contatto contatto4 = new Contatto("Luca", "Neri");
        assertTrue(ordinamento.compare(contatto1, contatto4) < 0); // "Bianchi" < "Neri"
    }

    @Test
    public void testCambiaOrdinamento() {
        ordinamento.setOrdinamento(false); // Ordinamento per cognome
        assertFalse(ordinamento.isOrdinamentoPerNome());

        ordinamento.setOrdinamento(true); // Ordinamento per nome
        assertTrue(ordinamento.isOrdinamentoPerNome());
    }

    @Test
    public void testConfrontoUguali() {
        ordinamento.setOrdinamento(true); // Ordinamento per nome
        Contatto contatto4 = new Contatto("Luca", "Bianchi");
        assertEquals(1, ordinamento.compare(contatto1, contatto4)); // "Luca Bianchi" == "Luca Bianchi"
    }

    @Test
    public void testConfrontoConDifferentementeOrdinato() {
        ordinamento.setOrdinamento(false); // Ordinamento per cognome
        assertTrue(ordinamento.compare(contatto1, contatto2) < 0); // "Bianchi" > "Verdi"
    }
}
