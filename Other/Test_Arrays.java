package Other;

public class Test_Arrays {
    public static void main(String[] args) {
        int[] index = new int[4];
        index[0] = 1;
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;

        String[] islands = new String[4];
        islands[0] = "Бермуды";
        islands[1] = "Фиджи";
        islands[2] = "Азорские острова";
        islands[3] = "Косумель";

        int y = 0;
        int ref;

        while (y < index.length) {
            ref = index[y];
            System.out.println("острова = " + islands[ref]);
            y++;
        }
    }
}