package Geekbrains_Java2.Lesson_1;

import java.util.*;

public class StudentsTeam {

    private String[] students = {"Васька", "София", "Пётр"};

    public String[] getStudents() {
        String[] studentsCopy = new String[students.length];

        for (int i = 0; i < students.length; i++) {
            studentsCopy[i] = students[i];
        }
        return studentsCopy;
    }

    void info() {
        System.out.println(Arrays.toString(students));
    }
}

class TestStudentsTeam {
    public static void main(String[] args) {
        StudentsTeam team1 = new StudentsTeam();

        String[] array = team1.getStudents();
        array[1] = "asdasd";

        team1.info();
        System.out.println(Arrays.toString(array));
    }
}
