package Clases.HilosSincronizados;




public class ProducerConsumerFixed {
    public static void main(String[] args) {
        QueueFixed q = new QueueFixed();
        ConsumerFixed c = new ConsumerFixed(q);
        Producer p = new Producer(q);

        p.t.start();
        c.t.start();

        System.out.println("Press Control + C to stop.");
    }

}

class ProducerFixed implements Runnable {
    QueueFixed q;
    Thread t;

    public ProducerFixed(QueueFixed q) {
        this.q = q;
        t = new Thread(this, "Producer Thread");
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}

class ConsumerFixed implements Runnable {
    QueueFixed q;
    Thread t;

    public ConsumerFixed(QueueFixed q) {
        this.q = q;
        t = new Thread(this, "Consumer Thread");
    }

    @Override
    public void run() {

        while (true) {
            q.get();
        }
    }
}

class QueueFixed {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}
