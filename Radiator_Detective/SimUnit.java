package Radiator_Detective;

public class SimUnit {
    String botType;

    SimUnit(String type) {
        botType = type;
    }

    int powerUse() {
        if ("Тепловая маштна".equals(botType)) {
            return 2;
        } else {
            return 4;
        }
    }
}
