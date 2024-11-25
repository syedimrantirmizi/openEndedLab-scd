package imran;

class CalculationThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Calculating: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class LoggingThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Logging data: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread calcThread = new CalculationThread();
        Thread logThread = new LoggingThread();

        calcThread.start();
        logThread.start();
        
        calcThread.join(); // Ensure calculation finishes before logging
        logThread.join();
    }
}