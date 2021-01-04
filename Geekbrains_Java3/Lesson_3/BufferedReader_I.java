package Geekbrains_Java3.Lesson_3;

import java.io.*;

public class BufferedReader_I {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        FileReader fr = null;

        fr = new FileReader("Lesson_3_test/Test4.txt");
        br = new BufferedReader(fr);
        String currentLine;

        while ((currentLine = br.readLine()) != null) {
            System.out.println(currentLine);
        }
        if (br != null) br.close();
        if (fr != null) fr.close();
    }
}
