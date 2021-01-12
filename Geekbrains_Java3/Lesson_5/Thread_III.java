package Geekbrains_Java3.Lesson_5;

import java.util.concurrent.*;

public class Thread_III {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        int[] array = {1, 2, 3, 4}; // 1+2+3+4 = 10

        int[] threads1 = new int[2]; // 1, 2 будут тут
        int[] threads2 = new int[2]; // 3, 4 будут тут

        System.arraycopy(array, 0, threads1, 0, threads1.length);
        System.arraycopy(array, 2, threads2, 0, threads2.length);

        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < threads1.length; i++) {
                    result += threads1[i];
                }
                return result;
            }
        };

        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < threads2.length; i++) {
                    result += threads2[i];
                }
                return result;
            }
        };

        Future<Integer> future1 = executorService.submit(callable1);
        Future<Integer> future2 = executorService.submit(callable2);

        System.out.println(future1.get() + future2.get());
        executorService.shutdown();
    }
}
