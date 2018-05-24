package springdemoanno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Zwierzak piesek = context.getBean("smiesznyPiesek", Zwierzak.class);

        // default beanId
        Zwierzak kot = context.getBean("kotek", Zwierzak.class);

        System.out.println(piesek.getOkrzyk());
        System.out.println(kot.getOkrzyk());

        System.out.println("\njedzie zoo!");

        // autowired
        Zoo zoo = context.getBean("zoo", Zoo.class);
        zoo.piszZwierzeta();

        // autowired nie zadziala, bo zwierzaki sa interefejsami, i jest konflikt
        ZooQualified zooQualified = context.getBean("zooQualified", ZooQualified.class);
        zooQualified.pisz();
        context.close();
    }
}
