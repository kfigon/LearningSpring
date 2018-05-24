package springdemoanno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Zwierzak piesek = context.getBean("smiesznyPiesek", Zwierzak.class);

        // default beanId
        // catch: RESTFortuneService --> RESTFortuneService. URL->URL. jesli drugi znak wielki to wszystko wielkie
        Zwierzak kot = context.getBean("kotek", Zwierzak.class);

        System.out.println(piesek.getOkrzyk());
        System.out.println(kot.getOkrzyk());


        // autowired
        System.out.println("\nautowired");
        Zoo zoo = context.getBean("zoo", Zoo.class);
        zoo.piszZwierzeta();

        System.out.println("\nautowired qualified");
        // autowired nie zadziala, bo zwierzaki sa interefejsami, i jest konflikt
        ZooQualified zooQualified = context.getBean("zooQualified", ZooQualified.class);
        zooQualified.pisz();
        context.close();

        // lifecycle:
        // @PostConstruct na metodzie
        // @PreDestroy - pamietac, prototyp tego nie wola
        // scope tez mozna regulowac @Scope("singleton") na obiekcie
    }
}
