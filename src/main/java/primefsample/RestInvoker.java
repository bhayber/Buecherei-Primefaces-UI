package primefsample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import primefsample.Model.Kunde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class RestInvoker {
    private final String baseUrl;
    private final String username;
    private final String password;

    public RestInvoker(String baseUrl, String username, String password) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
    }

    public String getKundenDatenForID(String kundenId){
    return getDataFromServer("kunde/" + kundenId);
    }

    public String getKundenDatenForEmail(String email){
        return getDataFromServer("kunde/getKundebyEmail?email=" + email);
    }

    public String getAllKundenDaten(){
        return getDataFromServer("kunde/getall");
    }

    public String updateKundenDaten(Kunde kunde) throws JsonProcessingException {
        return getDataFromServer("kunde/updateKunde",kunde,"PUT");
    }


    /**
    * Methode um Serveranfragen (PUT, POST) anhand von JSON Objekten zu stellen
    * @param path Der Requestpfad der aufzurufen ist
    * @param object Objekt das als Json zum Server übertragen wird
    * @param requestMethod PUT oder POST
    * */
    private String getDataFromServer(String path, Object object, String requestMethod) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(object);
        try {
            URL url = new URL(baseUrl + path);
            HttpURLConnection urlConnection = (HttpURLConnection) setUsernamePassword(url);
            urlConnection.setRequestMethod(requestMethod);
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setDoOutput(true);
            OutputStreamWriter out = new   OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jsonInString);
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        private String getDataFromServer(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(baseUrl + path);
            URLConnection urlConnection = setUsernamePassword(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private URLConnection setUsernamePassword(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        String authString = username + ":" + password;
        String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
        urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
        return urlConnection;
    }
}