package Other;

public class MonsterTestDrive {
    public static void main(String[] args) {
        Monster[] ma = new Monster[3];
        ma[0] = new Vampire();  // Вызываем переопределенный метод в Vampire
        ma[1] = new Dragon();   // Вызываем переопределенный метод в Dragon
        ma[2] = new Monster();  // Вызываем переопределенный метод в Monster

        for (int x = 0; x < 3; x++) {
            ma[x].frighten(x);
        }
    }
}

class Monster {

    boolean frighten(int d) {
        System.out.println("Гррррррр");
        return false;
    }
}

class Vampire extends Monster {

    @Override
    boolean frighten(int x) {
        System.out.println("Укусить?");
        return true;
    }
}

class Dragon extends Monster {

    @Override
    boolean frighten(int degree) {
        System.out.println("Огненное дыхание");
        return true;
    }
}