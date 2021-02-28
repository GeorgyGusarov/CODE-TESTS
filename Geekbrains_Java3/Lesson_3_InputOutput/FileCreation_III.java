package Geekbrains_Java3.Lesson_3_InputOutput;

import java.io.*;

public class FileCreation_III {
    public static void main(String[] args) {
        try (InputStreamReader inr = new InputStreamReader(new FileInputStream("Lesson_3_test/Test4.txt"), "UTF-8")) {
            int x;
            while ((x = inr.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
