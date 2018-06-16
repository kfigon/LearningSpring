package moreHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            // kaskada - jesli np. jednokierunkowa jeden-jeden to chcemy usuwac oba w ramach usuwania encji 'glownej'
            // fetch type - eager i lazy

            populate(sessionFactory);

            // kaskady sa zahaczona na lifecycle entity w hibernate
            // detach, merge, persist itd.
            // np. detach - odlaczenie obiektu od sesji hibernate
            czytaj(sessionFactory);
        }
    }

    private static void populate(SessionFactory sessionFactory) {
        Obroza o = Obroza.builder().rozmiar("XL").nazwa("Obraza ASD").build();
        Pies p = Pies.builder().imie("ASD").wiek(12).obroza(o).build();

        Session s = sessionFactory.openSession();
        s.beginTransaction();
        s.save(o);
        s.save(p);
        s.getTransaction().commit();

        s.close();
    }

    private static void czytaj(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        System.out.println("\nczytam...");
        List<Pies> wynik = session.createQuery("from Pies")
                .getResultList();

        wynik.forEach(System.out::println);


        session.close();
    }
}
