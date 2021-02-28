package Geekbrains_Java3.Lesson_4_Multithreading;

public class DeadLock_Solution_I {
    protected static volatile char str = 'A';

    public static void main(String[] args) {
        Object lock = new Object();

        class MyTask implements Runnable {
            private char b;
            private char nextB;

            public MyTask(char b, char nextB) {
                this.b = b;
                this.nextB = nextB;
            }

            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 1; i++) {
                        try {
                            while (str != b) lock.wait();
                            System.out.print(b);
                            str = nextB;
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        new Thread(new MyTask('A', 'B')).start();
        new Thread(new MyTask('B', 'C')).start();
        new Thread(new MyTask('C', 'A')).start();
    }
}
