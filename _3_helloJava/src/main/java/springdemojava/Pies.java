package springdemojava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Pies implements Zwierz {

    @Value("${dane.asd}")
    private String dane;

    public String dajGlos() {
        return "Pies hau! Dane: " + dane;
    }
}
