package primefsample.Model;

import java.util.Date;
import java.util.Set;


public class Book extends EntityBase {

    private String titel;

    private String isbnr;

    private Date abgabeDatum;

    private Date ausleihDatum;

    private Date abgabefristDatum;

    private Kunde kunde;

    private Set<Book_Verlag> bookVerlag;

    public Date getAbgabefristDatum() {
        return abgabefristDatum;
    }

    public void setAbgabefristDatum(Date abgabefristDatum) {
        this.abgabefristDatum = abgabefristDatum;
    }

    public Set<Book_Verlag> getBookVerlag() {
        return bookVerlag;
    }

    public void setBookVerlag(Set<Book_Verlag> bookVerlag) {
        this.bookVerlag = bookVerlag;
    }


    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }


    public String getIsbnr() {
        return isbnr;
    }

    public void setIsbnr(String isbnr) {
        this.isbnr = isbnr;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Date getAbgabeDatum() {
        return abgabeDatum;
    }

    public void setAbgabeDatum(Date abgabeDatum) {
        this.abgabeDatum = abgabeDatum;
    }

    public Date getAusleihDatum() {
        return ausleihDatum;
    }

    public void setAusleihDatum(Date ausleihDatum) {
        this.ausleihDatum = ausleihDatum;
    }

}
