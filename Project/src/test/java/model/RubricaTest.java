/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author salvo
 */
public class RubricaTest {
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Rubrica.svuota();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        Rubrica.svuota();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        Rubrica.svuota();
        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertEquals(2, contatti.size());
    }
    
    /**
     * Test of getNumeroContatti method, of class Rubrica.
     */
    @Test
    public void testGetNumeroContatti() {
        Rubrica.svuota();
        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        assertEquals(2, Rubrica.getNumeroContatti());
    }  
    
    /**
     * Test of aggiungi method, of class Rubrica.
     */
    @Test
    public void testAggiungi() {
        Rubrica.svuota();
        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto = new Contatto("Mario", "Rossi");
        
        Rubrica.aggiungi(contatto);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertEquals(1, contatti.size());
    }
    
    /**
     * Test of rimuovi method, of class Rubrica.
     */
    @Test
    public void testRimuovi() {
        Rubrica.svuota();
        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        assertEquals(2, Rubrica.getNumeroContatti());
        
        Rubrica.rimuovi(contatto1);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertEquals(1, Rubrica.getNumeroContatti());
    }
    
    /**
     * Test of modifica method, of class Rubrica.
     */
    @Test
    public void testModifica() {
        Rubrica.svuota();
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto vecchio = new Contatto("Mario", "Rossi");
        Contatto nuovo = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(vecchio);
        Rubrica.modifica(vecchio, nuovo);
        
        List<Contatto> contatti = Rubrica.getContatti();
        
        assertTrue(contatti.contains(nuovo));
    }
    
    /**
     * Test of svuota method, of class Rubrica.
     */
    @Test
    public void testSvuota() {
        Rubrica.svuota();
        
        assertTrue(Rubrica.getContatti().isEmpty());
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        assertFalse(Rubrica.getContatti().isEmpty());
        
        Rubrica.svuota();
        
        assertTrue(Rubrica.getContatti().isEmpty());
    }
    
    /**
     * Test of esporta method, of class Rubrica.
     */
    @Test
    public void testEsporta() {
        Rubrica.svuota();
        
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        String risultato = Rubrica.esporta();
        
        String risultatoAtteso = "Giovanni\nBianchi\n\n\n\n\n\n\n\n***\nMario\nRossi\n\n\n\n\n\n\n\n***\n";
        
        assertEquals(risultatoAtteso, risultato);
    }
    
    /**
     * Test of cerca method, of class Rubrica.
     */
    @Test
    public void testCerca() {
        Rubrica.svuota();
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Giovanni", "Bianchi");
        
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        
        List<Contatto> contattiTrovati = Rubrica.cerca("Mar");
        
        assertEquals(1, contattiTrovati.size());
        assertTrue(contattiTrovati.contains(contatto1));
    } 
}
