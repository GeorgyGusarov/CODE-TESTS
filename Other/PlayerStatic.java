package Other;

public class PlayerStatic {
    static int playerCount;
    private String name;

    public PlayerStatic(String n) {
        name = n;
        playerCount++;
    }
}

class PlayerStaticTest {
    public static void main(String[] args) {
        System.out.println(PlayerStatic.playerCount);

        PlayerStatic one = new PlayerStatic("Тайгер Вудс");
        System.out.println(PlayerStatic.playerCount);
    }
}
