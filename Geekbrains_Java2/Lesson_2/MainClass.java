package Geekbrains_Java2.Lesson_2;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int sum = 0;
        Random random = new Random();
        String[][] stringArray = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                stringArray[i][j] = String.valueOf(random.nextInt(50)); // складываем рандомное число в каждый элемент массива
            }
        }

        try {
            sum = sumArray(stringArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException ex) {
            ex.printStackTrace();
        }
        System.out.println(sum);
    }

    public static int sumArray(String[][] stringArray) {
        int sum = 0;

        if (stringArray.length != 4) throw new MyArraySizeException();  // проверяем основную длинну массива

        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != 4) throw new MyArraySizeException();   // проверяем i элемент массива
            for (int j = 0; j < stringArray[i].length; j++) {   // проверяем уже конкретный массив
                try {
                    sum += Integer.parseInt(stringArray[i][j]); // берем конкретный элемент массива и преобразовываем
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("wrong size!");   // прокидываем родительское сообщение
    }
}

class MyArrayDataException extends RuntimeException {
    int row, column;

    public MyArrayDataException(int row, int column) {
        super(row + " " + column);  // прокидываем родительское сообщение
        this.row = row;
        this.column = column;
    }
}
