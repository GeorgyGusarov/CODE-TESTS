package Other;

public class SplitTest {

    public static void main(String[] args) {
        String toTest = "Какой цвет получится при сочетании синего и желтого?/Зеленый";
        String[] result = toTest.split("/");

        for (String token : result) {
            System.out.println(token);
        }
    }
}
