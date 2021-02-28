package Geekbrains_Java3.Lesson_4_Multithreading;

public class DeadLock_Solution_II {
    protected static Object mon = new Object();
    protected static volatile char currentLetter = 'A';

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1; i++) {
                        synchronized (mon) {
                            while (currentLetter != 'A') mon.wait();
                            System.out.print("A");
                            currentLetter = 'B';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1; i++) {
                        synchronized (mon) {
                            while (currentLetter != 'B') mon.wait();
                            System.out.print("B");
                            currentLetter = 'C';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1; i++) {
                        synchronized (mon) {
                            while (currentLetter != 'C') mon.wait();
                            System.out.print("C");
                            currentLetter = 'A';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
