package springdemojava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MojConfig.class);

        Zwierz pies = context.getBean("pies", Zwierz.class);
        System.out.println(pies.dajGlos());

        Zwierz kot = context.getBean("kot", Zwierz.class);
        System.out.println(kot.dajGlos());
        context.close();
    }
}
