package Geekbrains_Java3.Lesson_5_Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample { // аналог примера Counter из Geekbrains_Java2/Lesson_5
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " did inc");
                    ai.incrementAndGet();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " did dec");
                    ai.decrementAndGet();
                }
            }
        }).start();

        System.out.println(ai);
    }
}
