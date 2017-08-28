package primefsample.Model;

import java.util.Date;
import java.util.Set;


public class Kunde extends Person {

    private Set<Book> books;

    private String ausweisnr;

    private Date mitgliedSeit;

    private Date austritt;

    public String getAusweisnr() {
        return ausweisnr;
    }

    public void setAusweisnr(String ausweisnr) {
        this.ausweisnr = ausweisnr;
    }

    public Date getMitgliedSeit() {
        return mitgliedSeit;
    }

    public void setMitgliedSeit(Date mitgliedSeit) {
        this.mitgliedSeit = mitgliedSeit;
    }

    public Date getAustritt() {
        return austritt;
    }

    public void setAustritt(Date austritt) {
        this.austritt = austritt;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
