package cl.exql.slc.beanlife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beanlife.xml");

        //Customer cust1 = context.getBean("cust1", Customer.class);
        Customer cust2 = context.getBean("cust2", Customer.class);

        //System.out.println(cust1.getFirstName());
        //System.out.println(cust2.getFirstName());


    }
}
