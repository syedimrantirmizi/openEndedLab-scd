package imran;

class SharedBuffer {
    private int buffer = 0;

    public synchronized void produce() throws InterruptedException {
        while (buffer > 0) {
            wait(); // wait if buffer is full
        }
        buffer++;
        System.out.println("Produced: " + buffer);
        notify(); // Notify consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer == 0) {
            wait(); // wait if buffer is empty
        }
        buffer--;
        System.out.println("Consumed: " + buffer);
        notify(); // Notify producer
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                buffer.produce();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}

