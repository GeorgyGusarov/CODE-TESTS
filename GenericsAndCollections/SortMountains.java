package GenericsAndCollections;

import java.util.*;

public class SortMountains {

    public static void main(String[] args) {
        new SortMountains().go();
    }

    LinkedList<Mountain> mountains = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain> {
        @Override
        public int compare(Mountain one, Mountain two) {
            return one.name.compareTo(two.name);
        }
    }

    class HeightCompare implements Comparator<Mountain> {
        @Override
        public int compare(Mountain one, Mountain two) {
            return (two.height - one.height);
        }
    }

    public void go() {
        mountains.add(new Mountain("Лонг-Рейндж", 14255));
        mountains.add(new Mountain("Эльберт", 14433));
        mountains.add(new Mountain("Марун", 14156));
        mountains.add(new Mountain("Касл", 14265));
        System.out.println("В порядке добавления:\n" + mountains);

        NameCompare nameCompare = new NameCompare();
        Collections.sort(mountains, nameCompare);
        System.out.println("По названию:\n" + mountains);

        HeightCompare heightCompare = new HeightCompare();
        Collections.sort(mountains, heightCompare);
        System.out.println("По высоте:\n" + mountains);
    }
}

class Mountain {
    String name;
    int height;

    Mountain(String n, int h) {
        name = n;
        height = h;
    }

    @Override
    public String toString() {
        return name + " " + height;
    }
}
