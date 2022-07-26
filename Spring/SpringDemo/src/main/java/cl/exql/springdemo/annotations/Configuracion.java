package cl.exql.springdemo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("cl.exql.springdemo.annotations")
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
