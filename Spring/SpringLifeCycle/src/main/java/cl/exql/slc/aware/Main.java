package cl.exql.slc.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("aware.xml");

        Customer cust1 = context.getBean("cust1", Customer.class);
        Customer cust2 = context.getBean("cust2", Customer.class);

        //System.out.println(cust1.getFirstName());
        //System.out.println(cust2.getFirstName());


    }
}
