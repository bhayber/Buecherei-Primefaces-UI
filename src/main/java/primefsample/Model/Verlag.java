package primefsample.Model;


import java.util.Set;

public class Verlag extends EntityBase {

    private String name;

    private String adresse;

    private double jahrlUmsatz;

    private Set<Book_Verlag> bookVerlag;

    public Set<Book_Verlag> getBookVerlag() {
        return bookVerlag;
    }

    public void setBookVerlag(Set<Book_Verlag> bookVerlag) {
        this.bookVerlag = bookVerlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getJahrlUmsatz() {
        return jahrlUmsatz;
    }

    public void setJahrlUmsatz(double jahrlUmsatz) {
        this.jahrlUmsatz = jahrlUmsatz;
    }
}