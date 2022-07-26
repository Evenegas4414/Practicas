package cl.exql.springdemo.annotations;

import org.springframework.stereotype.Component;

@Component
public class ServicioEmail {

    public void enviarEmail(String remitente, String mensaje ) {
        System.out.println(remitente.toUpperCase() + ": " + mensaje);

    }
}
