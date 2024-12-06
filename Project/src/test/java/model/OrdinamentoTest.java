/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class OrdinamentoTest {
    
    public OrdinamentoTest() {
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
     * Test of isOrdinamentoPerNome method, of class Ordinamento.
     */
    @Test
    public void testIsOrdinamentoPerNome() {
        System.out.println("isOrdinamentoPerNome");
        Ordinamento instance = new Ordinamento();
        boolean expResult = false;
        boolean result = instance.isOrdinamentoPerNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrdinamento method, of class Ordinamento.
     */
    @Test
    public void testSetOrdinamento() {
        System.out.println("setOrdinamento");
        boolean ordinamentoPerNome = false;
        Ordinamento instance = new Ordinamento();
        instance.setOrdinamento(ordinamentoPerNome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiaOrdinamento method, of class Ordinamento.
     */
    @Test
    public void testCambiaOrdinamento() {
        System.out.println("cambiaOrdinamento");
        Ordinamento instance = new Ordinamento();
        instance.cambiaOrdinamento();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compare method, of class Ordinamento.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Contatto o1 = null;
        Contatto o2 = null;
        Ordinamento instance = new Ordinamento();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
