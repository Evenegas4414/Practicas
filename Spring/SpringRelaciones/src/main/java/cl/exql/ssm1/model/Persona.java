package cl.exql.ssm1.model;

public class Persona {

	String nombre;
	Loro loro;

	public Persona() {
		System.out.println("Persona creada");
	}

	public Persona(String nombre, Loro loro) {
		this.nombre = nombre;
		this.loro = loro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Loro getLoro() {
		return loro;
	}

	public void setLoro(Loro loro) {
		this.loro = loro;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", loro=" + loro + "]";
	}

}
