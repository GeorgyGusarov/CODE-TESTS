package AlgorithmsAndDatastructures;

public class MainClass {
    public static void main(String[] args) {
        int a = 10; // локальный примитив, хранится в стэке
        Cat cat;  // идентификатор. Он будет примитивным
        cat = new Cat();  // объект, хранится в куче

        method1(cat);
        method2(a); // копируем значение в метод
        method3(new int[] {1, 2, 3});
        method4(new int[] {3, 2, 1});

        int[] array = {5, 1, 4, -2, 0, 3};
        System.out.println(arrayMean(array));
        System.out.println(arrMin(array));
        System.out.println(power(2,4));
        System.out.println(pe(2, 4));
    }

    private static class Cat {
        int age = 5;    // локальный примитив, но он будет храниться в куче вместе с объектом Cat
        String name = "Barsik";
    }

    private static void method1(Cat cat) {
        System.out.println("cats age = " + cat.age);
    }

    private static void method2(int a) {    // 10
        System.out.println("a = " + a);
    }
    
    private static void method3(int[] arr) {    // сложность данного алгоритма будет = N^2
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }

    private static void method4(int[] arr) {    // сложность данного алгоритма = 2N (2 прохода по массиву)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) arr[i]++;
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /**
     * Возведение в степень
     * @param base основание
     * @param sign показатель степени
     * @return result
     */
    private static int power(int base, int sign) {
        int result = 1; // вернем 1, если степень 0
        for (int i = 0; i < sign; i++) result *= base;
        return result;
    }

    /**
     * Возведение в степень (*используя чётность степени)
     * @param base основание
     * @param sign показатель степени
     * @return result
     */
    private static int pe(int base, int sign) {
        int result = 1; // вернем 1, если степень 0
        while (sign > 0) {
            if (sign % 2 == 0) {
                sign /= 2;  // 2^4 = 4^2 = 16^1
                base *= base;
            } else {
                sign -= 1;
                result *= base;
            }
        }
        return result;
    }

    /**
     * Поиск минимального элемента в массиве
     */
    private static int arrMin(int[] arr) {
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < result) result = arr[i];
        }
        return result;
    }

    /**
     * Нахождение среднего арифметического массива
     */
    private static float arrayMean(int[] arr) {
        float result = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) result += arr[i];
        return result;
    }
}
