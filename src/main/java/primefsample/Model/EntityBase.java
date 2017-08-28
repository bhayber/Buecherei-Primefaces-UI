package primefsample.Model;



import java.io.Serializable;


public abstract class EntityBase implements Serializable {

    private static final long serialVersionUID = -1782169553419964841L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
