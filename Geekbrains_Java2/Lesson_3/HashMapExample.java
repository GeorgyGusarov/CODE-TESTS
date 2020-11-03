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
