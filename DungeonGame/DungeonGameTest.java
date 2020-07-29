package DungeonGame;

import java.io.*;

public class DungeonGameTest {

    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();
        System.out.println(game.getX() + game.getY() + game.getZ());

        try {
            FileOutputStream fos = new FileOutputStream("DungeonGameSave.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game);
            oos.close();

            FileInputStream fis = new FileInputStream("DungeonGameSave.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (DungeonGame) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(game.getX() + game.getY() + game.getZ());
    }
}
