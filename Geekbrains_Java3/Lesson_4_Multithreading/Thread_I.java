package Geekbrains_Java3.Lesson_4_Multithreading;

public class Thread_I {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        });

        t1.start();
        t2.start();

        while (true) {
            if (!t1.isAlive()) break;
        }

        while (true) {
            if (!t2.isAlive()) break;
        }

        System.out.println("END");
    }
}

/**
 * реализация через наследование
 */
class Thread_II extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

/**
 * реализация через подписку на интерфейс
 */
class Runnable_I implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
