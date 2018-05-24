package springdemoanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZooQualified {

    // konflikty intefejsow, nie mozna dac tylko autowired.
    // trzeba qualified i w srodku beanId.
    // nadal qualifiera mozna uzywac na polu, na konstruktorze i metodzie
    // na konstruktorze bedzie to:

    // @Autowired
    // public ZooQualified(@Qualifier("kotek") Zwierzak z) {}


    @Autowired
    @Qualifier("kotek")
    private Zwierzak kot;

    @Autowired
    @Qualifier("smiesznyPiesek")
    private Zwierzak pies;


    @Value("${dane.asd}")
    private String dodatkoweDane;

    public void pisz() {
        System.out.println(kot.getOkrzyk());
        System.out.println(pies.getOkrzyk());

        System.out.println("Dodatkowe dane z propsow: " + dodatkoweDane);
    }
}
