package Geekbrains_Java2.Lesson_5;

public class DaemonThreadExample {
    public static void main(String[] args) {

        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int sec = 0;

                while (sec < 10) {
                    sec++;
                    System.out.println("current time: " + sec);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        timer.setDaemon(true);
        timer.start();

        try {
            Thread.sleep(5000); // sleep основного потока 5 сек
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("END");
    }
}
