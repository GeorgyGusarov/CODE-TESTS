package Geekbrains_Java3.Lesson_1_Generics;

public class LimitedTypes<T extends Number> { // сюда могу поместиться любые типы данных в рамках Number
    private T[] numbers;

    public LimitedTypes(T[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double sum = 0.0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i].doubleValue(); // можем вызвать метод doubleValues, потому что наследуемся от Number
        }
        return sum / numbers.length;
    }

    public boolean sameAverage(LimitedTypes<? super Double> another) { // тут кроме органичения, еще и ограничение "снизу", типа вниз по иерархии
        return Math.abs(this.average() - another.average()) < 0.0001;
    }
}

class LimitedTypesMain {
    public static void main(String[] args) {
        Integer iNums[] = {1, 2, 3, 4, 5};
        LimitedTypes<Integer> integerTypes = new LimitedTypes<>(iNums);
        double result1 = integerTypes.average();
        System.out.println("res1 " + result1);

        Double dNums[] = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        LimitedTypes<Double> doubleTypes = new LimitedTypes<>(dNums);
        double result2 = doubleTypes.average();
        System.out.println("res2 " + result2);

        if (integerTypes.sameAverage(doubleTypes)) {
            System.out.println("Average values are equal");
        } else {
            System.out.println("Average values aren't equal");
        }
    }
}
