package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RubricaTest {

    @BeforeEach
    public void setUp() {
        Rubrica.svuota();
    }

    @Test
    public void testGetContatti() {

        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertEquals(2, contatti.size());
    }

    @Test
    public void testGetNumeroContatti() {

        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        assertEquals(2, Rubrica.getContatti().size());
    }  

    @Test
    public void testAggiungi() {

        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto = new Contatto("Mario", "Rossi");
        
        Rubrica.aggiungi(contatto);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertEquals(1, contatti.size());
    }

    @Test
    public void testRimuovi() {

        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        assertEquals(2, Rubrica.getContatti().size());
        
        Rubrica.rimuovi(contatto1);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertEquals(1, Rubrica.getContatti().size());
    }

    @Test
    public void testModifica() {

        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto vecchio = new Contatto("Mario", "Rossi");
        Contatto nuovo = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(vecchio);
        Rubrica.modifica(vecchio, nuovo);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertTrue(contatti.contains(nuovo));
    }

    @Test
    public void testSvuota() {

        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        assertFalse(Rubrica.getContatti().isEmpty());
        
        Rubrica.svuota();
        
        assertTrue(Rubrica.getContatti().isEmpty());
    }
    @Test
    public void testCerca() {

        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        List<Contatto> contattiTrovati = Rubrica.cerca("Mar");
        
        assertEquals(1, contattiTrovati.size());
        assertTrue(contattiTrovati.contains(contatto1));
    } 
}
