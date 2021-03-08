package AlgorithmsAndDatastructures.DataStructures;

import java.security.SecureRandom;
import java.util.*;

/**
 * 1. Создать и запустить программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 10 000 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */
public class TreeMain {
    public static void main(String[] args) {
        final int TREES = 20;
        int balanced = 0;
        for (int i = 0; i < TREES; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            uniqueRandom(a, 10000);
            Tree tree = new Tree(a);
            balanced += (tree.isBalanced(false)) ? 1 : 0;
        }
        System.out.println(balanced * 100f / TREES + "%");
    }

    private static void uniqueRandom(ArrayList<Integer> a, int amount) {
        Random r = new Random();
        SecureRandom sr = new SecureRandom();

        while (a.size() < amount) {
            int num = sr.nextInt();
            if (!a.contains(num)) a.add(num);
        }
    }
}
