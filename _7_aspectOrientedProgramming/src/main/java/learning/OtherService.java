package learning;

import org.springframework.stereotype.Component;

@Component
public class OtherService {
    public void bar() {
        System.out.println("doing OtherService things...");
    }

    public void foo() {
        System.out.println("foo z other serviec");
    }
}
