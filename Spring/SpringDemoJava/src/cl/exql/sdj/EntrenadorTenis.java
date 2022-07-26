package cl.exql.sdj;

public class EntrenadorTenis implements Entrenador {
	
	private ServicioFortuna servicioFortuna;

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
