package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.io.InputStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger(HumanPlayer.class, "HumanPlayer");

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
            System.out.println("Please enter a number");
            // throw  new IllegalArgumentException("Invalid number");
        }
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log("Number " + this.getNbGuess() + " is " + (lowerOrGreater ? "lower" : "greater"));
    }
}
