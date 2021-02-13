package AlgorithmsAndDatastructures.Sorts;

import AlgorithmsAndDatastructures.Sorts.MyArray;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray a0 = new MyArray(7, 8, 1, 4, 5, 2, 3, 6, 9, 10);
        System.out.println(a0);

        MyArray a1 = new MyArray(0);
        a1.append(1); a1.append(7);
        a1.append(-5); a1.append(2);
        a1.append(7); a1.append(3);
        a1.append(7); a1.append(0);
        System.out.println(a1);

        a1.deleteAllByValue(7);
        System.out.println(a1);

        a1.insert(1, -1);
        System.out.println(a1);

        a1.pigeonHoleSort();
        System.out.println(a1);

        MyArray a2 = new MyArray(5);
        a2.appendRandom(100, 100);
    }
}
