package cl.exql.springdemo.xmljava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext contextXml = new ClassPathXmlApplicationContext("configuracion.xml");
        ApplicationContext contextJava = new AnnotationConfigApplicationContext(Configuracion.class);


        ServicioEmail servicioEmailXml1 = contextXml.getBean("servicioEmail", ServicioEmail.class);
        ServicioEmail servicioEmailXml2 = contextXml.getBean("servicioEmail", ServicioEmail.class);
        ServicioEmail servicioEmailXml3 = contextXml.getBean("servicioEmailPrototype", ServicioEmail.class);
        ServicioEmail servicioEmailXml4 = contextXml.getBean("servicioEmailPrototype", ServicioEmail.class);



        ServicioEmail servicioEmailJava1 = contextJava.getBean("servicioEmail", ServicioEmail.class);
        ServicioEmail servicioEmailJava2 = contextJava.getBean("servicioEmail", ServicioEmail.class);
        ServicioEmail servicioEmailJava3 = contextJava.getBean("servicioEmailPrototype", ServicioEmail.class);
        ServicioEmail servicioEmailJava4 = contextJava.getBean("servicioEmailPrototype", ServicioEmail.class);


        System.out.println(servicioEmailXml1);
        System.out.println(servicioEmailXml2);
        System.out.println(servicioEmailXml3);
        System.out.println(servicioEmailXml4);



        System.out.println(servicioEmailJava1);
        System.out.println(servicioEmailJava2);
        System.out.println(servicioEmailJava3);
        System.out.println(servicioEmailJava4);


    }
}
