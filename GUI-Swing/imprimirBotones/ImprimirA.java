package swing.imprimirBotones;

public class ImprimirA implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.print("A" + i + " - ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
