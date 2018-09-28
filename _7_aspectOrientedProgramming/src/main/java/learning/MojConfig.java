package learning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("learning")
@EnableAspectJAutoProxy // dodanie aspektow
public class MojConfig {


}

