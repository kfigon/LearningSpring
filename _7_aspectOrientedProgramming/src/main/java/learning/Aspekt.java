package learning;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspekt {

    // advice
    @Before("execution(public void foo())")
    public void turboAkcja() {
        System.out.println("\n---->odpalam aspekt przed foo()");
    }

    
}
