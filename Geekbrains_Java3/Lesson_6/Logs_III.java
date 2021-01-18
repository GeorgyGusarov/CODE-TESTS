package Geekbrains_Java3.Lesson_6;

import java.util.logging.Logger;

public class Logs_III {
    public static void main(String[] args) {
        Logger admin = Logger.getLogger("admin");

        int a = 0;
        try {
            int b = 10 / a;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            admin.info(e.getMessage() + " Ошибка вычисления");
        }

        admin.info("This is info");
        admin.warning("This is warning");

    }
}
