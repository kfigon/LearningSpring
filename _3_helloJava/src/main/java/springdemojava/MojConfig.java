package springdemojava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("springdemojava") // pakiet ktory ma byc skanowany. Mozna tez wszystko recznie
@PropertySource("classpath:propsy.properties") // w wersjach springa 4.2 moga byc peoblemy, nowego beana trzeba dodac
public class MojConfig {

    // recznie! nazwa metody to beanId
    @Bean
    public Zwierz kot() {
        return new Kot();
    }
}
