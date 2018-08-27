package learningHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;


public class Main {

// gdyby pisac web serwis to bylby kontroler i w srodku serwis.
// serwis mialby DAO - obiekt do najpopularniejszych operacji na encji na bazie.
// spring ma adnotacje @Repository, ktory caly redukuje boilerplate zwiazany z tworzeniem

    public static void main(String[] args) {
        // czyta hibernate config file, tworzony raz w czasie zycia apki, tworzy sesje
        // mozna jawnie wyspecyfikowac sciezke
        // .addAnnotatedClass(Student.class) sprawi, ze nie bedzie potrzebny mapping w hibernate.cfg.xml
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            // sesja to wrapper na polaczenie jdbc
            persist(sessionFactory);
            load(sessionFactory);

            loadParticular(sessionFactory, "Nowak");
            updateData(sessionFactory);

            load(sessionFactory);
        }
    }

    private static void load(SessionFactory sessionFactory) {
        System.out.println("\n-- loading persons --");
		// session.open() i close() mozna wywalic, jesli jest adnotacja @Transactional. Spring sam otworzy i zamknie sesje
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


    private static void updateData(SessionFactory sessionFactory) {
        System.out.println("\nUpdating student");
        Student s = Student.builder().imie("Kszysztof").nazwisko("Wisniewski").wiek(66).build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();


        s = (Student)session.createQuery("from Student s where s.imie = :imie")
                .setParameter("imie", "Kszysztof")
                .getSingleResult();

        s.setImie("Krzysztof");
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();

        // update wielu
//        session.createQuery("my turbo query").executeUpdate();

//        session.delete(s);
        // i commit

        session.close();
    }
}
