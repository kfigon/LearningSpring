package springdemoanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo {

    // to jest fieldInjection. Refleksja pozwala grzebac w private
    // autowired mozna tez oznaczyc setter, kontruktor albo
    // dowolna metode z argumentem ktory pasuje
    @Autowired
    private Kotek kotek;

    @Autowired
    private Piesek piesek;

    public void piszZwierzeta() {
        System.out.println(kotek.getOkrzyk());
        System.out.println(piesek.getOkrzyk());
    }
}
