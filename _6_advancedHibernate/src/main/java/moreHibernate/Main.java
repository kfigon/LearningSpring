package moreHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            // kaskada - jesli np. jednokierunkowa jeden-jeden to chcemy usuwac oba w ramach
            // usuwania encji 'glownej'

            // fetch type - eager i lazy
            // jesli cos jest lazy - trzeba zainicjalizowac:
            // w hql - join fetch
            // jesli sesja otwarta, wystarczy zrobic geta
            // jesli zamknieta - Hibernate.initialize()

            // defaulty:
            // onetoone eager
            // onetomany lazy
            // manytoone eager
            // manytomany lazy
            populate(sessionFactory);

            // kaskady sa zahaczona na lifecycle entity w hibernate
            // detach, merge, persist itd.
            // np. detach - odlaczenie obiektu od sesji hibernate
            czytaj(sessionFactory);
        }
    }

    private static void populate(SessionFactory sessionFactory) {
        Obroza o = Obroza.builder().rozmiar("XL").nazwa("Obroza ASD").build();

        Zabawka z1 = Zabawka.builder().nazwa("pilka").build();
        Zabawka z2 = Zabawka.builder().nazwa("kostka").build();

        Set<Zabawka> zabawki = new HashSet<>();
        zabawki.add(z1);
        zabawki.add(z2);
        Pies p = Pies.builder().imie("ASD").wiek(12).obroza(o).zabawki(zabawki).build();
        o.setPies(p);

        z1.setPies(p);
        z2.setPies(p);


        Session s = sessionFactory.openSession();
        s.beginTransaction();
        s.save(o);
        s.save(p);
        s.save(z1);
        s.save(z2);
        s.getTransaction().commit();

        s.close();
    }

    private static void czytaj(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        System.out.println("\nczytam...");
        List<Pies> wynik = session.createQuery("from Pies")
                .getResultList();

        wynik.forEach(System.out::println);

        System.out.println("\nZabawki psa pierwszego:");
        wynik.get(0).getZabawki().forEach(System.out::println);

        session.close();
    }
}
