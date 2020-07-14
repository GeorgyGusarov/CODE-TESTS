package Other;

public class Duck {
    int size;
    String name;

    public Duck() {

    }

    public Duck(int duckSize) { // конструктор
        System.out.print("Кря");
        this.size = duckSize;
        System.out.println(" Размер равен " + duckSize);
    }

    public Duck(String duckName) {
        this.name = duckName;
        System.out.println(duckName);
    }

    public Duck(int duckSize, String duckName) {
        this.name = duckName;
        this.size = duckSize;
        System.out.println("Размер равен " + duckSize + " и зовут утку " + duckName);
    }

    public Duck(String duckName, int duckSize) {
        this.name = duckName;
        this.size = duckSize;
        System.out.println("Размер равен " + duckSize + " и зовут утку " + duckName);
    }
}

class UseDuck {
    public static void main(String[] args) {
        int newSize = 45;
        String newName = "Фродо";

        Duck[] d = new Duck[3];
        d[0] = new Duck(45);
        d[1] = new Duck(newSize, newName);
        d[2] = new Duck(newName);
    }
}
