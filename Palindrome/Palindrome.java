package Palindrome;

public class Palindrome {

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("\\W","");   //удаляем все ненужное
        StringBuilder strBuilder = new StringBuilder(text);
        strBuilder.reverse();   //переворачиваем строку
        String invertedText = strBuilder.toString();    //присваиваем перевернутую строку

        return text.equalsIgnoreCase(invertedText);    //возвращаем сравнение двух строк вне зависимости от регистра

    }

}

