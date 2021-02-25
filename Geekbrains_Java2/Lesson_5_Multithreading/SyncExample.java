package Geekbrains_Java2.Lesson_5_Multithreading;

public class SyncExample {
    Object object = new Object();

    void doSomething() {
        /**
         * параллельно
         */
        System.out.println(1);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * этот кусок кода выполняется последовательно, остальные параллельно
         */
        synchronized (object) {
            System.out.println(201);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(202);
        }
        /**
         * параллельно
         */
        System.out.println(2);
    }
}

class SyncExampleMain {
    public static void main(String[] args) {
        SyncExample syncExample = new SyncExample();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncExample.doSomething();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncExample.doSomething();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncExample.doSomething();
            }
        }).start();
    }
}
