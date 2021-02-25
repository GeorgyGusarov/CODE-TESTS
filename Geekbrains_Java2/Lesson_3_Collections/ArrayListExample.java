package Geekbrains_Java2.Lesson_3_Collections;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[20];
        System.arraycopy(array1, 0, array2, 0, array1.length);
        System.out.println(Arrays.toString(array2) + "\n");

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.ensureCapacity(1000);
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        System.out.println(arrayList1);
        System.out.println("размер массива = " + arrayList1.size());

        arrayList1.remove((Integer) 3); // arrayList1.remove(1) - удалит элемент по индексу 2
        System.out.println(arrayList1 + ": удалили элемент 3");

        if (arrayList1.contains(2)) {
            System.out.println("есть 2 элемент\n");
        }
        arrayList1.trimToSize();    // обрезать неиспользуемый объём массива

        ArrayList<String> countries = new ArrayList<>();
        countries.add("Германия");
        countries.add("Германия");
        countries.add("Франция");
        countries.add("Италия");
        countries.add("США");
        countries.add("Россия");

        /**
         * Iterator
         */
        Iterator<String> countriesIterator = countries.iterator();
        // перебераем элементы
        while (countriesIterator.hasNext()) {
            if (countriesIterator.next().equalsIgnoreCase("Германия")) {
                countriesIterator.remove();
            }
        }
        System.out.println(countries);

//        for (int i = 0; i < countries.size(); i++) {
//            if (countries.get(i).equalsIgnoreCase("Германия")) {
//                countries.remove(i);
//            }
//        }

        try {
            System.out.println(countriesIterator.next());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Все элементы из массива были удалены. Нечего выводить в консоль.");
        }

//        /**
//         * ListIterator
//         */
//        ListIterator<String> countriesListIterator = countries.listIterator();
//        while (countriesListIterator.hasPrevious()) {
//            if (countriesListIterator.next().equalsIgnoreCase("Германия")) {
//                countriesListIterator.remove();
//            }
//        }
//        System.out.println(countries);
    }
}
