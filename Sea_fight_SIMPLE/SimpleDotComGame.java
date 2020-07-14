package Sea_fight_SIMPLE;

import java.util.ArrayList;

public class SimpleDotComGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();

        int randomNum = (int) (Math.random() * 5);
        ArrayList<Integer> locations = new ArrayList<Integer>();
        locations.add(randomNum);

        boolean isAlive = true;

        while (isAlive == true) {
            String guess = helper.getUserInput("Введите число от 0 до 7");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }
        }
    }
}
