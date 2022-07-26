package cl.exql.slc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Customer implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private String firstName;

    public Customer() {
        System.out.println("Customer non-arg constructor...");
    }

    public Customer(String firstName) {
        this.firstName = firstName;
        System.out.println("Customer firstName constructor... " + firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        System.out.println("firstName is... " + firstName);
    }


    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory: " + beanFactory);
        System.out.println("setBeanFactory: " + beanFactory.isSingleton("cust1"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext: " + applicationContext);
        System.out.println("setApplicationContext: " + applicationContext.getDisplayName());
    }
}
