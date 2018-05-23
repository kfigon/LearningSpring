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
        Trener trener = context.getBean("mojTrener", Trener.class);

        System.out.println(trener.getWorkout());
    }
}