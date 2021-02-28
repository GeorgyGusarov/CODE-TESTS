package Geekbrains_Java3.Lesson_5_Multithreading;

import java.util.concurrent.*;

public class Concurrent_Example {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4, new ThreadFactory() { // пул потоков, который определяет фабрика
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("new thread!");
                return new Thread(r);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(1);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(2);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(3);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(4);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(5);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(6);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(7);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(8);
            }
        });

        pool.shutdown();
    }
}
