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
public class ContattoTest {
    
    public ContattoTest() {
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
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        String nome = contatto.getNome();
        assertEquals("Mario", nome);
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        String cognome = contatto.getCognome();
        assertEquals("Rossi", cognome);
    }

    /**
     * Test of getTag method, of class Contatto.
     */
    @Test
    public void testGetTag() {
        System.out.println("getTag");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getTag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class Contatto.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        int i = 0;
        Contatto instance = null;
        String expResult = "";
        String result = instance.getTelefono(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        int i = 0;
        Contatto instance = null;
        String expResult = "";
        String result = instance.getEmail(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Contatto instance = null;
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "";
        Contatto instance = null;
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTag method, of class Contatto.
     */
    @Test
    public void testSetTag() {
        System.out.println("setTag");
        String tag = "";
        Contatto instance = null;
        instance.setTag(tag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class Contatto.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        int i = 0;
        String telefono = "";
        Contatto instance = null;
        instance.setTelefono(i, telefono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Contatto.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        int i = 0;
        String email = "";
        Contatto instance = null;
        instance.setEmail(i, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esporta method, of class Contatto.
     */
    @Test
    public void testEsporta() {
        System.out.println("esporta");
        Contatto instance = null;
        String expResult = "";
        String result = instance.esporta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Contatto o = null;
        Contatto instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
