package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger(ComputerPlayer.class, "ComputerPlayer");

    private final String name;
    private long nbGuess;

    public ComputerPlayer(String name) {
        this.name = name;
        this.nbGuess = 0;
    }

    public String getName () {
        return this.name;
    }

    public long getNbGuess() {
        return nbGuess;
    }

    @Override
    public void playerGuessNumber() {
        this.nbGuess ++;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log("Number " + this.getNbGuess() + " is " + (lowerOrGreater ? "lower" : "greater"));
    }
}
