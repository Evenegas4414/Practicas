package Clases.HilosSincronizados;




public class ProducerConsumer {
    public static void main(String[] args) {
        QueueFixed q = new QueueFixed();
        ConsumerFixed c = new ConsumerFixed(q);
        Producer p = new Producer(q);

        p.t.start();
        c.t.start();

        System.out.println("Press Control + C to stop.");
    }

}

class Producer implements Runnable {
    QueueFixed q;
    Thread t;

    public Producer(QueueFixed q) {
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

class Consumer implements Runnable {
    QueueFixed q;
    Thread t;

    public Consumer(QueueFixed q) {
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

class Queue {
    int n;

    synchronized int get() {
        System.out.println("Got: " + n);
        return n;
    }

    synchronized void put(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }
}
