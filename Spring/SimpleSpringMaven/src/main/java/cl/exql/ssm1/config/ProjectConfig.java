package cl.exql.ssm1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import cl.exql.ssm1.model.Parrot;

@Configuration 
public class ProjectConfig {
	
	@Bean(name = "Koko")
	Parrot parrot1() {
		Parrot p = new Parrot();
		p.setName("Koko");
		return p;
	}
	
	@Bean(name = "Bulu")
	@Primary
	Parrot parrot2() {
		Parrot p = new Parrot();
		p.setName("Bulu");
		return p;
	}
	
	@Bean(name = "Fini")
	Parrot parrot3() {
		Parrot p = new Parrot();
		p.setName("Fini");
		return p;
	}
	
	@Bean(name = "Lele")
	Parrot parrot4() {
		Parrot p = new Parrot();
		p.setName("Lele");
		return p;
	}
	
	@Bean
	String hello() {
		return "Hello";
	}

	@Bean
	Integer number10() {
		return 10;
	}
}
