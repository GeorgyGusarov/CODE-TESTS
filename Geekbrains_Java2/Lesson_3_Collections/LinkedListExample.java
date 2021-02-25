package Geekbrains_Java2.Lesson_3_Collections;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.addFirst("z");

        System.out.println(linkedList);
    }
}

class BoxLinkedList {
    String color;
    int size;

    public BoxLinkedList(String color, int size) {
        this.color = color;
        this.size = size;
    }
}

class MainBoxLinkedList {
    public static void main(String[] args) {
        BoxLinkedList box1 = new BoxLinkedList("red", 1);
        BoxLinkedList box2 = new BoxLinkedList("red", 1);

        System.out.println(box1.hashCode());
        System.out.println(box2.hashCode());
        System.out.println(box1.equals(box2));
    }
}
