package Other;

import java.util.ArrayList;

public class ArrayList_Magnet {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add(0, "ноль");
        a.add(1, "один");
        a.add(2, "два");
        a.add(3, "три");

        printAl(a);

        if (a.contains("три")) {
            a.add("четыре");
        }
        a.remove(2);

        printAl(a);

        if (a.indexOf("четыре") != 4) {
            a.add(4, "4.2");
        }

        printAl(a);

        if (a.contains("три")) {
            a.add("2.2");
        }

        printAl(a);
    }

    private static void printAl(ArrayList<String> al) {
        for (String element : al) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }
}
