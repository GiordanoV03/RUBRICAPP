package model;

public class Contatto implements Comparable<Contatto> {
    private String nome, cognome, tag;
    private String[] telefoni, emails;

    public Contatto(String nome, String cognome) {
        throw new UnsupportedOperationException("Contatto constructor (String nome, String cognome) is not supported yet.");
    }

    public Contatto(String testo) {
        throw new UnsupportedOperationException("Contatto constructor (String testo) is not supported yet.");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Contatto.getNome is not supported yet.");
    }

    public String getCognome() {
        throw new UnsupportedOperationException("Contatto.getCognome is not supported yet.");
    }

    public String getTag() {
        throw new UnsupportedOperationException("Contatto.getTag is not supported yet.");
    }

    public String getTelefono(int i) {
        throw new UnsupportedOperationException("Contatto.getTelefono is not supported yet.");
    }

    public String getEmail(int i) {
        throw new UnsupportedOperationException("Contatto.getEmail is not supported yet.");
    }

    public void setNome(String nome) {
        throw new UnsupportedOperationException("Contatto.setNome is not supported yet.");
    }

    public void setCognome(String cognome) {
        throw new UnsupportedOperationException("Contatto.setCognome is not supported yet.");
    }

    public void setTag(String tag) {
        throw new UnsupportedOperationException("Contatto.setTag is not supported yet.");
    }

    public void setTelefono(int i, String telefono) {
        throw new UnsupportedOperationException("Contatto.setTelefono is not supported yet.");
    }

    public void setEmail(int i, String email) {
        throw new UnsupportedOperationException("Contatto.setEmail is not supported yet.");
    }

    public String esporta() {
        throw new UnsupportedOperationException("Contatto.esporta is not supported yet.");
    }

    @Override
    public int compareTo(Contatto o) {
        throw new UnsupportedOperationException("Contatto.compareTo is not supported yet.");
    }

}