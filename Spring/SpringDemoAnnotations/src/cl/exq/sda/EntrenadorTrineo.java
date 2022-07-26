package cl.exq.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntrenadorTrineo implements Entrenador {
	
	@Autowired
	private ServicioFortuna servicioFortuna;

	public EntrenadorTrineo() {
		
	}

	@Override
	public String obtenerEntrenamientoDiario() {
		
		return "Deslizate 2 km en la nieve.";
	}

	@Override
	public String obtenerFortunaDiaria() {
		return "Limpia tu trineo. " + servicioFortuna.obtenerFortuna();
	}

}
