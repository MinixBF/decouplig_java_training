package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger(HumanPlayer.class.getName());

    private final String name;
    private long nbGuess;


    public HumanPlayer(String name) {
        this.name = name;
        this.nbGuess = 0;
    }

    public String getName () {
        return this.name;
    }

    public long getNbGuess() {
        return nbGuess;
    }

    public void playerGuessNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your guess ?");
        try {
            this.nbGuess = scanner.nextLong();
        }
        catch (Exception e) {
            this.nbGuess = 0;
            logger.log(Error.INVALID_INPUT.toString());
            // throw  new IllegalArgumentException("Invalid number");
        }
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log("Number " + this.getNbGuess() + " is " + (lowerOrGreater ? "lower" : "greater"));
    }
}
