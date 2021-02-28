package Geekbrains_Java3.Lesson_5_Multithreading;

import java.util.concurrent.locks.*;

public class ReentrantLockExample_Improved {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static String message = "a";

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Read());
        Thread t2 = new Thread(new WriteA());
        Thread t3 = new Thread(new WriteB());

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t1.join();
        t1.join();
    }

    static class Read implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                if (lock.isWriteLocked()) System.out.println("I'll take the lock from Write");
                lock.readLock().lock();
                System.out.println("Read thread " + Thread.currentThread().getId() + " ---> Message is " + message);
                lock.readLock().unlock();
            }
        }
    }

    static class WriteA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                lock.writeLock().lock();
                message = message.concat("a");
                lock.writeLock().unlock();
            }
        }
    }
    static class WriteB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                lock.writeLock().lock();
                message = message.concat("b");
                lock.writeLock().unlock();
            }
        }
    }

}
