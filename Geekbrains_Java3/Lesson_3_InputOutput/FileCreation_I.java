package Geekbrains_Java3.Lesson_3_InputOutput;

import java.io.*;

public class FileCreation_I {
    public static void main(String[] args) throws IOException {
        File newFile = new File("Java2_Lesson_3.txt");

        if (newFile.exists()) {
            throw new IOException("file already exist!");
        }

        File newFile2 = new File("Java2_Lesson_4.txt");
        newFile.createNewFile();
        newFile2.renameTo(newFile);
    }
}
