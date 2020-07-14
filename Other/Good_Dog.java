package Other;

public class Good_Dog {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    void bark() {
        if (size > 60) {
            System.out.println("Гав Гав!");
        } else if (size > 14) {
            System.out.println("Вуф Вуф!");
        } else {
            System.out.println("Тяф Тяф!");
        }
    }
}

class GoodDogTestDrive {
    public static void main(String[] args) {
        Good_Dog one = new Good_Dog();
        one.setSize(70);

        Good_Dog two = new Good_Dog();
        two.setSize(8);

        System.out.println("Первая собака: " + one.getSize());
        System.out.println("Вторая собака: " + two.getSize());

        one.bark();
        two.bark();
    }
}
