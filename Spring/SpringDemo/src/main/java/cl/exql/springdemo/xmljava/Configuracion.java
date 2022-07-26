package cl.exql.springdemo.xmljava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Configuracion {

    @Bean
    public ServicioEmail servicioEmail() {
        ServicioEmail se = new ServicioEmail();
        return se;
    }

    @Bean
    @Scope("prototype")
    public ServicioEmail servicioEmailPrototype() {
        ServicioEmail se = new ServicioEmail();
        return se;
    }
}
