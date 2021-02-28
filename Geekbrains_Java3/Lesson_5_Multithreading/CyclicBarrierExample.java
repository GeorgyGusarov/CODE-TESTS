package Geekbrains_Java3.Lesson_5_Multithreading;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        for (int i = 0; i < 10; i++) { // i < 20
            int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(w + " start");
                    try {
                        Thread.sleep((int) Math.random() * 5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(w + " ready");
                    try {
                        cyclicBarrier.await(); // приостановит поток, пока он не будет вызван у всех потоков
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(w + " end");
                }
            }).start();
        }
    }
}
