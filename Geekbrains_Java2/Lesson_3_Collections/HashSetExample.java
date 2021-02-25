package Geekbrains_Java2.Lesson_3_Collections;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Бета");
        hashSet.add("Альфа");
        hashSet.add("Гамма");

        System.out.println(hashSet);
    }
}
