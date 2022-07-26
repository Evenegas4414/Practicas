package Clases.Hilos;


public class HilosNuevos {
    public static void main(String[] args) {

        NewThread thread1 = new NewThread("Thread 1", 1_000);
        NewThread thread2 = new NewThread("Thread 2", 2_000);
        NewThread thread3 = new NewThread("Thread 3", 3_000);
        thread1.t.start();
        thread2.t.start();
        thread3.t.start();

        try {
            thread3.t.join();

        } catch (InterruptedException e) {
        }

        System.out.println("Main terminado");
    }
}

class NewThread implements Runnable {
    Thread t;
    String name;
    int millis;

    public NewThread(String name, int millis) {
        this.name = name;
        this.millis = millis;
        t = new Thread(this, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + ": "+ i);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                System.out.println(name + " - Error: " + e);
            }
        }
    }
}
