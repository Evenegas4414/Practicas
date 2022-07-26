package cl.exql.slc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Customer implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,
        BeanPostProcessor {

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
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext: " + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.firstName = "Rojas";
        System.out.println("afterPropertiesSet: " + firstName);

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization: " + bean + " " + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization: " + bean + " " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
