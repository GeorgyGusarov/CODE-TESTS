package AlgorithmsAndDatastructures.DataStructures;

public class HelloByeExample {
    public static void main(String[] args) {
        hello("Artem");
    }

    private static void hello(String name) {
        System.out.println("Hello, " + name + "!");
        bye(name);
    }

    private static void bye(String name) {
        System.out.println("Good bye, " + name + "!");
    }

}
