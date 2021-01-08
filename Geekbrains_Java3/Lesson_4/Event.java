package Geekbrains_Java3.Lesson_4;

public class Event {
    public static void main(String[] args) {
        Object chair1 = new Object();
        Object chair2 = new Object(); // стул 2 мониторится

        /**
         * 1 и 2 потоки работают параллельно
         * 2 и 3 работают последовательно
         */

        Thread human1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Первый участник подошел к стулу 1");
                synchronized (chair1) {
                    System.out.println("Первый участник сел на стул 1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Первый участник встал со стула 1");
                }
            }
        });

        human1.start();

        Thread human2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Второй участник подошел к стулу 2");
                synchronized (chair2) {
                    System.out.println("Второй участник сел на стул 2");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Второй участник встал со стула 2");
                }
            }
        });

        human2.start();

        Thread human3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Третий участник подошел к стулу 2");
                synchronized (chair2) {
                    System.out.println("Третий участник сел на стул 2");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Третий участник встал со стула 2");
                }
            }
        });

        human3.start();
    }
}
