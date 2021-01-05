package Geekbrains_Java3.Lesson_3;

import java.io.*;
import java.util.*;

public class PipedInputStream_I {
    public static void main(String[] args) throws IOException {
        PipedInputStream pin = null;
        PipedOutputStream pout = null;

        try {
            pin = new PipedInputStream();
            pout = new PipedOutputStream();
            pout.connect(pin); // тут они синхронизированы

            for (int i = 0; i < 100; i++) pout.write(i);

            int x;
            while ((x = pin.read()) != -1) System.out.println(x);

            pin.close();
            pout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
