package Clases.GenericosLambdas;

public class Pareja<T> {

    private T primero;

    public Pareja(){
        primero = null;
    }

    public void establecerPrimero(T tipo) {
        primero = tipo;
    }

    public T obtenerPrimero() {
        return primero;
    }
}
