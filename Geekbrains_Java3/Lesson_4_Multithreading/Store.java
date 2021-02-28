package Geekbrains_Java3.Lesson_4_Multithreading;

public class Store {
    public static void main(String[] args) {
        Store store = new Store();
        Supplier supplier = new Supplier(store);
        Consumer consumer = new Consumer(store);

        new Thread(supplier).start();
        new Thread(consumer).start();
    }

     private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе " + product);
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Поставщик привез 1 товар");
        System.out.println("Товаров на складе " + product);
        notify();
    }
}

class Supplier implements Runnable {
    Store store;

    public Supplier(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
