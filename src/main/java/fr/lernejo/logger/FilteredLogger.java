package fr.lernejo.logger;

import java.util.function.Predicate;

public record FilteredLogger(Logger logger, Predicate<String> predicate) implements Logger {

    @Override
    public void log(String message) {
        if (predicate.test(message)) {
            logger.log(message);
        }
    }
}
