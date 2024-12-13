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

}
