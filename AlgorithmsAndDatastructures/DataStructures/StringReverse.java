package AlgorithmsAndDatastructures.DataStructures;

import AlgorithmsAndDatastructures.DataStructures.StackTest;

public class StringReverse {
    private static String fancyReverse(String s) {
        StackTest stack = new StackTest(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));    // добавляем каждый символ в стек
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append((char) stack.pop()); // кладем в sb то,что вытащили с помощью pop

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fancyReverse("HelloWorld"));
    }
}
