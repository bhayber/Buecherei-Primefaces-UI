package primefsample.View;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import primefsample.Model.Book;
import primefsample.Model.Kunde;
import primefsample.RestInvoker;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ManagedBean(name="RentABookView")
@ViewScoped
@Named
public class RentABookView implements Serializable{

    RestInvoker restInvoker = new RestInvoker("http://localhost:9000/","admin","secret");
    ObjectMapper mapper = new ObjectMapper();

    private Date currDate;

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    private Book selectedBook;

    private List<Book> bookList;

    private String email;

    @PostConstruct
    private void init()  {
        String BooksNotRentedResponse = restInvoker.getAllKundenDaten();
        try {
            bookList = mapper.readValue(BooksNotRentedResponse, new TypeReference<List<Book>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        currDate = Calendar.getInstance().getTime();
    }

    public Date getCurrDate() {
        return currDate;
    }

    @Autowired
    LoginView loginView;

    public void rentABook()  {
//        String kundenResponse = null;
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        try {
//            kundenResponse = restInvoker.updateKundenDaten(aktuellerKunde);
//            if (kundenResponse.contains("Kunde succesfully updated!")){
//                facesContext.addMessage(null,new FacesMessage("Erfolg","Kundendaten erfolgreich aktuallisiert"));
//            }
//            else{
//                facesContext.addMessage(null,new FacesMessage("Fehler","Kundendaten konnten nicht aktuallisiert werden"));
//            }
//        } catch (JsonProcessingException e) {
//            facesContext.addMessage(null,new FacesMessage("Fehler","Kundendaten konnten nicht aktuallisiert werden"));
//        }
    }
}