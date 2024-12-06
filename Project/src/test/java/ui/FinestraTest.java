/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.Contatto;
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
public class FinestraTest {
    
    public FinestraTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of mostraVediRubrica method, of class Finestra.
     */
    @Test
    public void testMostraVediRubrica() {
        System.out.println("mostraVediRubrica");
        Contatto c = null;
        Finestra instance = new Finestra();
        instance.mostraVediRubrica(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostraContatto method, of class Finestra.
     */
    @Test
    public void testMostraContatto() {
        System.out.println("mostraContatto");
        Contatto c = null;
        Finestra instance = new Finestra();
        instance.mostraContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostraModificaContatto method, of class Finestra.
     */
    @Test
    public void testMostraModificaContatto() {
        System.out.println("mostraModificaContatto");
        Contatto c = null;
        Finestra instance = new Finestra();
        instance.mostraModificaContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chiediConferma method, of class Finestra.
     */
    @Test
    public void testChiediConferma() {
        System.out.println("chiediConferma");
        Finestra instance = new Finestra();
        instance.chiediConferma();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chiediPercorso method, of class Finestra.
     */
    @Test
    public void testChiediPercorso() {
        System.out.println("chiediPercorso");
        Finestra instance = new Finestra();
        instance.chiediPercorso();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
