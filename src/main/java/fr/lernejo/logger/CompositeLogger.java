package fr.lernejo.logger;

public record CompositeLogger(Logger... loggers) implements Logger {

    @Override
    public void log(String message) {
        for (Logger logger : loggers) {
            logger.log(message);
        }
    }
}
