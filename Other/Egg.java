package Other;

import java.util.ArrayList;

public class Egg {
    public static void main(String[] args) {
        ArrayList<Egg> myList = new ArrayList<Egg>();

        Egg s = new Egg();
        myList.add(s);

        Egg b = new Egg();
        myList.add(b);

        int theSize = myList.size();
        boolean isIn = myList.contains(s);
        int idx = myList.indexOf(b);
        boolean empty = myList.isEmpty();
        myList.remove(s);

        System.out.println(myList);
    }
}
