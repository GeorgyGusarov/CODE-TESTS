package Geekbrains_Java3.Lesson_5;

import java.util.concurrent.*;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4); // ограничили кол-во потоков до 4
        ExecutorService executorService = Executors.newFixedThreadPool(10); // всего выставили 10 потоков

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(1); // вывод будет по 4 потока (4 + 4 + 2 = 10)
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
