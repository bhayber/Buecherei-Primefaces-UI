package primefsample.View;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.primefaces.context.RequestContext;
import primefsample.Model.Kunde;
import primefsample.PasswordMaker;
import primefsample.RestInvoker;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.IOException;

@ManagedBean(name="LoginView")
@ViewScoped
@Named
public class LoginView {

    RestInvoker restInvoker = new RestInvoker("http://localhost:9000/","admin","secret");
    ObjectMapper mapper = new ObjectMapper();

    public static String userLogin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        userLogin = email;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static String email;
    private String password;


    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        Kunde aktuellerKunde = new Kunde();
        PasswordMaker pwmaker = new PasswordMaker();

        if(email != null) {

            String kundenResponse = restInvoker.getKundenDatenForEmail(email);
            try {
                aktuellerKunde =  mapper.readValue(kundenResponse, Kunde.class);
                if(aktuellerKunde != null && pwmaker.checkPassword(password,aktuellerKunde.getPassword())){
                    password = null;
                    loggedIn = true;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", email);
                }
                else{
                    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Failed", email);
                }

            } catch (IOException e) {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Loggin Error", "Kunde mit der email nicht gefunden !!");
            }
        }
        else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }

}
