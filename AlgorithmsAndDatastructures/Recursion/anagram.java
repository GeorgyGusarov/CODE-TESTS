package AlgorithmsAndDatastructures.Recursion;

import java.io.*;

public class anagram {
    static int size;
    static int count;
    static char[] arr;

    static int anagramsTotal;

    public static void main(String[] args) throws IOException {
        String input = getString();
        size = input.length();
        arr = new char[input.length()];
        count = 0;

        for (int i = 0; i < size; i++){
            arr[i] = input.charAt(i);
        }
        getAnagramm(size);
        System.out.println("The word: '" + input + "' has " + anagramsTotal + " anagrams.");
    }

    public static void getAnagramm(int newSize) {
        if (newSize == 1)
            return;
        for (int i = 0; i < newSize; i++) {
            getAnagramm(newSize - 1);
            if (newSize == 2)
                display();
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int i;
        int pos = size - newSize;
        char temp = arr[pos];

        for (i = pos + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[i - 1] = temp;
    }

    public static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
        }
        anagramsTotal++;
        System.out.println("");
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
