package Geekbrains_Java3.Lesson_5_Multithreading;

import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(w + " -1");
                    try {
                        Thread.sleep((int) Math.random() * 300000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(w + " -2");
                    countDownLatch.countDown(); // уменьшает счётчик на 1
                }
            }).start();
        }
        try {
            countDownLatch.await(); // ждет пока счётчик достигнет 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
