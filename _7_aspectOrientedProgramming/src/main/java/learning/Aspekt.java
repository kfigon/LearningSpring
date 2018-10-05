package learning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspekt {

    // advice
    @Before("execution(public void foo())")
    public void turboAkcja() {
        System.out.println("\n---->odpalam aspekt przed foo()");
    }

//    fo* - wildcardy tez mozna
    @Before("execution(public void fooPredykat())")
    public void akcjaPredykatem() {
        System.out.println("aspekt przed predykatem!");
    }

    @Pointcut("execution(public void bar*())")
    private void nazwaPointcata() {

        // zamiast stringa w before mozna zdefiniowac sobie cos takiego jak tu
        // wtedy mozna tego nazwaPointcata() uzywac w wielu advice'ach

        // tutaj pusto.
        // to jest dla reusability
        // mozna nawet AND OR NOT robic w expressions
    }

    @Before("nazwaPointcata()")
    public void kolejnyAdvice() {
        System.out.println("pointkat");
    }

    // kolejnosc wolania aspektow - jest undefined
    // kontrola rozdizelajac advices do innych aspektow i @Order(3) na aspektach


    // dobieranie sie do parametrow wywolania
    @Before("nazwaPointcata()")
    public void beforeCostam(JoinPoint joinPoint) {
//        System.out.println(joinPoint);
//        joinPoint.getArgs()
    }
}
