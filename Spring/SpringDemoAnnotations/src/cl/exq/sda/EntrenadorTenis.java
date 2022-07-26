package cl.exq.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntrenadorTenis implements Entrenador {
	
	private ServicioFortuna servicioFortuna;

	@Autowired
	public EntrenadorTenis(ServicioFortuna servicioFortuna) {
		super();
		this.servicioFortuna = servicioFortuna;
	}

	@Override
	public String obtenerEntrenamientoDiario() {
		
		return "Entrena con 2 raquetas.";
	}

	@Override
	public String obtenerFortunaDiaria() {
		return "Usa tu raqueta. " + servicioFortuna.obtenerFortuna();
	}

}
