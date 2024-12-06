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
public class RubricaControllerTest {
    
    public RubricaControllerTest() {
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
     * Test of visualizza method, of class RubricaController.
     */
    @Test
    public void testVisualizza() {
        System.out.println("visualizza");
        RubricaController instance = new RubricaController();
        instance.visualizza();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiaOrdinamento method, of class RubricaController.
     */
    @Test
    public void testCambiaOrdinamento() {
        System.out.println("cambiaOrdinamento");
        RubricaController instance = new RubricaController();
        instance.cambiaOrdinamento();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiContatto method, of class RubricaController.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        RubricaController instance = new RubricaController();
        instance.aggiungiContatto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vediContatto method, of class RubricaController.
     */
    @Test
    public void testVediContatto() {
        System.out.println("vediContatto");
        Contatto c = null;
        RubricaController instance = new RubricaController();
        instance.vediContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cerca method, of class RubricaController.
     */
    @Test
    public void testCerca() {
        System.out.println("cerca");
        String stringa = "";
        RubricaController instance = new RubricaController();
        instance.cerca(stringa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selezionaContatto method, of class RubricaController.
     */
    @Test
    public void testSelezionaContatto() {
        System.out.println("selezionaContatto");
        Contatto c = null;
        RubricaController instance = new RubricaController();
        instance.selezionaContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaContatti method, of class RubricaController.
     */
    @Test
    public void testEliminaContatti() {
        System.out.println("eliminaContatti");
        RubricaController instance = new RubricaController();
        instance.eliminaContatti();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importa method, of class RubricaController.
     */
    @Test
    public void testImporta() {
        System.out.println("importa");
        RubricaController instance = new RubricaController();
        instance.importa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salva method, of class RubricaController.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        RubricaController instance = new RubricaController();
        instance.salva();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaConNome method, of class RubricaController.
     */
    @Test
    public void testSalvaConNome() {
        System.out.println("salvaConNome");
        RubricaController instance = new RubricaController();
        instance.salvaConNome();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
