package Clases.HilosSincronizados;

public class UsoHilos {
    public static void main(String[] args) {
        NuevoHilo1 miHilo1 = new NuevoHilo1("Hilo 1", 2000);
        NuevoHilo1 miHilo2 = new NuevoHilo1("Hilo 2", 500);
        NuevoHilo1 miHilo3 = new NuevoHilo1("Hilo 3", 4000);

        miHilo1.t.start();
        miHilo2.t.start();
        miHilo3.t.start();

        try {
            miHilo1.t.join();
            System.out.println(miHilo1.t.getName() + " terminado.");
            miHilo2.t.join();
            System.out.println(miHilo2.t.getName() + " terminado.");
            miHilo3.t.join();
            System.out.println(miHilo3.t.getName() + " terminado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}