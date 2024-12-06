package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrdinamentoTest {

    @Test
    public void testSetOrdinamentoPerNome() {
        Ordinamento.setOrdinamento(true);
        assertTrue(Ordinamento.isOrdinamentoPerNome(), "Dopo aver impostato per nome, l'ordinamento dovrebbe essere per nome");
    }

    @Test
    public void testSetOrdinamentoPerCognome() {
        Ordinamento.setOrdinamento(false);
        assertFalse(Ordinamento.isOrdinamentoPerNome(), "Dopo aver impostato per cognome, l'ordinamento dovrebbe essere per cognome");
    }

    @Test
    public void testCambiaOrdinamentoDaNomeACognome() {
        Ordinamento.setOrdinamento(true);
        Ordinamento.cambiaOrdinamento();
        assertFalse(Ordinamento.isOrdinamentoPerNome(), "Dopo aver cambiato l'ordinamento, dovrebbe essere per cognome");
    }

    @Test
    public void testCambiaOrdinamentoDaCognomeANome() {
        Ordinamento.setOrdinamento(false);
        Ordinamento.cambiaOrdinamento();
        assertTrue(Ordinamento.isOrdinamentoPerNome(), "Dopo aver cambiato l'ordinamento, dovrebbe essere per nome");
    }

    @Test
    public void testRiordinaChiamatoConCambiaOrdinamento() {
        Ordinamento.setOrdinamento(true);
        assertTrue(Ordinamento.isOrdinamentoPerNome());

        Ordinamento.cambiaOrdinamento();
        assertFalse(Ordinamento.isOrdinamentoPerNome());
    }
}
