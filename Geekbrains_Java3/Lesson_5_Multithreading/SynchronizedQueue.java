package Geekbrains_Java3.Lesson_5_Multithreading;

import java.util.concurrent.*;

public class SynchronizedQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(3);
        abq.add("abc");
        abq.add("abc");
        abq.add("abc");

        Boolean result1 = abq.offer("abc");
        try {
            Boolean result2 = abq.offer("abc", 100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            abq.put("abc");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            abq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
