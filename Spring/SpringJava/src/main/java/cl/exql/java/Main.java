package cl.exql.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Customer customer1 = context.getBean("customer1", Customer.class);

        System.out.println(customer1);
        System.out.println(customer1.getFirstName());
    }
}
