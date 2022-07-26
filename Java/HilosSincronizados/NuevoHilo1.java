package Clases.HilosSincronizados;

public class NuevoHilo1 implements Runnable {
    Thread t;
    String threadName;
    int sleepTime;
    public NuevoHilo1(String tn, int st) {
        t = new Thread(this, tn);
        threadName = tn;
        sleepTime = st;

    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
