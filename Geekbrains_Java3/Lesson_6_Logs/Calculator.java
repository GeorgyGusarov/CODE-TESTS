package Geekbrains_Java3.Lesson_6_Logs;

public class Calculator {
    public int add (int a, int b) {
        return a + b;
    }

    public int div (int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a / b;
    }
}
