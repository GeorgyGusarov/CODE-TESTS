package Other;

public class Dog_2 {
    protected int size;
    protected String name;

    void bark () {
        if (size > 60) {
            System.out.println("Гав Гав!");
        } else if (size > 14) {
            System.out.println("Вуф Вуф!");
        } else {
            System.out.println("Тяф Тяф!");
        }
    }
}
class Dog2TestDrive {
    public static void main(String[] args) {
        Dog_2 one = new Dog_2();
        one.size = 70;

        Dog_2 two = new Dog_2();
        two.size = 8;

        Dog_2 three = new Dog_2();
        three.size = 35;

        one.bark();
        two.bark();
        three.bark();
    }
}