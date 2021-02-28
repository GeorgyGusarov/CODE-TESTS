package Geekbrains_Java3.Lesson_3_InputOutput.ServerInteraction;

import java.io.Serializable;

public class Students implements Serializable {
    int id;
    String name;

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println(id + " " + name);
    }
}
