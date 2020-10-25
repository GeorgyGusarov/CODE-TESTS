package Geekbrains_Java2.Lesson_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception {
    public static void main(String[] args) {
        int b;

        try {
            int[] array = {1, 2, 3};
            b = 10 / 0;
            array[10] = 20;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Делить на ноль нельзя!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            System.out.println("Вышли за пределы массива!");
        } finally {
            System.out.println("Выполнится в любом случае");
        }
        System.out.println("end");

        try {
            AlertException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void AlertException() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
    }
}
