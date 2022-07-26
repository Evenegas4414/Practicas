package cl.exql.ssm1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.exql.ssm1.config.Configuracion;
import cl.exql.ssm1.model.Loro;
import cl.exql.ssm1.model.Persona;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		Loro loro1 = context.getBean(Loro.class);
		
		Persona persona1 = context.getBean(Persona.class);
		
		
		System.out.println(loro1.getNombre());
		
		System.out.println(persona1.getNombre());
		System.out.println(persona1.getLoro());
		

	}

}
