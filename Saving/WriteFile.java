package Saving;

import java.io.*;

public class WriteFile {

    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Привет, Foo!");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
