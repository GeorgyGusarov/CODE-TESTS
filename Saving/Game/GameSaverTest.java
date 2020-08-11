package Saving.Game;

import java.io.*;

public class GameSaverTest {

    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Эльф", new String[] {"лук", "меч", "кастет"});
        GameCharacter two = new GameCharacter(200, "Троль", new String[] {"голые руки", "большой топор"});
        GameCharacter three = new GameCharacter(120, "Маг", new String[] {"заклинания", "невидимость"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestored = (GameCharacter) is.readObject();
            GameCharacter twoRestored = (GameCharacter) is.readObject();
            GameCharacter threeRestored = (GameCharacter) is.readObject();

            System.out.println("Тип первого: " + oneRestored.getType() + " с оружием " + oneRestored.getWeapons());
            System.out.println("Тип второго: " + twoRestored.getType()  + " с оружием " + twoRestored.getWeapons());
            System.out.println("Тип третьего: " + threeRestored.getType() + " с оружием " + threeRestored.getWeapons());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
