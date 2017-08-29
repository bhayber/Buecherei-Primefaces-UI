package primefsample.View;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import primefsample.Model.Kunde;
import primefsample.Model.Person;
import primefsample.RestInvoker;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="KundeView")
@ViewScoped
@Named
public class KundeView implements Serializable{

    RestInvoker restInvoker = new RestInvoker("http://localhost:9000/","admin","secret");
    ObjectMapper mapper = new ObjectMapper();

    private static Kunde aktuellerKunde;

    private List<Kunde> kundenList;

    public String getEmail()  {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public String getLoadButton() throws IOException{
        loadKunde();
        return loadButton;
    }

    public void setLoadButton(String loadButton) {
        this.loadButton = loadButton;
    }

    private String loadButton ="Test";

    @Autowired
    LoginView loginView;

    public List<Kunde> getKundenList() {
        return kundenList;
    }

    public Kunde getAktuellerKunde() {

        return aktuellerKunde;
    }

    public void setAktuellerKunde(Kunde aktuellerKunde) {
        this.aktuellerKunde = aktuellerKunde;
    }

    public void setKundenList(List<Kunde> kundenList) {
        this.kundenList = kundenList;
    }

    @PostConstruct
    private void init()  {
        String kundenListResponse = restInvoker.getAllKundenDaten();
        try {
            kundenList = mapper.readValue(kundenListResponse, new TypeReference<List<Kunde>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadKunde() throws IOException {
        String kundenResponse = restInvoker.getKundenDatenForEmail(loginView.userLogin);
        aktuellerKunde =  mapper.readValue(kundenResponse, Kunde.class);
        aktuellerKunde.setPassword("");
    }

    public void updateKunde() throws IOException {
        String kundenResponse = restInvoker.updateKundenDaten(aktuellerKunde);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (kundenResponse.contains("Kunde succesfully updated!")){
            facesContext.addMessage(null,new FacesMessage("Erfolg","Kundendaten erfolgreich aktuallisiert"));
        }
        else{
            facesContext.addMessage(null,new FacesMessage("Fehler","Kundendaten konnten nicht aktuallisiert werden"));
        }
    }

}