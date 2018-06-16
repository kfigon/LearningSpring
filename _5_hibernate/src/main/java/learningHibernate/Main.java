package learningHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {


    public static void main(String[] args) {
        // czyta hibernate config file, tworzony raz w czasie zycia apki, tworzy sesje
        // mozna jawnie wyspecyfikowac sciezke
        // .addAnnotatedClass(Student.class) sprawi, ze nie bedzie potrzebny mapping w hibernate.cfg.xml
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            // sesja to wrapper na polaczenie jdbc
            persist(sessionFactory);
            load(sessionFactory);

            loadParticular(sessionFactory, "Nowak");
        }
    }


    private static void load(SessionFactory sessionFactory) {
        System.out.println("\n-- loading persons --");
        Session session = sessionFactory.openSession();

        // hql
        List<Student> persons = session.createQuery("FROM Student").getResultList();
//        Student asd = session.get(Student.class, 1);  // przeczyta studenta o id 1

        persons.forEach(System.out::println);
        session.close();
    }

    private static void persist(SessionFactory sessionFactory) {
        Student p1 = Student.builder().imie("Jan").nazwisko("Kowalski").wiek(34).build();
        Student p2 = Student.builder().imie("Jan").nazwisko("Nowak").wiek(15).build();

        System.out.println("\npersisting students");

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();

        session.close();
    }


    private static void loadParticular(SessionFactory sessionFactory, String nazwisko) {
        System.out.println(String.format("\nloading students with nazwisko == %s", nazwisko));


        Session session = sessionFactory.openSession();

        List<Student> wynik = session
                .createQuery("from Student s where s.nazwisko = :nazwisko")
                .setParameter("nazwisko", nazwisko)
                .getResultList();

        wynik.forEach(System.out::println);
        session.close();
    }
}
