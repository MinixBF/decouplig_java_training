package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final String callerClass;
    private final Logger delegateLogger;

    public ContextualLogger(String loggingClass, Logger logger) {
        callerClass = loggingClass;
        delegateLogger = logger;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + callerClass + " " + message);
    }
}
