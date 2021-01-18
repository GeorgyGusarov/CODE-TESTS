package Geekbrains_Java3.Lesson_6;

import java.util.logging.*;

public class Logs {
    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) {
        logger.setLevel(Level.ALL);
        logger.getHandlers()[0].setLevel(Level.ALL);

        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.getHandlers()[0].setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getMessage().startsWith("Java");
            }
        });

        logger.log(Level.SEVERE, "Java");
        logger.log(Level.INFO, "C#");
        logger.log(Level.CONFIG, "PHP");
        logger.log(Level.FINE, "C++");
    }
}
