package Geekbrains_Java3.Lesson_3;

import java.io.*;

public class FolderCreation {
    public static void main(String[] args) throws IOException {
        File file = new File("Lesson_3_test/dir");
        file.mkdirs();

        String[] strings = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("T");
            }
        });

        for (String o : strings) {
            System.out.println(o);
        }
    }
}
