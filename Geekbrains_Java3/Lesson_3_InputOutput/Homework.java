package Geekbrains_Java3.Lesson_3_InputOutput;

import java.io.*;
import java.util.*;

public class Homework {
    public static void main(String[] args) {
        try {
            task1();
            task2();
            task3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Task 1
     * прочитать данные из файла и поместить их в массив байтов
     */
    public static void task1() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("Lesson_3_test/Test4.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
        }

        byte[] array = out.toByteArray();
        System.out.println(Arrays.toString(array));
        in.close();
        out.close();
    }

    /**
     * Task 2
     * прочитать данные из коллекции потоков. Поместить все в 1 файл и прочитать его.
     */
    public static void task2() throws IOException {
        long time = System.currentTimeMillis();

        ArrayList<InputStream> arrayList = new ArrayList<>();
        arrayList.add(new FileInputStream("Lesson_3_test/Test2.txt"));
        arrayList.add(new FileInputStream("Lesson_3_test/Test3.txt"));
        arrayList.add(new FileInputStream("Lesson_3_test/Test4.txt"));

        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(arrayList)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("Lesson_3_test/result.txt"));

        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
            System.out.print((char) x);
        }

        in.close();
        out.close();

        System.out.println(" ");
        System.out.println(System.currentTimeMillis() - time);
    }

    /**
     * Task 3
     * прочитать данные из книги (с определенной страницы)
     */
    public static void task3() throws IOException {
        final int PAGE_SIZE = 1800;

        RandomAccessFile raf = new RandomAccessFile("Lesson_3_test/Test4.txt", "r");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер страницы: ");

        int page = scanner.nextInt() - 1;
        raf.seek(page * PAGE_SIZE);

        byte[] array = new byte[1800];
        raf.read(array);

        System.out.print(new String(array));
        raf.close();
    }
}
