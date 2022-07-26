package cl.exql.ssm1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.exql.ssm1.model.Loro;
import cl.exql.ssm1.model.Persona;

@Configuration 
public class Configuracion {
	@Bean
	public Persona persona() {
		Persona p = new Persona();
		p.setNombre("Ella");
		p.setLoro(loro());
		return p;
	}
	
	@Bean
	public Loro loro() {
		Loro l = new Loro();
		l.setNombre("Lucas");
		return l;
	}
	
	
} 
