package Geekbrains_Java3.Lesson_6;

import java.io.*;
import java.util.logging.*;

public class Logs_II {
    private static final Logger logger = Logger.getLogger(Geekbrains_Java3.Lesson_6.Logs.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.ALL);
        logger.getHandlers()[0].setLevel(Level.ALL);

        Handler handler = new FileHandler("MyLogsFile.log", true);
        handler.setLevel(Level.ALL);
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.addHandler(handler);

        logger.log(Level.SEVERE, "Java");
        logger.log(Level.INFO, "C#");
        logger.log(Level.CONFIG, "PHP");
        logger.log(Level.FINE, "C++");

    }
}
