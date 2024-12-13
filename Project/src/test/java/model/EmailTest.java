package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    public void testIsEmailValida() {
        assertTrue(Email.isEmail("test@example.com"));
    }

    @Test
    public void testIsEmailSenzaDominio() {
        assertFalse(Email.isEmail("test@.com"));
    }

    @Test
    public void testIsEmailFormatoErrato() {
        assertFalse(Email.isEmail("test.com"));
    }

    @Test
    public void testIsEmailVuota() {
        assertTrue(Email.isEmail(""));
    }

    @Test
    public void testIsEmailCaratteriSpeciali() {
        assertFalse(Email.isEmail("test@ex#ample.com"));
    }

    @Test
    public void testIsEmailConDominioValidoFormatErrato() {
        assertFalse(Email.isEmail("test@ex@ample.com"));
    }

    @Test
    public void testIsEmailConDueAt() {
        assertFalse(Email.isEmail("test@@example.com"));
    }

    @Test
    public void testIsEmailNull() {
        assertFalse(Email.isEmail(null));
    }

    @Test
    public void testIsEmailDominioNonValido() {
        assertFalse(Email.isEmail("test@com"));
    }
    
}