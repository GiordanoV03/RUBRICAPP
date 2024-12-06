/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;
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
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        Rubrica instance = null;
        Set<Contatto> expResult = null;
        Set<Contatto> result = instance.getContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungi method, of class Rubrica.
     */
    @Test
    public void testAggiungi() {
        System.out.println("aggiungi");
        Contatto c = null;
        Rubrica instance = null;
        instance.aggiungi(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuovi method, of class Rubrica.
     */
    @Test
    public void testRimuovi() {
        System.out.println("rimuovi");
        Contatto c = null;
        Rubrica instance = null;
        instance.rimuovi(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifica method, of class Rubrica.
     */
    @Test
    public void testModifica() {
        System.out.println("modifica");
        Contatto vecchio = null;
        Contatto nuovo = null;
        Rubrica instance = null;
        instance.modifica(vecchio, nuovo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esporta method, of class Rubrica.
     */
    @Test
    public void testEsporta() {
        System.out.println("esporta");
        Rubrica instance = null;
        String expResult = "";
        String result = instance.esporta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cerca method, of class Rubrica.
     */
    @Test
    public void testCerca() {
        System.out.println("cerca");
        String stringa = "";
        Rubrica instance = null;
        Set<Contatto> expResult = null;
        Set<Contatto> result = instance.cerca(stringa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
