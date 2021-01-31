package Geekbrains_Java3.Lesson_7;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        /**
         * инкремент, который будет увеличиваться при каждом шаге спирали
         */
        int k = 1;
        /**
         * 4 направления движения: вправо, вниз, влево, наверх.
         */
        int direction = 0;
        /**
         * линии змейки: внешняя, внутренняя1, внутренняя2 и т.д.
         * эта переменная нужна для контроля линий, чтобы пройдя вправо, вниз, влево, вверх
         * мы не пошли вправо по тому же пути, что и в начале
         */
        int iteration = 0;
        /**
         * пользователь может ввести количество строк и столбцов
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * данный для строк и столбцов получаем из ввода пользователя
         */
        int sizeX = scanner.nextInt();
        int sizeY = scanner.nextInt();

        int array[][] = new int[sizeY][sizeX];

        for (int n = 0; k <= sizeX * sizeY; n++) {
            direction = n % 4;  // определение направления. i = 0, и остаток от / на 4 = 0
            iteration = n / 4;  // i / 4 = 0/Все это приводит нас к первому блоку case0 :
            switch (direction) {
                case 0:
                    for (int j = iteration; j < sizeX - iteration; j++, k++) {
                        /**
                         * 1 значение двумерного массива - это строки, 2 столбцы
                         * т.е. заполняем первую строку значениями 1, 2, 3, 4, 5...
                         */
                        array[iteration][j] = k;
                    }
                    break;
                case 1:
                    for (int j = iteration + 1; j < sizeY - iteration; j++, k++) {
                        array[j][sizeX - iteration - 1] = k;
                    }
                    break;
                case 2:
                    for (int j = sizeX - iteration - 2; j >= iteration; j--, k++) {
                        array[sizeY - iteration - 1][j] = k;
                    }
                    break;
                case 3:
                    for (int j = sizeY - iteration - 2; j > iteration; j--, k++) {
                        array[j][iteration] = k;
                    }
                    break;
            }
        }

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (array[i][j] < 10) System.out.print(" ");
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
