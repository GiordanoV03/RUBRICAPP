/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ModificaContattoControllerTest {
    
    public ModificaContattoControllerTest() {
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
     * Test of aggiungi method, of class ModificaContattoController.
     */
    @Test
    public void testAggiungi() {
        System.out.println("aggiungi");
        Contatto c = null;
        ModificaContattoController instance = new ModificaContattoController();
        instance.aggiungi(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifica method, of class ModificaContattoController.
     */
    @Test
    public void testModifica() {
        System.out.println("modifica");
        Contatto vecchio = null;
        Contatto nuovo = null;
        ModificaContattoController instance = new ModificaContattoController();
        instance.modifica(vecchio, nuovo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of annulla method, of class ModificaContattoController.
     */
    @Test
    public void testAnnulla() {
        System.out.println("annulla");
        ModificaContattoController instance = new ModificaContattoController();
        instance.annulla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
