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
public class FileIOTest {
    
    public FileIOTest() {
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
     * Test of apri method, of class FileIO.
     */
    @Test
    public void testApri() {
        System.out.println("apri");
        String nomefile = "";
        Set<Contatto> expResult = null;
        Set<Contatto> result = FileIO.apri(nomefile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaConNome method, of class FileIO.
     */
    @Test
    public void testSalvaConNome() {
        System.out.println("salvaConNome");
        Set<Contatto> contatti = null;
        String nomefile = "";
        FileIO.salvaConNome(contatti, nomefile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salva method, of class FileIO.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        Set<Contatto> contatti = null;
        FileIO.salva(contatti);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
