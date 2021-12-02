package fr.lernejo.guessgame;

import java.io.InputStream;

public interface Player {
    void playerGuessNumber(InputStream in);

    /**
     * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
     */
    void respond(boolean lowerOrGreater);
}
