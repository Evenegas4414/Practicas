package Clases.Serializacion;
import java.io.Serializable;
import java.time.LocalDate;

public class ArraysLista {

    public static void main(String[] args) {

        Empleado[] listaPersonal =  new Empleado[3];
        listaPersonal[0] = new Empleado("Eva", 320_000, 2004, 1, 1);
        listaPersonal[1] = new Empleado("Ana", 60_000, 2007, 3, 6);
        listaPersonal[2] = new Empleado("Luis", 65_000, 2005, 11, 10);

        for (Empleado e: listaPersonal) {
            System.out.println(e.toString());
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
        sueldo+= aumento;
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
