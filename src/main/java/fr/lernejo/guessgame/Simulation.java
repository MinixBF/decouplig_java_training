package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger();
    private final HumanPlayer player;
    public long numberToGuess;

    public Simulation(HumanPlayer player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        this.player.playerGuessNumber();
        
        if (this.player.getNbGuess() == this.numberToGuess) {
            return true;
        }else {
            if(this.player.getNbGuess() > this.numberToGuess){
                logger.log("Number " + this.player.getNbGuess() + " is too high");
            }
            else {
                logger.log("Number " + this.player.getNbGuess() + " is too low");
            }
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        int nbTry = 0;
        while (!nextRound()) {
            nbTry++;

        }
        logger.log("Number " + this.numberToGuess + " is the right one, it took " + nbTry + " try");
    }

}
