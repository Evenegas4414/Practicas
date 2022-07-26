package cl.exql.saop.terms;

import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService{
    @Override
    public void doSomething() {
        System.out.println("Something in CustomerServiceImpl...");
    }
}
