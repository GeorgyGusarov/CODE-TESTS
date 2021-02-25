package Geekbrains_Java2.Lesson_2_Exceptions;

public class FactorialException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public FactorialException(String msg, int number) {
        super(msg);
        this.number = number;
    }
}

class Factorial {
    public static int getFactorial(int num) throws FactorialException {
        int res = 1;
        if (num < 1) throw new FactorialException("Число не может быть меньше 1", num);

        for (int i = 1; i <= num ; i++) {
            res *=i;
        }

        return res;
    }
}

class MainExFactorial {
    public static void main(String[] args) {
        try {
            int res = Factorial.getFactorial(-10);
        } catch (FactorialException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}