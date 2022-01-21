package Data;

import java.io.Serializable;

public class Contact implements Serializable {

    private String nume;
    private String prenume;
    private String nrTelefon;
    private String dataNasterii;

    private Contact(String nume, String prenume, String dataNasterii, String nrTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.dataNasterii = dataNasterii;
    }

    public static Contact getInstance(String nume, String prenume, String dataNasterii, String nrTelefon) {
        if (nume.isEmpty() || prenume.isEmpty() || nrTelefon.isEmpty() || dataNasterii.isEmpty()) {
            return null;
        }
        return new Contact(nume, prenume, dataNasterii, nrTelefon);
    }
    
    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    @Override
    public String toString() {
        return "Nume: " + nume + " " + prenume + "," + " Telefon: " + nrTelefon + "," + " Data nasterii: " + dataNasterii;
    }

}
