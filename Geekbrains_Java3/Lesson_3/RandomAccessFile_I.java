package Geekbrains_Java3.Lesson_3;

import java.io.*;

public class RandomAccessFile_I {
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("Lesson_3_test/Test2.txt", "r")) {
            raf.seek(0);
            System.out.print((char) raf.read());
            raf.seek(1);
            System.out.print((char) raf.read());
            raf.seek(2);
            System.out.print((char) raf.read());
            raf.seek(3);
            System.out.print((char) raf.read());
        }
    }
}
