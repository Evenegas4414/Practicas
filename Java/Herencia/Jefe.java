package Clases.Herencia;

import com.sun.source.doctree.SinceTree;

public class Jefe extends Empleado{

    public Jefe(String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }

    public double incentivo(double inc) {
        return inc;
    }
}
