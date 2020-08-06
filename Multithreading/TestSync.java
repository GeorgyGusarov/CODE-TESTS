package Multithreading;

public class TestSync implements Runnable {

    private int balance;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println("Баланс равен " + balance + Thread.currentThread().getName());
        }
    }

    public synchronized void increment() {
        int i = balance;
        balance = i + 1;
    }

    public static void main(String[] args) {
        TestSync test = new TestSync();

        Thread a = new Thread(test);
        Thread b = new Thread(test);

        a.start();
        b.start();
    }
}
