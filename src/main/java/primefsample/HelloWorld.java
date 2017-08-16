package primefsample;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class HelloWorld {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

public String sayHello(){

    return this.name;
}

@PostConstruct
    private void doSomething(){

    setName("Hans Meiser");
}

}
