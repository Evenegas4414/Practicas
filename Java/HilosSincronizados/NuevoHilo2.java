package Clases.HilosSincronizados;

public class NuevoHilo2 extends Thread{

    public NuevoHilo2() {
        super(null, null, "nohilo");
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print("Numero: " + i + ". " );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
