package fr.lernejo.guessgame;

public enum Error {
    NO_ARGS(0, "no arguments to launch the game, restart the program with arguments (-interactive or -auto and number)."),
    UNKNOWN_ARGS(1, "unknown argument, restart the program with arguments (-interactive or -auto and number)."),
    INVALID_ARGS(2,"invalid arguments to launch the game, restart the program with arguments (-interactive or -auto and number)"),

    // COMPUTER

    // HUMAN
    INVALID_INPUT(100, "invalid input, please enter a number between 1 and 100.");

    private final int code;
    private final String description;

    Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
