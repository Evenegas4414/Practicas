package Clases.Serializacion;

import java.io.*;
import java.time.LocalDate;

public class Serie {

	public static void main(String[] args) {
		Administrador jefe1 = new Administrador("Juan", 80_000, 2005, 2, 1);
		jefe1.establecerIncentivo(5000);

		Empleado[] listaPersonal = new Empleado[3];
		listaPersonal[0] = jefe1;
		listaPersonal[1] = new Empleado("Ana", 60_000, 2007, 3, 6);
		listaPersonal[2] = new Empleado("Luis", 65_000, 2005, 11, 10);

		try {
			// Cambiar direccion
			ObjectOutputStream miObjetoByte = new ObjectOutputStream(
					new FileOutputStream("src/com/miObjeto.txt"));
			miObjetoByte.writeObject(listaPersonal);
			miObjetoByte.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			// Cambiar direccion
			ObjectInputStream miObjetoRecuperado = new ObjectInputStream(
					new FileInputStream("src/com/miObjeto.txt"));
			try {
				Empleado[] listaRecuperada = (Empleado[]) miObjetoRecuperado.readObject();
				for (Empleado e : listaRecuperada) {
					System.out.println(e);
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			miObjetoRecuperado.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Empleado implements Serializable {

	private final String nombre;
	private double sueldo;
	private final LocalDate fechaContrato;

	public Empleado(String nombre, double sueldo, int agno, int mes, int dia) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		fechaContrato = LocalDate.of(agno, mes, dia);

	}

	public String obtenerNombre() {
		return nombre;
	}

	public double obtenerSueldo() {
		return sueldo;
	}

	public LocalDate obtenerFechaContrato() {
		return fechaContrato;
	}

	public void aumentarSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}

	public String toString() {
		return "Datos: " + nombre + ", " + sueldo + ", " + fechaContrato.toString() + ".";
	}
}

class Administrador extends Empleado {
	private double incentivo;

	public Administrador(String nombre, double sueldo, int agno, int mes, int dia) {
		super(nombre, sueldo, agno, mes, dia);
		incentivo = 0;
	}

	public void establecerIncentivo(double b) {
		incentivo = b;
	}

	public double obtenerSueldo() {
		double sueldoBase = super.obtenerSueldo();
		return sueldoBase + incentivo;
	}

	public String toString() {
		return super.toString() + " Incentivo: " + incentivo + ".";
	}

}
