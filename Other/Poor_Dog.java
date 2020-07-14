package Other;

public class Poor_Dog {
    private int size;
    private String name;

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}

class PoorDogTestDrive {
    public static void main(String[] args) {
      Poor_Dog one = new Poor_Dog();
      System.out.println("Размер собаки - " + one.getSize());
      System.out.println("Имя собаки - " + one.getName());
    }
}
