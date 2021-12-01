package fr.lernejo.logger;

public class LoggerFactory  {
    private static ConsoleLogger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = new ConsoleLogger();
        }
        return logger;
    }
}
