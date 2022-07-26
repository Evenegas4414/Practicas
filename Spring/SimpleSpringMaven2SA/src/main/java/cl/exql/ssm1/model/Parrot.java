package cl.exql.ssm1.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

	private String name;

	public Parrot() {
	}

	@PostConstruct
	public void init() {
		this.setName("Tapu Koko");
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
