package Other;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_LinkedList {
    public static void main(String[] args) {

        /**
         * ArrayList
         */
        // Integer - указываем тип данных, к которым будет принадлежать массив и его содержимое
        // myName - название массива
        // (1000000) - изначальный размер. Может быть любым, мы можем добавлять и больше чем 1000000
        ArrayList<Integer> myName = new ArrayList<>(1000000);

        // добавляем элементы
        myName.add(5);
        myName.add(6);
        myName.size();
        myName.contains(1);
        myName.indexOf(1);

        // выводим через цикл
        for(Integer o : myName) System.out.println(o);

        /**
         * LinkedList
         */
        // Определяем тип данных String
        LinkedList<String> people = new LinkedList<>();

        people.add("Tom");
        people.add("John");

        for(String o : people) System.out.println(o);
    }
}
