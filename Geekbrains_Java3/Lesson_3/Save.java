package Geekbrains_Java3.Lesson_3;

import java.io.*;

public class Save {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Students student = new Students(1, "Bob"); // вывод на консоль: Human

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Lesson_3_test/students.ser"));

        Book book = new Book("HP"); // не будет участвовать в сериализации
        student.setBook(book);

        out.writeObject(student);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Lesson_3_test/students.ser"));
        Students student2 = (Students) in.readObject();
        in.close();
        student2.info(); // вывод на консоль: Human + содержимое файла
    }
}

class Students extends Human implements Serializable {
    int id;
    String name;

    private transient Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println(id + " " + name);
    }
}

class Human {
    public Human() {
        System.out.println("Human");
    }
}

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }
}
