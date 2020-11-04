package Geekbrains_Java2.Lesson_3;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Васька", 6);
        map.put("Мурзик", 3);
        map.put("Рыжик", 2);
        map.put("Васька", 1);

        System.out.println(map);

        // пример перебора HashMap через for
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> newSet : set) {
            System.out.println(newSet.getKey() + " " + newSet.getValue());
        }
    }
}

class HashMapExample2 {
    public static void main(String[] args) {
        /**
         * Задача:
         * 100 раз сформировать рандомные числа от 0 до 10
         * посмотреть сколько раз значения будут повторяться
         */
        Random random = new Random();
        Map<Integer, Integer> mapOfNumbers = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            int number = random.nextInt(10);
            Integer current = mapOfNumbers.get(number);
            mapOfNumbers.put(number, current == null ? 1 : current + 1);
        }
        System.out.println(mapOfNumbers);
    }
}

class HashMapExample3 {
    public static void main(String[] args) {
        int key = 771;
        HashMap<Integer, String> hashMap = start();
        System.out.println(hashMap.getOrDefault(key, "not found!"));
    }

    static HashMap<Integer, String> start() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(771, "test1");
        hashMap.put(772, "test2");
        return hashMap;
    }
}

class HashMapExample4 {
    public static void main(String[] args) {
        String[] array = {"ABC", "BCD", "ABC", "TRE"};
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String o : array) {
            hashMap.put(o, hashMap.getOrDefault(o, 0) + 1);
        }
        System.out.println(hashMap);
    }
}

class HashMapExample5 {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add("Иванов", "123");
        book.add("Иванов", "124");
        book.add("Иванов", "125");
        book.add("Петров", "444");
        book.add("Петров", "445");
        book.add("Петров", "446");

        book.findString("Иванов");
        book.findString("Петров");
        book.findString("Сидоров");
    }
}

class PhoneBook {
    HashMap<String, HashSet<String>> hashMap;

    public PhoneBook() {
        this.hashMap = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> hashSet = hashMap.getOrDefault(name, new HashSet<>());
        hashSet.add(phone);
        hashMap.put(name, hashSet);
    }

    public void findString(String name) {
        if (hashMap.containsKey(name)) {
            System.out.println(hashMap.get(name));
        } else {
            System.out.println("такой фамилии нет");
        }
    }
}

