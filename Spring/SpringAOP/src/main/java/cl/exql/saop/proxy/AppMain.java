package cl.exql.saop.proxy;

public class AppMain {
    public static void main(String[] args) {
        FancyBeanFactory beanFactory = new FancyBeanFactory();
        CustomerService customerService = (CustomerService) beanFactory.getBean("customerService");

        customerService.doSomething();
    }
}
