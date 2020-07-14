package Other;

public class Hobbits {
    protected String name;

    public static void main(String[] args) {
        Hobbits[] hobbits = new Hobbits[3];
        int z = -1;
        while (z < 2) {
            z = z + 1;
            hobbits[z] = new Hobbits();
            hobbits[z].name = "Бильбо";

            if (z == 1) hobbits[z].name = "Фродо";
            if (z == 2) hobbits[z].name = "Сэм";

            System.out.print(hobbits[z].name + " - ");
            System.out.println("имя хорошего хоббита");
        }
    }
}
