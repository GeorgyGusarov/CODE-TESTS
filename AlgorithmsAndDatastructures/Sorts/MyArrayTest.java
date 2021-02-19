package AlgorithmsAndDatastructures.Sorts;

import AlgorithmsAndDatastructures.Sorts.MyArray;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray a0 = new MyArray(7, 8, 1, 4, 5, 2, 3, 6, 9, 10);
        System.out.println("a0 " + a0);
        System.out.println("a0 length = " + a0.length());
        a0.append(11);
        System.out.println("a0 " + a0);
        a0.insert(11, 12);
        System.out.println("a0 " + a0);
        a0.deleteLast();
        System.out.println("a0 " + a0);
        a0.deleteByIndex(10);
        System.out.println("a0 " + a0);
        System.out.println("a0 " + a0.getMin());
        System.out.println("a0 " + a0.getMax());
        a0.bubbleSortImproved();
        System.out.println("a0 " + a0);
        a0.deleteAll();
        System.out.println("a0 " + a0);
    }
}
