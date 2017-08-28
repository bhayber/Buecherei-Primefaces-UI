package primefsample.Model;

import java.io.Serializable;
import java.util.Date;


public class Book_Verlag implements Serializable {

    private Date verDatum;

    private Book book;

    private Verlag verlag;

    public Date getVerDatum() {
        return verDatum;
    }

    public void setVerDatum(Date verDatum) {
        this.verDatum = verDatum;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Verlag getVerlag() {
        return verlag;
    }

    public void setVerlag(Verlag verlag) {
        this.verlag = verlag;
    }


}
