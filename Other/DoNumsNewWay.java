package Other;

import java.util.ArrayList;

public class DoNumsNewWay {

    public void doNumsNewWay() {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(3);
        int num = listOfNumbers.get(0);
    }
}

class TestBox {
    /*Integer i;
    int j;*/

    public static void main(String[] args) {
        /*TestBox t = new TestBox();
        t.go();*/

        String s = "2";
        int y = Integer.parseInt(s);
        System.out.println(s);

        double d = Double.parseDouble("420.24");
        System.out.println(d);

        boolean b = Boolean.parseBoolean("true"); // boolean b = new Boolean("true").booleanValue();
        System.out.println(b);

        double dd = 42.5;
        String doubleString = "" + dd;
        System.out.println(doubleString);

        double dd2 = 42.5;
        String doubleString2 = Double.toString(dd2);
        System.out.println(doubleString2);
    }

    /*public void go() {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }*/
}
