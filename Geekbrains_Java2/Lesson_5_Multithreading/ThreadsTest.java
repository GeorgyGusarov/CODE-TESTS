package Geekbrains_Java2.Lesson_5_Multithreading;

import java.util.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class ThreadsTest {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int THREADS_COUNT = 4;
        final int PART_SIZE = SIZE / THREADS_COUNT;
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        long a = currentTimeMillis();
        final float[][] m = new float[THREADS_COUNT][PART_SIZE];

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(array, PART_SIZE * 1, m[i], 0, PART_SIZE);
            final int u = i;

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int n = u * PART_SIZE;

                    for (int j = 0; j < PART_SIZE; j++, n++) {
                        m[u][j] = (float) (m[u][j] * sin(0.2f + n / 5) * cos(0.2f + n / 5) * cos(0.4f + n / 5));
                    }
                }
            });
            threads[i].start();
        }
        try {
            for (int i = 0; i < THREADS_COUNT; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(m[i], 0, array, i * PART_SIZE, PART_SIZE);
        }
        System.out.println(currentTimeMillis() - a);
    }
}
