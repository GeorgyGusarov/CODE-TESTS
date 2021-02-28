package Geekbrains_Java3.Lesson_3_InputOutput;

import java.io.*;

public class FileCreation_II {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        try (FileInputStream in = new FileInputStream("Lesson_3_test/Test4.txt")) {
            byte[] array = new byte[512];
            int x;
            while ((x = in.read(array)) > 0) {
                System.out.print(new String(array, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - t);
    }
}
