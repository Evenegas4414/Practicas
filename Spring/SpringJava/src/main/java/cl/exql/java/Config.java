package cl.exql.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "customer", initMethod = "customInit")
    public Customer customer() {
        return new Customer();
    }

    @Bean(name = "customer1")
    public Customer customer1() {
        return new Customer("Exequiel");
    }



}
