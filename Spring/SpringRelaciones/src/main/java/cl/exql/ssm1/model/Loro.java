package cl.exql.ssm1.model;

public class Loro {

	private String nombre;

	public Loro() {
		System.out.println("Loro creado");
	}

	public Loro(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Loro [nombre=" + nombre + "]";
	}
}
