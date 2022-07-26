package cl.exql.springdemo.xmljava;

import org.springframework.stereotype.Component;

public class ServicioEmail {

    public void enviarEmail(String remitente, String mensaje ) {
        System.out.println(remitente.toUpperCase() + ": " + mensaje);

    }
}
