package springmvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


        // na froncie frameworku jest springowy DispatcherServlet,
        // oddelegowuje http requesty do mojego mvc



    }
}
