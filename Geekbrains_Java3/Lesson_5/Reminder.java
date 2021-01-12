package Geekbrains_Java3.Lesson_5;

import java.util.*;

public class Reminder {
    public static void main(String[] args) {
        Reminder reminder = new Reminder();
        reminder.setTimer();
    }

    void setTimer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 22);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);

        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), time);
    }
}

class RemindTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("up!");
    }
}
