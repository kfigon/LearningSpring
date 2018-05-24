package springdemoanno;

import org.springframework.stereotype.Component;

// default beanId - nazwa klasy z malej litery
@Component
public class Kotek implements Zwierzak{

    public String getOkrzyk() {
        return "Kotek miau";
    }
}
