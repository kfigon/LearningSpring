package springdemoanno;

import org.springframework.stereotype.Component;

// to co w xmlu bylu beanId
@Component("smiesznyPiesek")
public class Piesek implements Zwierzak {
    public String getOkrzyk() {
        return "Piesel! hau!";
    }
}
