package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        // dependency injection recznie
//        Main m = new Main();
//        m.setTrener(new TrenerBaseballu());
//        System.out.println(m.trener.getWorkout());



        // spring container, czyta z pliku ktorego beana (obiekt javowy) ma wyciagnac.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // spring bean is simply a java object, created by spring container.
        // wystarczy zmienic w xmlu nazwe klasy i dziala
        // w srodku jest wiecej zaleznosci
        Trener trener = context.getBean("mojTrener", Trener.class);

        System.out.println("Konstruktorowe:");
        System.out.println(trener.getWorkout());
        System.out.println(trener.getMsg());

        System.out.println("\nSetterowe");
        Trener trener2 = context.getBean("mojTrenerSetterem", Trener.class);
        System.out.println(trener2.getWorkout());
        System.out.println(trener2.getMsg());

        // scope - defaultowo bean to singleton. Fajnie jakby byl stateless.
        // inne scopy np. prototype (kazdy request do kontenera - context.newBean() tworzy nowy),
        // request (http req), session itd.


        // lifecycle methods. Dowolny akces, nazwa, returntype, ale bez argumentowa
        // start kontenera,
        // tworzenie beana,
        // wstrzykiwanie,
        // internal spring processing,
        // moja customowa metoda.

        // shutdown kontenera - mozna dac destroy callback

        // UWAGA: dla scope prototype nie jest wolana metoda destroy!!!

        context.close();
    }
}