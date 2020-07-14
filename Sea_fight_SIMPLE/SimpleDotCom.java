package Sea_fight_SIMPLE;

import java.util.ArrayList;

public class SimpleDotCom {
    private ArrayList<String> locationCells;

    /**
     * метод принимает ход пользователя в качестве параметра String,
     * проверяет его и возвращает результат ("Попал", "Мимо", "Потопил")
     */
    protected String checkYourself(String userInput) {
        String result = "Мимо";

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
            } else {
                result = "Попал";
            }
        }

        return result;
    }

    /**
     * сеттер, который принимает целочисленный массив,
     * хранящий адрес 3-ёх ячеек в виде переменных типа int
     */
    protected void setLocationCells(ArrayList<String> cellLocations) {
        locationCells = cellLocations;
    }
}