/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JButton;
import javax.swing.JPanel;
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
public class ModificaContattoTest {
    
    public ModificaContattoTest() {
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
     * Test of getSchermata method, of class ModificaContatto.
     */
    @Test
    public void testGetSchermata() {
        System.out.println("getSchermata");
        ModificaContatto instance = null;
        JPanel expResult = null;
        JPanel result = instance.getSchermata();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pulsanteCliccato method, of class ModificaContatto.
     */
    @Test
    public void testPulsanteCliccato() {
        System.out.println("pulsanteCliccato");
        JButton pulsante = null;
        ModificaContatto instance = null;
        instance.pulsanteCliccato(pulsante);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
