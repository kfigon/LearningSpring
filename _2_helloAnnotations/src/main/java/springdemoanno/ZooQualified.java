package springdemoanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ZooQualified {

    // konflikty intefejsow, nie mozna dac tylko autowired.
    // trzeba qualified i w srodku beanId

    @Autowired
    @Qualifier("kotek")
    private Zwierzak kot;

    @Autowired
    @Qualifier("smiesznyPiesek")
    private Zwierzak pies;

    public void pisz() {
        System.out.println(kot.getOkrzyk());
        System.out.println(pies.getOkrzyk());
    }
}
