package learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MojConfig.class);

        SomeService someService = context.getBean("someService", SomeService.class);
        OtherService otherService = context.getBean("otherService", OtherService.class);

        someService.foo();
        otherService.bar();

        context.close();



        // calle do serwisow ida tak naprawde przez proxy w postaci aspektu
        // aspekt dodaje cos od siebie i wola wlasciwe rzeczy
        // najczesciej - logi, security, transakcje, exception handling, statystyki

// np. spring w @Transactional uzywa aspektu przed i po metodzie do stworzenia transkacji/sekcji

        // terminologia
        // apekt - klasa do logiki przecinajacej moduly (np aspekt do logowania)
        // advice - co ma robic i kiedy ma byc to zastosowane
        //      rozne typy - przed, po fianlly, po rzuceniu wyjatku, po metodzie itd.
        // joint point - kiedy w kodzie uzyc aspektu podczas runtime
        // pointcut - predykat gdzie dany advice ma byc uzyty
        // weaving - laczenie aspektow do serwisow. Rozne typy np compile time weave

        // springowy aop runtime weave. spring uzywa pod spodem aspectJ
        // jest aspectJ jeszcze
    }
}
