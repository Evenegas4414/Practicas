package cl.exq.sda;

import org.springframework.stereotype.Component;

@Component
public class BuenaFortuna implements ServicioFortuna {

	@Override
	public String obtenerFortuna() {

		return "Hoy es tu dia de buena suerte.";
	}

}
