package AlgorithmsAndDatastructures.DataStructures;

import java.io.*;

public class Brackets_II {
    private String input;

    public Brackets_II(String in) {
        input = in;
    }

    public void check() {
        int size = input.length();
        StackTest st = new StackTest(size);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch(ch) {
                case '[':
                case '{':
                case '(':
                    st.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (!st.isEmpty()) {
                        char chr = (char) st.pop();
                        if ((ch == '}' && chr != '{') ||
                            (ch == ']' && chr != '[') ||
                            (ch == ')' && chr != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!st.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}

class Brackets_IITest {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            input = getString();
            if (input.equals("")) break;
            Brackets_II br = new Brackets_II(input);
            br.check();
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

}
