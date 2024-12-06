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
public class ContattoControllerTest {
    
    public ContattoControllerTest() {
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
     * Test of visualizza method, of class ContattoController.
     */
    @Test
    public void testVisualizza() {
        System.out.println("visualizza");
        Contatto c = null;
        ContattoController instance = new ContattoController();
        instance.visualizza(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifica method, of class ContattoController.
     */
    @Test
    public void testModifica() {
        System.out.println("modifica");
        Contatto nuovo = null;
        ContattoController instance = new ContattoController();
        instance.modifica(nuovo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elimina method, of class ContattoController.
     */
    @Test
    public void testElimina() {
        System.out.println("elimina");
        Contatto c = null;
        ContattoController instance = new ContattoController();
        instance.elimina(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apriEmail method, of class ContattoController.
     */
    @Test
    public void testApriEmail() {
        System.out.println("apriEmail");
        String email = "";
        ContattoController instance = new ContattoController();
        instance.apriEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indietro method, of class ContattoController.
     */
    @Test
    public void testIndietro() {
        System.out.println("indietro");
        ContattoController instance = new ContattoController();
        instance.indietro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
