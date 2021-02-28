package Geekbrains_Java3.Lesson_4_Multithreading;

public class MFU {
    public static void main(String[] args) {
        final MFU mfu = new MFU();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 1", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 2", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Doc 3", 5, 1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Doc 4", 5, 2);
            }
        }).start();
    }

    Object printLock = new Object();
    Object scanLock = new Object();

    public void print(String doc, int n) {
        synchronized (printLock) {
            System.out.println("Начало печати " + doc);
            for (int i = 0; i < 10; i++) {
                System.out.println("Ожидание :" + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Конец печати " + doc);
        }
    }

    public void scan(String doc, int n, int source) {
        synchronized (scanLock) {
            System.out.println("Начало сканирования " + doc);
            switch (source) {
                case 1 :
                    System.out.println("Сканирование в сеть " + doc);
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Ожидание :" + i);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2 :
                    synchronized (printLock) {
                        System.out.println("Ксерокопия начало " + doc);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Ожидание :" + i);
                        }
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Ксерокопия конец " + doc);
                        break;
                    }
            }
            System.out.println("Конец сканирования");
        }
    }
}
