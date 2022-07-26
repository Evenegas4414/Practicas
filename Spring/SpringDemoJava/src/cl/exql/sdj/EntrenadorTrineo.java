package cl.exql.sdj;

public class EntrenadorTrineo implements Entrenador {
	
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
