package Geekbrains_Java2.Lesson_5_Multithreading;

public class ClassThread {
    public static void main(String[] args) {
        /**
         * Реализация через наследование
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
//        t1.run();
//        t2.run();
        t1.start();
        t2.start();

        /**
         * Реализация через интерфейс
         */
        Thread thread1 = new Thread(new MyThread2()); // можно сделать через анонимный класс
        Thread thread2 = new Thread(new MyThread2());
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}

class MyThread2 implements Runnable {   // реализация через интерфейс
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}


class MyThread extends Thread { // это реализация через наследование
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
