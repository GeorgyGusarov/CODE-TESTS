package Geekbrains_Java2.Lesson_5;

public class ATM {
    int money;

    public ATM(int money) {
        this.money = money;
    }

    public synchronized void take(int amount, String user) {
        if (money >= amount) {
            try {
                Thread.sleep(500);  //имитируем связь с сервером
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println(user + " took " + amount);
        } else {
            System.out.println("not enough money in ATM for " + user);
        }
    }

    public void info() {
        System.out.println("money in ATM " + money);
    }
}

class MainATM {
    public static void main(String[] args) {
        ATM atm = new ATM(100);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.take(50, "user1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.take(50, "user2");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.take(50, "user3");
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        atm.info();
    }
}
