package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileIOTest {
    private static final String TEST_FILE = "test_rubrica.txt";

    @BeforeEach
    public void setUp() throws IOException {
        Rubrica.svuota();
        FileIO.salvaConNome(TEST_FILE);
        eliminaFile(TEST_FILE);
    }

    @AfterEach
    public void tearDown() throws IOException {
        eliminaFile(TEST_FILE);
    }

    @Test
    public void testSalvaConNome_CreaFileDaRubricaEsistente() throws Exception {
        Contatto contatto1 = new Contatto("Giulia", "Neri");
        Contatto contatto2 = new Contatto("Luca", "Bianchi");
        Rubrica.aggiungi(contatto1);
        Rubrica.aggiungi(contatto2);
        FileIO.salvaConNome(TEST_FILE);
        String fileContenuto = leggiFile(TEST_FILE);
        assertTrue(fileContenuto.contains(contatto1.esporta()), "Il contatto 1 non è stato trovato nel file");
        assertTrue(fileContenuto.contains(contatto2.esporta()), "Il contatto 2 non è stato trovato nel file");
    }

    @Test
    public void testSalvaConNome() throws Exception {
        Contatto contatto = new Contatto("Anna", "Verdi");
        contatto.setTag("Amica");
        contatto.setTelefono(0, "123456789");
        contatto.setTelefono(1, "234567890");
        contatto.setTelefono(2, "345678901");
        contatto.setEmail(0, "anna@esempio.com");
        contatto.setEmail(1, "anna2@esempio.com");
        contatto.setEmail(2, "anna3@esempio.com");
        Rubrica.aggiungi(contatto);
        FileIO.salvaConNome(TEST_FILE);
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "Il file non è stato creato");
        String fileContenuto = leggiFile(TEST_FILE).trim();
        String contenutoAtteso = contatto.esporta().trim();
        assertEquals(contenutoAtteso, fileContenuto, "Il contenuto del file non corrisponde");
    }

    @Test
    public void testApri_FileConErroriParziali() throws Exception {
        String contenuto = "Mario\nRossi\nFAMIGLIA\n123456789\n\nmario@rossi.it\n\n\n***\nErrore\nMancanoDati";
        scriviFile(TEST_FILE, contenuto);
        assertThrows(FileNonValidoException.class, () -> FileIO.apri(TEST_FILE), "Non è stata lanciata l'eccezione per formato errato");
    }

    @Test
    public void testSalva() throws Exception {
        Contatto contatto = new Contatto("Giulia", "Neri");
        contatto.setTag("Amica");
        contatto.setTelefono(0, "123456789");
        contatto.setTelefono(1, "234567890");
        contatto.setTelefono(2, "345678901");
        contatto.setEmail(0, "giulia@esempio.com");
        contatto.setEmail(1, "giulia2@esempio.com");
        contatto.setEmail(2, "giulia3@esempio.com");
        Rubrica.aggiungi(contatto);
        FileIO.salva();
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "Il file non è stato creato");
        String fileContenuto = leggiFile(TEST_FILE).trim();
        String contenutoAtteso = contatto.esporta().trim();
        assertEquals(contenutoAtteso, fileContenuto, "Il contenuto del file non corrisponde");
    }

    @Test
    public void testSalvaConRubricaVuota() throws Exception {
        Rubrica.svuota();
        FileIO.salvaConNome(TEST_FILE);
        assertTrue(leggiFile(TEST_FILE).isEmpty(), "Il file non è vuoto come atteso");
    }

    @Test
    public void testApri() throws Exception {
        String contenuto = "Francesca\nRossi\nFAMIGLIA\n123456789\n\n\nfrancesca@rossi.it\n\n\n***\n";
        scriviFile(TEST_FILE, contenuto);
        List<Contatto> contatti = FileIO.apri(TEST_FILE);
        Contatto atteso = new Contatto("Francesca", "Rossi");
        atteso.setTag("FAMIGLIA");
        atteso.setTelefono(0, "123456789");
        atteso.setEmail(0, "francesca@rossi.it");
        assertTrue(contatti.contains(atteso), "Il contatto non è stato caricato correttamente");
    }

    @Test
    public void testApri_FileMoltoGrande() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            Contatto c = new Contatto("Nome", "Cognome");
            c.setTag("Amico");
            c.setEmail(0, "email@example.com");
            c.setEmail(1, "email2@example.com");
            c.setEmail(2, "email3@example.com");
            c.setTelefono(0, "123456789");
            c.setTelefono(1, "234567890");
            c.setTelefono(2, "345678901");
            sb.append(c.esporta());
            if (i < 999) sb.append("\n");
        }
        scriviFile(TEST_FILE, sb.toString());
        List<Contatto> contatti = FileIO.apri(TEST_FILE);
        assertEquals(1000, contatti.size(), "Non tutti i contatti sono stati caricati");
    }

    @Test
    public void testApriFormatoNonValido() throws IOException {
        String contenutoInvalido = "Mario\n";
        scriviFile(TEST_FILE, contenutoInvalido);
        assertThrows(FileNonValidoException.class, () -> FileIO.apri(TEST_FILE));
    }

    @Test
    public void testApriFileInesistente() {
        String nomeFile = "file_non_esistente.txt";
        File file = new File(nomeFile);
        if (file.exists())
            file.delete();
        assertThrows(FileNonValidoException.class, () -> FileIO.apri(nomeFile),
                "Non è stata lanciata l'eccezione attesa per un file inesistente");
    }
    
    private String leggiFile(String nomeFile) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (java.util.Scanner scanner = new java.util.Scanner(new File(nomeFile))) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                if (scanner.hasNextLine())
                    sb.append("\n");
            }
        }
        return sb.toString();
    }
    
        private void scriviFile(String nomeFile, String contenuto) throws IOException {
        java.io.FileWriter writer = new java.io.FileWriter(nomeFile);
        writer.write(contenuto);
        writer.close();
    }
        
    private void eliminaFile(String nomeFile) {
        File file = new File(nomeFile);
        if (file.exists()) {
            file.delete();
        }
    }

}