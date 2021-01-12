package Geekbrains_Java3.Lesson_5;

import java.util.*;
import java.util.concurrent.*;

public class ScheduleThreadExample_I {
    static Random random = new Random();

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + " start work");
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + " end work");
            }
        }, 0, 1000L, TimeUnit.MILLISECONDS);
    }
}
