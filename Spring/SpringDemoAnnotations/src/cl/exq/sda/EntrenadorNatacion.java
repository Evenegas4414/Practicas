package cl.exq.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntrenadorNatacion implements Entrenador {
	
	private ServicioFortuna servicioFortuna;

	public EntrenadorNatacion() {
		
	}

	public ServicioFortuna getServicioFortuna() {
		return servicioFortuna;
	}

	@Autowired
	public void setServicioFortuna(ServicioFortuna servicioFortuna) {
		this.servicioFortuna = servicioFortuna;
	}

	@Override
	public String obtenerEntrenamientoDiario() {
		
		return "Entrena con 1 flotador.";
	}

	@Override
	public String obtenerFortunaDiaria() {
		return "No dejes de respirar. " + servicioFortuna.obtenerFortuna();
	}

}
