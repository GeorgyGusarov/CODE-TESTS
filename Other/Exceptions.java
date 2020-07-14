package Other;

public class Exceptions {
    public static void main(String[] args) {
        int array[] = {5, 23, 7};

        try {
            int x = 100 / 0;                // но на 0 делить нельзя, будет ошибка
            System.out.println(array[2]);   // попробуем вывести не существующий элемент массива и создаем для ошибки новый catch
        } catch (ArithmeticException e) {   // ловим арифметическую ошибку, называем ее "e"
            System.out.println("Нельзя делить на ноль! " + e);
        } catch (Exception e) {             // Exception ловит все возможные исключения
            System.out.println("Error: " + e);
        } finally {                         // finally существует даже без его указания. Так же он стопит выполнение.
            System.out.println("Finally");
        }
        // после ловли первой ошибки программа останавливается. Ошибка дальше по покажется
    }
}
