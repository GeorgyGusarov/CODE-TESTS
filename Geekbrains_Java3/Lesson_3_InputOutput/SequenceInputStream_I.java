package Geekbrains_Java3.Lesson_3_InputOutput;

import java.io.*;
import java.util.*;

public class SequenceInputStream_I {
    public static void main(String[] args) throws IOException {
        ArrayList<InputStream> inputStreamArrayList = new ArrayList<>();
        inputStreamArrayList.add(new FileInputStream("Lesson_3_test/Test2.txt"));
        inputStreamArrayList.add(new FileInputStream("Lesson_3_test/Test3.txt"));
        inputStreamArrayList.add(new FileInputStream("Lesson_3_test/Test4.txt"));

        SequenceInputStream sin = new SequenceInputStream(Collections.enumeration(inputStreamArrayList));

        int x;
        while ((x = sin.read()) != -1) System.out.print((char) x);
        sin.close();
    }
}
